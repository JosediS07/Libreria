package com.example.libreria.controlador;

import com.example.libreria.servicio.ServicioLibro;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/libros")
public class ControladorLibreria {
    private final ServicioLibro libroServicio;

    public ControladorLibreria(ServicioLibro libroServicio) {
        this.libroServicio = libroServicio;
    }

    @GetMapping("/{titulo}")
    public String dameLibro(@PathVariable String titulo){
        return libroServicio.buscarLibro(titulo);

    }
}
