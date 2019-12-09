package com.demoyageek.practica_springboot.Services;
import com.demoyageek.practica_springboot.Entities.Rol;
import com.demoyageek.practica_springboot.Repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * RolServices
 */
@Service
public class RolServices {

    @Autowired
    RolRepository rolRepository;

    @Transactional
    public void crearRol(Rol rol) {

        rolRepository.save(rol);
    }

    public List<Rol> listaRoles() {

        return rolRepository.findAll();
    }


}