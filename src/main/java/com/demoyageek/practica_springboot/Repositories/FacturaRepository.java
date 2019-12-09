package com.demoyageek.practica_springboot.Repositories;
import com.demoyageek.practica_springboot.Entities.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {

    Factura findById(long id);

}
