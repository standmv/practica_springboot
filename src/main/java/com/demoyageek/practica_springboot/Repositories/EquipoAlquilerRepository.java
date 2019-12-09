package com.demoyageek.practica_springboot.Repositories;
import com.demoyageek.practica_springboot.Entities.Equipo;
import com.demoyageek.practica_springboot.Entities.EquipoAlquiler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoAlquilerRepository extends JpaRepository<EquipoAlquiler, Long> {

    EquipoAlquiler findById(long id);
    EquipoAlquiler findByEquipo(Equipo equipo);

}
