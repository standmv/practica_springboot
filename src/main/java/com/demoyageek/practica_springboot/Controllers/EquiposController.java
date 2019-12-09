package com.demoyageek.practica_springboot.Controllers;

import com.demoyageek.practica_springboot.Entities.Equipo;
import com.demoyageek.practica_springboot.Services.EquipoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@Controller
public class EquiposController {

    @Autowired
    EquipoServices equipoServices;

    @Autowired
    MessageSource messageSource;

    @RequestMapping("/index/equipos")
    public String equipos(Model model, Locale locale) {
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

        model.addAttribute("nuevo_equipo", messageSource.getMessage("nuevo_equipo", null, locale));
        model.addAttribute("disponible", messageSource.getMessage("disponible", null, locale));


        model.addAttribute("tabla_nombre", messageSource.getMessage("tabla_nombre", null, locale));
        model.addAttribute("tabla_foto", messageSource.getMessage("tabla_foto", null, locale));
        model.addAttribute("tabla_tarifa", messageSource.getMessage("tabla_tarifa", null, locale));
        model.addAttribute("tabla_familia", messageSource.getMessage("tabla_familia", null, locale));
        model.addAttribute("tabla_subFamilia", messageSource.getMessage("tabla_sub_familia", null, locale));
        model.addAttribute("tabla_cantidad", messageSource.getMessage("tabla_cantidad", null, locale));
        model.addAttribute("tabla_acciones", messageSource.getMessage("tabla_acciones", null, locale));


        return "/freemarker/equipos";
    }

    @ResponseBody
    @RequestMapping(value = "/equiposDisponibles", produces = {"application/json"})
    public List<Equipo> equiposDisponibles() {
        return equipoServices.buscarEquiposDisponibles();
    }

    @ResponseBody
    @RequestMapping(value = "/equipos", produces = {"application/json"})
    public List<Equipo> equipos() {
        return equipoServices.buscarEquipos();
    }

    @RequestMapping(value = "/equipo/crear", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<List<Equipo>> crearEquipo(@RequestBody List<Equipo> equipoList) {

        for (Equipo equipo : equipoList) {

            equipoServices.crearEquipo(equipo);
        }

        return new ResponseEntity<>(equipoList, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/equipo/buscar/{id}", method = RequestMethod.GET)
    public Equipo buscarEquipo(@PathVariable(value = "id") long id) {


        return equipoServices.buscarEquipo(id);


    }

    @ResponseBody
    @RequestMapping(value = "/equipo/eliminar/{id}", method = RequestMethod.POST)
    public ResponseEntity<Long> eliminarEquipo(@PathVariable(value = "id") long id) {

        System.out.println("id:  " + id);
        Equipo equipo = equipoServices.buscarEquipo(id);
        equipoServices.eliminarEquipo(equipo);

        return new ResponseEntity<>(id, HttpStatus.OK);

    }


}
