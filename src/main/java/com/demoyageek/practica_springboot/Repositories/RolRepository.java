package com.demoyageek.practica_springboot.Repositories;
import com.demoyageek.practica_springboot.Entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

    Rol findByNombre(String nombre);
}
