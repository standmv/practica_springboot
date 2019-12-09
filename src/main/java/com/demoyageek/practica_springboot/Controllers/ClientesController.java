package com.demoyageek.practica_springboot.Controllers;

import java.util.List;
import java.util.Locale;

import com.demoyageek.practica_springboot.Entities.Cliente;
import com.demoyageek.practica_springboot.Services.ClienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * ClientesController
 */
@Controller
public class ClientesController {

    @Autowired
    private ClienteServices clienteServices;

    @Autowired
    MessageSource messageSource;

    @RequestMapping("/index/clientes")
    public String clientes(Model model, Locale locale) {

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

        model.addAttribute("nuevo_cliente", messageSource.getMessage("nuevo_cliente", null, locale));


        model.addAttribute("tabla_cedula", messageSource.getMessage("tabla_cedula", null, locale));
        model.addAttribute("tabla_foto", messageSource.getMessage("tabla_foto", null, locale));
        model.addAttribute("tabla_nombre", messageSource.getMessage("tabla_nombre", null, locale));
        model.addAttribute("tabla_telefono", messageSource.getMessage("tabla_telefono", null, locale));
        model.addAttribute("tabla_correo", messageSource.getMessage("tabla_correo", null, locale));
        model.addAttribute("tabla_acciones", messageSource.getMessage("tabla_acciones", null, locale));



        return "/freemarker/clientes";
    }


    @RequestMapping(value = "/clientes/crear", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<List<Cliente>> crearCliente(@RequestBody List<Cliente> clientesList) {

        for (Cliente cliente : clientesList) {

            clienteServices.crearCliente(cliente);

        }

        return new ResponseEntity<>(clientesList, HttpStatus.OK);
    }


    @ResponseBody
    @RequestMapping(value = "/clientes", produces = {"application/json"})
    public List<Cliente> clientes() {
        return clienteServices.listaClientes();
    }

    @ResponseBody
    @RequestMapping(value = "/cliente/{id}", produces = {"application/json"})
    public Cliente buscarCliente(@PathVariable(value = "id") long id) {
        return clienteServices.buscarCliente(id);
    }

    @RequestMapping(value = "/cliente/eliminar/{id}", method = RequestMethod.POST)
    public ResponseEntity<Long> eliminarCliente(@PathVariable(value = "id") long id) {


        Cliente cliente = clienteServices.buscarCliente(id);

        clienteServices.eliminarCliente(cliente);


        return new ResponseEntity<>(id, HttpStatus.OK);

    }

}