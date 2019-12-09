package com.demoyageek.practica_springboot.Services;
import com.demoyageek.practica_springboot.Entities.Cliente;
import com.demoyageek.practica_springboot.Repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ClienteServices
 */
@Service
public class ClienteServices {

    @Autowired
    ClienteRepository clienteRepository;

    @Transactional
    public void crearCliente(Cliente cliente) {

        clienteRepository.save(cliente);

    }

    @Transactional
    public void eliminarCliente(Cliente cliente){

        cliente.setActivo(false);
        clienteRepository.save(cliente);
    }

    public Cliente buscarCliente(long id){

        return clienteRepository.findById(id);
    }

    public List<Cliente> listaClientes() {

        return clienteRepository.findAllByActivo(true);
    }


}