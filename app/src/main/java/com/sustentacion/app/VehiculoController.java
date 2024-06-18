package com.sustentacion.app;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sustentacion.app.Domain.Vehiculo;
import com.sustentacion.app.Repository.VehiculoRepositorio;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class VehiculoController {
    @Autowired
    VehiculoRepositorio vehiculoRepositorio;

    @GetMapping("/vehiculos")
    public ResponseEntity<List<Vehiculo>> encontrarVehiculos() {
        try {
            List<Vehiculo> vehiculos = vehiculoRepositorio.findAll();
            return new ResponseEntity<>(vehiculos, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/vehiculo")
    public ResponseEntity<Vehiculo> guardarVehiculo(@RequestBody Vehiculo vehiculo) {
        try {
            return new ResponseEntity<>(vehiculoRepositorio.save(vehiculo), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/vehiculo/{id}")
    public ResponseEntity<HttpStatus> borrarVehiculo(@PathVariable("id") long id) {
        try {
            vehiculoRepositorio.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @GetMapping("/vehiculo/{marca}")
    public ResponseEntity<List<Vehiculo>> encontrarVehiculos(@PathVariable("marca") String marca) {
        try {
            List<Vehiculo> vehiculos = vehiculoRepositorio.findAll();
            List<Vehiculo> vehiculosfind = vehiculoRepositorio.findAll();
            
            for (Vehiculo vehiculo : vehiculos) {
                if (vehiculo.getMarca().equals(marca)) {
                    vehiculosfind.add(vehiculo);
                }
                
            }
            return new ResponseEntity<>(vehiculosfind, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("vehiculo/{id}")
    public ResponseEntity<Vehiculo> modificarVehiculo(@PathVariable("id") long id, @RequestBody Vehiculo vehiculo) {
        try {
            Optional<Vehiculo> vehiculoData = vehiculoRepositorio.findById(id);
            if (vehiculoData.isPresent()) {
                Vehiculo _vehiculo = vehiculoData.get();
                _vehiculo.setMarca(vehiculo.getMarca());
                _vehiculo.setModelo(vehiculo.getModelo());
                _vehiculo.setAño(vehiculo.getAño());
                _vehiculo.setColor(vehiculo.getColor());
                _vehiculo.setPrecio(vehiculo.getPrecio());
                _vehiculo.setTipo_vehiculo(vehiculo.getTipo_vehiculo());
                _vehiculo.setConsesionaria(vehiculo.getConsesionaria());
                _vehiculo.setImagen(vehiculo.getImagen());
                return new ResponseEntity<>(vehiculoRepositorio.save(_vehiculo), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        }
    }

}
