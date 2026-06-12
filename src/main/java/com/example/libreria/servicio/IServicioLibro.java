package com.example.libreria.servicio;

import com.example.libreria.modelo.Libros;

import java.util.List;
import java.util.Optional;

public interface IServicioLibro {
    List<Libros>obtenerTodos();
    Optional<Libros> findById(long id);
    Libros save(Libros libro);
    void deleteById(long id);
    String buscarLibroPorTitulo(String titulo);
}
