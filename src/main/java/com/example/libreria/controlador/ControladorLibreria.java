package com.example.libreria.controlador;

import com.example.libreria.librosRepositorio.RepositorioLibros;
import com.example.libreria.modelo.Libros;
import com.example.libreria.servicio.IServicioLibro;
import com.example.libreria.servicio.ServicioLibro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libros")
public class ControladorLibreria {
    private final IServicioLibro libroServicio;

    public ControladorLibreria(IServicioLibro libroServicio) {
        this.libroServicio = libroServicio;
    }

    @GetMapping("/todos")
    public List<Libros>listarLibros(){
        return libroServicio.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libros>obtenerPorId(@PathVariable long id){
        Optional<Libros>libros=libroServicio.findById(id);
        return libros.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Libros>crear(@RequestBody Libros libro){
        libroServicio.save(libro);
        return ResponseEntity.ok(libro);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void>eliminar(@PathVariable long id){
        libroServicio.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
