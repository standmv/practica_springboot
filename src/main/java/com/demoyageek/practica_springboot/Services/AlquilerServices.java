package com.demoyageek.practica_springboot.Services;
import com.demoyageek.practica_springboot.Entities.Alquiler;
import com.demoyageek.practica_springboot.Entities.Cliente;
import com.demoyageek.practica_springboot.Repositories.AlquilerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class AlquilerServices {

    @Autowired
    AlquilerRepository alquilerRepository;

    @Transactional
    public void crearAlquiler(Alquiler alquiler){

        alquilerRepository.save(alquiler);
    }

    public List<Alquiler> listaAlquileres(){

        return alquilerRepository.findAllByPendienteOrderByFechaEntregaDesc(true);
    }

    public List<Alquiler> alquilerCliente(Cliente cliente){
        return alquilerRepository.findAllByCliente(cliente);
    }

    public Alquiler buscarAlquiler(long id){

        return alquilerRepository.findById(id);
    }

    public List<Map<Long, Long>> reporteAlquiler(){
        return alquilerRepository.reporteCliente();
    }

    public  List<Map<String, Map.Entry<String, Boolean>>> reporteEquipos(){
        return alquilerRepository.reporteEquipo();
    }


}
