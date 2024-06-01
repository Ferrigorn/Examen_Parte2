/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.examenproyecto2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author fbabu
 */
public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer>{
    @Query("select AVG(v.potencia) from Vehiculo v where v.tipo = :tipo")
    Double findMediaPotenciaByTipo(@Param("tipo") String tipo);
    
    @Query("SELECT MAX(v.potencia) FROM Vehiculo v WHERE v.tipo = :tipo")
    Double findMaxPotenciaByTipo(@Param("tipo") String tipo);
}
