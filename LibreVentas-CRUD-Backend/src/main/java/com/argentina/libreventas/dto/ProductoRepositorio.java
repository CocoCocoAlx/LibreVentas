package com.argentina.libreventas.dto;

import com.argentina.libreventas.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends JpaRepository <Producto, Long>{
    
}
