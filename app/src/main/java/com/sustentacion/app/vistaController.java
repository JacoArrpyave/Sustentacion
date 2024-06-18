package com.sustentacion.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.sustentacion.app.Domain.Vehiculo;
import com.sustentacion.app.Repository.VehiculoRepositorio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class vistaController {
    @Autowired
    VehiculoRepositorio vehiculoRepositorio;
    @GetMapping("/new-vehiculo")
    public String nuevoEmpleado(Model model) {
        model.addAttribute("vehiculo",new Vehiculo());
        return "add_vehiculo";
    }

    @PostMapping("/new-vehiculo")
    public String postVehiculo(Vehiculo vehiculo) {
        vehiculoRepositorio.save(vehiculo);
        
        return "redirect:/Vehiculos";
    }
    
    @GetMapping("/Vehiculos")
    public String obtenerVehiculos(Model model){
        List<Vehiculo> vehiculos=vehiculoRepositorio.findAll();
        model.addAttribute("vehiculos", vehiculos);
        return "vehiculos";

    }
    

    
}