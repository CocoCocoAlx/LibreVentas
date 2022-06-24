package com.argentina.libreventas.Controladora;

import com.argentina.libreventas.dto.ProductoRepositorio;
import com.argentina.libreventas.modelo.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControlProducto {
    
    @Autowired
    private ProductoRepositorio productorepositorio;
    
    @GetMapping("/listaproductos.html")
    public String listarProductos(Model modelo){
        List<Producto> productos = productorepositorio.findAll();
        modelo.addAttribute("productos", productos);
        return "/listaproductos.html";
    }
    
    @GetMapping("/")
    public String agregarProducto(){
        return "/listaproductos.html";
    }
    
    @PostMapping("/agregarp")
    public String guardarProducto(
            @RequestParam("nombreproducto") String nombre,
            @RequestParam("precioproducto") int precio,
            @RequestParam("descripcionproducto") String descripcion)
    {
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setDescripcion(descripcion);
        productorepositorio.save(producto);
        return "redirect:/listaproductos.html";
    }
    
    @GetMapping("/borrarproducto/{id}")
    public String borrarProducto(@PathVariable("id") Long id){
        productorepositorio.deleteById(id);
        return "redirect:/listaproductos.html";
    }
    
    @PostMapping("/cambiarnombre")
    public String cambiarNombre(@RequestParam("id") Long id,
            @RequestParam("nuevonombreproducto") String nombre){
        Producto producto = new Producto();
        producto = productorepositorio.findById(id).get();
        producto.setNombre(nombre);
        productorepositorio.save(producto);
        return "redirect:/listaproductos.html";
    }
    
    @PostMapping("/cambiarprecio")
    public String cambiarPrecio(@RequestParam("id") Long id,
            @RequestParam("nuevoprecioproducto") int precio){
        Producto producto = new Producto();
        producto = productorepositorio.findById(id).get();
        producto.setPrecio(precio);
        productorepositorio.save(producto);
        return "redirect:/listaproductos.html";
    }
    
    @PostMapping("/cambiardesc")
    public String cambiarDesc(@RequestParam("id") Long id,
            @RequestParam("nuevadescproducto") String descripcion){
        Producto producto = new Producto();
        producto = productorepositorio.findById(id).get();
        producto.setDescripcion(descripcion);
        productorepositorio.save(producto);
        return "redirect:/listaproductos.html";
    }
}
