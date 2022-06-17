package com.argentina.libreventas.Controladora;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class ejemploControladora {
    @GetMapping("/ejemplo.html")
    public String mostrarEjemplo(Model modelo){
        String nombre = "LibreVentas";
        String bienvenida = "Le damos la bienvenida a LibreVentas";
        modelo.addAttribute("bienvenida", bienvenida);
        modelo.addAttribute("nombre", nombre);
        System.out.println("salida función mostrarEjemplo()");
        return ("/ejemplo.html");
    }
    
    
}
