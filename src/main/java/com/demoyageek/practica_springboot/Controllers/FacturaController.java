package com.demoyageek.practica_springboot.Controllers;

import com.demoyageek.practica_springboot.Entities.Alquiler;
import com.demoyageek.practica_springboot.Entities.Equipo;
import com.demoyageek.practica_springboot.Entities.EquipoAlquiler;
import com.demoyageek.practica_springboot.Entities.Factura;
import com.demoyageek.practica_springboot.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller
public class FacturaController {

    @Autowired
    FacturaServices facturaServices;

    @Autowired
    AlquilerServices alquilerServices;

    @Autowired
    EquipoServices equipoServices;

    @RequestMapping("/index/facturas")
    public String index(Model model) {
        model.addAttribute("titulo", "Facturas");
        return "/freemarker/facturas";
    }

    @ResponseBody
    @RequestMapping(value = "/facturas", produces = {"application/json"})
    public List<Factura> facturas() {
        return facturaServices.listaFacturas();
    }

    @RequestMapping(value = "/factura/crear", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> crearFactura(@RequestBody String facturaAlquiler) {

        String[] parte = facturaAlquiler.split(":");

        Alquiler alquiler = alquilerServices.buscarAlquiler(Integer.parseInt(parte[0]));
        alquiler.setPendiente(false);

        for (EquipoAlquiler equipoAlquiler: alquiler.getEquipoAlquiler()){

            Equipo equipo = equipoAlquiler.getEquipo();
            equipo.setCantidad(equipo.getCantidad() + alquiler.getCantidadEquipos());
            equipoServices.crearEquipo(equipo);
        }
        alquilerServices.crearAlquiler(alquiler);

        Factura factura = new Factura();
        factura.setAlquiler(alquiler);
        factura.setFecha(Date.valueOf(LocalDate.now()));
        factura.setTotal(Integer.parseInt(parte[1]));

        facturaServices.crearFactura(factura);



        return new ResponseEntity<>(facturaAlquiler, HttpStatus.OK);

    }


}
