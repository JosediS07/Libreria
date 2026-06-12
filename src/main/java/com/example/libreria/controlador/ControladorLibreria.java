package com.example.libreria.controlador;

import com.example.libreria.librosRepositorio.RepositorioLibros;
import com.example.libreria.modelo.Libros;
import com.example.libreria.servicio.ServicioLibro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libros")
public class ControladorLibreria {
    private final ServicioLibro libroServicio;
    private final RepositorioLibros libroRepositorio;

    public ControladorLibreria(ServicioLibro libroServicio, RepositorioLibros libroRepositorio) {
        this.libroServicio = libroServicio;
        this.libroRepositorio = libroRepositorio;
    }

    @GetMapping("/{titulo}")
    public String dameLibro(@PathVariable String titulo){
        return libroServicio.buscarLibro(titulo);

    }

    @GetMapping("/todos")
    public List<Libros>listarLibros(){
        return libroRepositorio.findAll();

    }

    // Busca un libro por ID: si existe devuelve 200 OK con el libro, si no existe devuelve 404 Not Found.
    @GetMapping("/id/{idLibro}")
    //ResponseEntity sirve para tener el control total de la respuesta HTTP que tu servidor le envía al cliente
    public ResponseEntity<Libros> listarId(@PathVariable long idLibro){
        return libroRepositorio.buscaID(idLibro)
                .map(ResponseEntity::ok)                  // Si lo encuentra -> HTTP 200 OK + JSON
                .orElse(ResponseEntity.notFound().build());// Si está vacío  -> HTTP 404 NOT FOUND
    }

    @GetMapping("/clone")
    public String probarClone(){
        Libros original=new Libros(1L,"Miguel de Cervantes", "El Quijote", LocalDate.of(1605, 1, 16));
        Libros copia=original.clone();
        copia.setIdLibro(8);
        copia.setTitulo("Copia de prueba");

        return "Original: "+original.toString() + " | Copia: "+copia.toString();
    }
}
