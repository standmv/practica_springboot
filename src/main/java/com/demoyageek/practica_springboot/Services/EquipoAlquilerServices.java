package com.demoyageek.practica_springboot.Services;
import com.demoyageek.practica_springboot.Entities.Equipo;
import com.demoyageek.practica_springboot.Entities.EquipoAlquiler;
import com.demoyageek.practica_springboot.Repositories.EquipoAlquilerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class EquipoAlquilerServices {

    @Autowired
    EquipoAlquilerRepository equipoAlquilerRepository;

    @Transactional
    public void crearEquipoAlquiler(EquipoAlquiler equipoAlquiler) {

        equipoAlquilerRepository.save(equipoAlquiler);

    }

    public List<Equipo> obtenerEquiposAlquiler(Set<EquipoAlquiler> equipoAlquilerSet) {

        List<Equipo> equipoList = new ArrayList<>();

        for (EquipoAlquiler equipoAlquiler : equipoAlquilerSet) {

            equipoList.add(equipoAlquiler.getEquipo());

        }

        return equipoList;
    }

    public EquipoAlquiler buscarEquipoAlquilerById(long id){

        return equipoAlquilerRepository.findById(id);
    }


    public void devolverEquipo(long id){

        EquipoAlquiler equipoAlquiler = equipoAlquilerRepository.findById(id);
        equipoAlquiler.setDevuelto(!equipoAlquiler.getDevuelto());
        equipoAlquilerRepository.save(equipoAlquiler);

    }
}
