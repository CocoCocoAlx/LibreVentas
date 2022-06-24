package com.argentina.libreventas.Servicio;

import com.argentina.libreventas.dto.ProductoRepositorio;
import com.argentina.libreventas.modelo.Producto;
import java.io.IOException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductoServicio {

    @Autowired
    private ProductoRepositorio productorepositorio;
    public void guardarProductoBD(MultipartFile archivo,String nombre,String descripcion,int precio){
        Producto producto = new Producto();
        String nombreArchivo = StringUtils.cleanPath(archivo.getOriginalFilename());
        if(nombreArchivo.contains("..")){
            System.out.println("No es un archivo válido");
        }
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setDescripcion(descripcion);
        try {
            producto.setImagen(Base64.getEncoder().encodeToString(archivo.getBytes()));
        } catch (IOException ex) {
            Logger.getLogger(ProductoServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        productorepositorio.save(producto);

    }

}
