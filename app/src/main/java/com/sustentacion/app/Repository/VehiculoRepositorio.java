
package com.sustentacion.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sustentacion.app.Domain.Vehiculo;

public interface VehiculoRepositorio extends JpaRepository<Vehiculo,Long> {

    
}