package com.demoyageek.practica_springboot.Controllers;

import java.util.List;
import java.util.Locale;

import com.demoyageek.practica_springboot.Services.RolServices;
import com.demoyageek.practica_springboot.Services.UsuarioServices;
import com.demoyageek.practica_springboot.Entities.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * UsuariosController
 */
@Controller()
public class UsuariosController {

    @Autowired
    UsuarioServices usuariosServices;

    @Autowired
    RolServices rolServices;

    @Autowired
    MessageSource messageSource;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


    @RequestMapping("/index/usuarios")
    public String usuarios(Model model, Locale locale) {

        model.addAttribute("titulo_inicio", messageSource.getMessage("titulo_inicio", null, locale));
        model.addAttribute("titulo_clientes", messageSource.getMessage("titulo_clientes", null, locale));
        model.addAttribute("titulo_usuarios", messageSource.getMessage("titulo_usuarios", null, locale));
        model.addAttribute("titulo_equipos", messageSource.getMessage("titulo_equipos", null, locale));
        model.addAttribute("titulo_alquileres", messageSource.getMessage("titulo_alquileres", null, locale));
        model.addAttribute("titulo_reportes", messageSource.getMessage("titulo_reportes", null, locale));


        model.addAttribute("boton_crear", messageSource.getMessage("boton_crear", null, locale));
        model.addAttribute("boton_editar", messageSource.getMessage("boton_editar", null, locale));
        model.addAttribute("boton_eliminar", messageSource.getMessage("boton_eliminar", null, locale));
        model.addAttribute("boton_cerrar", messageSource.getMessage("boton_cerrar", null, locale));


        model.addAttribute("mostrando", messageSource.getMessage("mostrando", null, locale));
        model.addAttribute("a", messageSource.getMessage("a", null, locale));
        model.addAttribute("de", messageSource.getMessage("de", null, locale));
        model.addAttribute("registros", messageSource.getMessage("registros", null, locale));

        model.addAttribute("nuevo_usuario", messageSource.getMessage("nuevo_usuario", null, locale));
        model.addAttribute("contra", messageSource.getMessage("contra", null, locale));
        model.addAttribute("permisos", messageSource.getMessage("permisos", null, locale));


        model.addAttribute("tabla_nombre", messageSource.getMessage("tabla_nombre", null, locale));
        model.addAttribute("tabla_acciones", messageSource.getMessage("tabla_acciones", null, locale));
        model.addAttribute("tabla_usuario", messageSource.getMessage("tabla_usuario", null, locale));

        return "/freemarker/usuarios";
    }

    @ResponseBody
    @RequestMapping(value = "/usuarios", produces = { "application/json" })
    public List<Usuario> usuarios() {
        return usuariosServices.obtenerUsuarios();
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/usuario/crear", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<List<Usuario>> crearUsuario(@RequestBody List<Usuario> usuarioList) {

        for (Usuario usuario : usuarioList) {

            usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
            usuariosServices.guardarUsuario(usuario);
        }

        return new ResponseEntity<>(usuarioList, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/usuario/eliminar/{id}", method = RequestMethod.POST)
    public ResponseEntity<Long> eliminarUsuario(@PathVariable(value ="id") long id) {

        System.out.println("id:  " + id);
        usuariosServices.eliminarUsuario(id);

        return new ResponseEntity<>(id, HttpStatus.OK);

    }



}