package com.demoyageek.practica_springboot.Controllers;
import com.demoyageek.practica_springboot.Entities.Alquiler;
import com.demoyageek.practica_springboot.Entities.AlquilerParametro;
import com.demoyageek.practica_springboot.Entities.Cliente;
import com.demoyageek.practica_springboot.Entities.EquipoAlquiler;
import com.demoyageek.practica_springboot.Services.*;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

@Controller
public class AlquilerController {

    @Autowired
    AlquilerServices alquilerServices;

    @Autowired
    ClienteServices clienteServices;

    @Autowired
    EquipoServices equipoServices;

    @Autowired
    EquipoAlquilerServices equipoAlquilerServices;

    @Autowired
    MessageSource messageSource;

    @RequestMapping("/index/alquileres")
    public String alquileres(Model model, Locale locale) {
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
        model.addAttribute("boton_facturar", messageSource.getMessage("boton_facturar", null, locale));


        model.addAttribute("mostrando", messageSource.getMessage("mostrando", null, locale));
        model.addAttribute("a", messageSource.getMessage("a", null, locale));
        model.addAttribute("de", messageSource.getMessage("de", null, locale));
        model.addAttribute("registros", messageSource.getMessage("registros", null, locale));

        model.addAttribute("nuevo_equipo", messageSource.getMessage("nuevo_equipo", null, locale));
        model.addAttribute("nuevo_alquiler", messageSource.getMessage("nuevo_alquiler", null, locale));
        model.addAttribute("tabla_fecha_entrega", messageSource.getMessage("tabla_fecha_entrega", null, locale));
        model.addAttribute("titulo_equipos", messageSource.getMessage("titulo_equipos", null, locale));
        model.addAttribute("titulo_factura", messageSource.getMessage("titulo_factura", null, locale));
        model.addAttribute("titulo_total", messageSource.getMessage("titulo_total", null, locale));

        model.addAttribute("tabla_nombre", messageSource.getMessage("tabla_nombre", null, locale));
        model.addAttribute("tabla_foto", messageSource.getMessage("tabla_foto", null, locale));
        model.addAttribute("tabla_tarifa", messageSource.getMessage("tabla_tarifa", null, locale));
        model.addAttribute("tabla_familia", messageSource.getMessage("tabla_familia", null, locale));
        model.addAttribute("tabla_subFamilia", messageSource.getMessage("tabla_sub_familia", null, locale));
        model.addAttribute("tabla_cantidad", messageSource.getMessage("tabla_cantidad", null, locale));
        model.addAttribute("tabla_devuelto", messageSource.getMessage("tabla_devuelto", null, locale));


        model.addAttribute("tabla_fecha_entrega", messageSource.getMessage("tabla_fecha_entrega", null, locale));
        model.addAttribute("tabla_cliente", messageSource.getMessage("tabla_cliente", null, locale));
        model.addAttribute("tabla_cantidad_equipos", messageSource.getMessage("tabla_cantidad_equipos", null, locale));
        model.addAttribute("tabla_acciones", messageSource.getMessage("tabla_acciones", null, locale));


        return "/freemarker/alquileres";
    }

    @ResponseBody
    @RequestMapping(value = "/alquileres", produces = {"application/json"})
    public List<Alquiler> alquileres() {
        return alquilerServices.listaAlquileres();
    }


    @RequestMapping(value = "/alquiler/crear", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<List<AlquilerParametro>> crearAlquiler(@RequestBody List<AlquilerParametro> alquilerParametroList) {

        Alquiler alquiler = new Alquiler();
        AlquilerParametro alquilerParametro = alquilerParametroList.get(0);
        System.out.println("" + alquilerParametro.getFechaEntrega());

        int cant = 0;
        for(String s: alquilerParametro.getEquipos()){
            String[] parte = s.split(":");

            cant += Integer.parseInt(parte[1]);
        }
        Cliente cliente = clienteServices.buscarCliente(Integer.parseInt(alquilerParametro.getCliente()));
        Set<EquipoAlquiler> equipoAlquiler = equipoServices.buscarEquiposAlquiler(alquilerParametro.getEquipos());
        alquiler.setCantidadEquipos(cant);
        alquiler.setCliente(cliente);
        alquiler.setPendiente(true);

        alquiler.setEquipoAlquiler(equipoAlquiler);
        alquiler.setFecha(Date.valueOf(LocalDate.now()));
        Date fechaEntrega;
        try {

            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            sdf1.setLenient(false);
            java.util.Date date = sdf1.parse(alquilerParametro.getFechaEntrega());
            fechaEntrega = new java.sql.Date(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();

            fechaEntrega = Date.valueOf(LocalDate.now().plusDays(1));
        }

        alquiler.setFechaEntrega(fechaEntrega);

        Calendar calendarHoy = Calendar.getInstance();
        calendarHoy.setTime(java.util.Date.from(Instant.now()));

        Calendar calendarEntrega = Calendar.getInstance();
        calendarEntrega.setTime(fechaEntrega);

        DateTime dateTime = new DateTime(calendarHoy);
        DateTime dateTimeFin = new DateTime(fechaEntrega);


        int days = Days.daysBetween(dateTime, dateTimeFin).getDays();


        alquiler.setCosto(10 * days * 4);

        alquilerServices.crearAlquiler(alquiler);


        return new ResponseEntity<>(alquilerParametroList, HttpStatus.OK);

    }


    @ResponseBody
    @RequestMapping(value = "/alquiler/buscar/{id}", method = RequestMethod.GET)
    public Alquiler buscarAlquiler(@PathVariable(value = "id") long id){

        return alquilerServices.buscarAlquiler(id);
    }

    @ResponseBody
    @RequestMapping(value = "/reporte/alquiler", produces = {"application/json"})
    public List<Map<Long, Long>> reporteCliente(){

        return alquilerServices.reporteAlquiler();
    }

    @ResponseBody
    @RequestMapping(value = "/reporte/equipos", produces = {"application/json"})
    public  List<Map<String, Map.Entry<String, Boolean>>> reporteEquipos(){

        return alquilerServices.reporteEquipos();
    }


    @RequestMapping(value = "/index/alquiler/reportes", method = RequestMethod.GET)
    public String reportesAlquileres(Model model, Locale locale){

        model.addAttribute("titulo_inicio", messageSource.getMessage("titulo_inicio", null, locale));
        model.addAttribute("titulo_clientes", messageSource.getMessage("titulo_clientes", null, locale));
        model.addAttribute("titulo_usuarios", messageSource.getMessage("titulo_usuarios", null, locale));
        model.addAttribute("titulo_equipos", messageSource.getMessage("titulo_equipos", null, locale));
        model.addAttribute("titulo_alquileres", messageSource.getMessage("titulo_alquileres", null, locale));
        model.addAttribute("titulo_reportes", messageSource.getMessage("titulo_reportes", null, locale));
        model.addAttribute("titulo_reporte_clientes", messageSource.getMessage("titulo_reporte_clientes", null, locale));
        model.addAttribute("titulo_reporte_equipos", messageSource.getMessage("titulo_reporte_equipos", null, locale));



        return "/freemarker/reportes";
    }

    @ResponseBody
    @RequestMapping(value = "/alquiler/devolver/{id}", method = RequestMethod.POST)
    public ResponseEntity<Long> devolverEquipo(@PathVariable(value = "id") long id) {



        equipoAlquilerServices.devolverEquipo(id);

        return new ResponseEntity<>(id, HttpStatus.OK);

    }

}
