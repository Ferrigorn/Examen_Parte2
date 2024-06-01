/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenproyecto2;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author fbabu
 */

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
    @Autowired
    private VehiculoRepository vehiculoRepository;
    
    //Get todos los vehiculos
    @GetMapping
    public List<Vehiculo> getAllVehiculos() {
        return vehiculoRepository.findAll();
    }
    
    
    //Get un vehiculo por id
    @GetMapping("/vehiculo/{id}")
    public ResponseEntity<Vehiculo> getVehiculoById(@PathVariable int id){
        Optional<Vehiculo> vehiculo = vehiculoRepository.findById(id);
        if (vehiculo.isPresent()){
            return ResponseEntity.ok(vehiculo.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    //Crear vehiculo
    @PostMapping
    public Vehiculo createVehiculo(@RequestBody Vehiculo vehiculo){
        return vehiculoRepository.save(vehiculo);
    }
    
    
    //Actualizar vehiculo
    @PutMapping("/{id}")
    public ResponseEntity<Vehiculo> updateVehiculo(@PathVariable int id, @RequestBody Vehiculo vehiculoDetails ){
       Optional<Vehiculo> vehiculo = vehiculoRepository.findById(id);
       if (vehiculo.isPresent()){
           Vehiculo vehiculoToUpdate = vehiculo.get();
           vehiculoToUpdate.setTipo(vehiculoDetails.getTipo());
           vehiculoToUpdate.setMarca(vehiculoDetails.getMarca());
           vehiculoToUpdate.setPotencia(vehiculoDetails.getPotencia());
           vehiculoToUpdate.setFechaDeCompra(vehiculoDetails.getFechaDeCompra());
           return ResponseEntity.ok(vehiculoRepository.save(vehiculoToUpdate));
           
       }else {
           return ResponseEntity.notFound().build();
       }
    }
    
    
    //Eliminar vehiculo
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteVehiculo(@PathVariable int id){
        Optional<Vehiculo> vehiculo = vehiculoRepository.findById(id);
        if(vehiculo.isPresent()){
            vehiculoRepository.delete(vehiculo.get());
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    
    //Get potencia media segun tipo
    @GetMapping("/mediaPotencia")
    public Double getAveragePotencia(@RequestParam String tipo) {
        return vehiculoRepository.findMediaPotenciaByTipo(tipo);
    }
    
    //Get potencia máxima segun tipo
     @GetMapping("/maxPotencia")
    public Double getMaxPotencia(@RequestParam String tipo) {
        return vehiculoRepository.findMaxPotenciaByTipo(tipo);
    }
}
