package com.demoyageek.practica_springboot.Repositories;
import com.demoyageek.practica_springboot.Entities.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {

    List<Equipo> findAllByActivoAndCantidadGreaterThan(Boolean aBoolean, int cantidad);

    Equipo findById(long id);
}
