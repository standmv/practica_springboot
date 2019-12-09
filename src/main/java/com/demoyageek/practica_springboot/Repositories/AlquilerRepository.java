package com.demoyageek.practica_springboot.Repositories;
import com.demoyageek.practica_springboot.Entities.Alquiler;
import com.demoyageek.practica_springboot.Entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AlquilerRepository extends JpaRepository<Alquiler, Long> {

    Alquiler findById(long id);

    List<Alquiler> findAllByCliente(Cliente cliente);

    List<Alquiler> findAllByPendienteOrderByFechaEntregaDesc(Boolean aBoolean);

    @Query(value = "select c.ID as cliente, count(*) as cantidad from Alquiler a, Cliente c where a.CLIENTE_ID = c.ID group by c.ID", nativeQuery = true)
    List<Map<Long, Long>> reporteCliente();

    @Query(value = "select E.FAMILIA as Familia, E.SUB_FAMILIA as subFamilia, AVG(DATEDIFF(day,FECHA, FECHA_ENTREGA)) as Promedio  from ALQUILER A, ALQUILER_EQUIPO_ALQUILER AEA , EQUIPO_ALQUILER EA , EQUIPO E where A.ID = AEA.ALQUILER_ID and AEA.EQUIPO_ALQUILER_ID = EA.ID and EA.EQUIPO_ID = E.ID group by E.FAMILIA, E.SUB_FAMILIA", nativeQuery = true)
    List<Map<String, Map.Entry<String, Boolean>>> reporteEquipo();



}
