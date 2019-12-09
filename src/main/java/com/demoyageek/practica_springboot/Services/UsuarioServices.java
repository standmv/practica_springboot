package com.demoyageek.practica_springboot.Services;
import com.demoyageek.practica_springboot.Entities.Rol;
import com.demoyageek.practica_springboot.Entities.Usuario;
import com.demoyageek.practica_springboot.Repositories.RolRepository;
import com.demoyageek.practica_springboot.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UsuarioServices implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    //Para encriptar la información.
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    /**
     * Funcion para crear administrador
     */
    @Transactional
    public void crearAdmin() {

        if (!buscarAdmin()) {

            Rol rol = new Rol("ROLE_ADMIN");
            rolRepository.save(rol);



            Usuario admin = new Usuario();
            admin.setNombre("admin");
            admin.setUsuario("admin");
            admin.setPassword(bCryptPasswordEncoder.encode("admin"));
            admin.setActivo(true);
            admin.setRolSet(new HashSet<>(Arrays.asList(rol)));

            usuarioRepository.save(admin);
        }

    }

    @Transactional
    public void eliminarUsuario(long id) {

        Usuario usuario = usuarioRepository.findById(id);
        usuario.setActivo(false);
        usuarioRepository.save(usuario);
    }
    /**
     * Funcion para revisar si el admin existe.
     */
    private boolean buscarAdmin() {

        Rol rol = rolRepository.findByNombre("ROLE_ADMIN");
        if (rol == null){

            return false;
        }

        return true;
    }

    public List<Usuario> obtenerUsuarios() {

        return usuarioRepository.findAllByActivo(true);

    }

    @Transactional
    public void guardarUsuario(Usuario usuario) {

        usuarioRepository.save(usuario);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = usuarioRepository.findByNombre(username);

        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        for (Rol role : user.getRolSet()) {
            roles.add(new SimpleGrantedAuthority(role.getNombre()));
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);

        return new org.springframework.security.core.userdetails.User(user.getUsuario(), user.getPassword(), user.isActivo(), true, true, true, grantedAuthorities);
    }
}
