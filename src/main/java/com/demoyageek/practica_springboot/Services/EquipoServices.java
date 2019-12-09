package com.demoyageek.practica_springboot.Services;
import com.demoyageek.practica_springboot.Entities.Equipo;
import com.demoyageek.practica_springboot.Entities.EquipoAlquiler;
import com.demoyageek.practica_springboot.Repositories.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EquipoServices {

    @Autowired
    EquipoRepository equipoRepository;

    @Autowired
    EquipoAlquilerServices equipoAlquilerServices;

    @Transactional
    public void crearEquipo(Equipo equipo) {

        equipoRepository.save(equipo);

    }

    @Transactional
    public void eliminarEquipo(Equipo equipo) {

        equipo.setActivo(false);
        equipoRepository.save(equipo);

    }

    public Equipo buscarEquipo(long id) {

        return equipoRepository.findById(id);
    }

    public List<Equipo> buscarEquipos() {

        return equipoRepository.findAll();
    }

    public List<Equipo> buscarEquiposDisponibles() {

        return equipoRepository.findAllByActivoAndCantidadGreaterThan(true, 0);
    }

    public Set<EquipoAlquiler> buscarEquiposAlquiler(List<String> equipos) {


        Set<EquipoAlquiler>  equipoAlquilerSet = new HashSet<>();
        for (String s : equipos) {

            EquipoAlquiler equipoAlquiler = new EquipoAlquiler();
            String[] parte = s.split(":");

            Equipo equipo = buscarEquipo(Integer.parseInt(parte[0]));
            equipo.setCantidad(equipo.getCantidad() - Integer.parseInt(parte[1]));
            crearEquipo(equipo);

            equipoAlquiler.setEquipo(equipo);
            equipoAlquiler.setCantidad(Integer.parseInt(parte[1]));
            equipoAlquiler.setDevuelto(false);

            equipoAlquilerSet.add(equipoAlquiler);

            equipoAlquilerServices.crearEquipoAlquiler(equipoAlquiler);

        }



        return equipoAlquilerSet;
    }

}
