package com.example.libreria.librosRepositorio;

import com.example.libreria.modelo.Libros;

import java.util.List;
import java.util.Optional;

public interface IRepositorioLibros {
    List<Libros> findAll();
    Optional<Libros>findById(long id);
    void save(Libros libro);
    void deleteById(long libro);
}
