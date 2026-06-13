package com.example.libreria.servicio;

import com.example.libreria.librosRepositorio.IRepositorioLibros;
import com.example.libreria.librosRepositorio.RepositorioLibros;
import com.example.libreria.modelo.Libros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Gestiona la lógica de negocio

@Service
public class ServicioLibro implements IServicioLibro{

    private final IRepositorioLibros repositorioLibros;

    @Autowired
    public ServicioLibro(IRepositorioLibros repositorioLibros) {
        this.repositorioLibros = repositorioLibros;
    }

    @Override
    public List<Libros> obtenerTodos() {
        return repositorioLibros.findAll();
    }

    @Override
    public Optional<Libros> findById(long id) {
        return repositorioLibros.findById(id);
    }

    @Override
    public Libros save(Libros libro) {
        repositorioLibros.save(libro);
        return libro;

    }

    @Override
    public void deleteById(long id) {
        repositorioLibros.deleteById(id);

    }

    @Override
    public String buscarLibroPorTitulo(String titulo) {
        boolean encontrado=repositorioLibros.findAll().stream()
                .anyMatch(libros -> //anyMatch retorna el Boolean necesario en caso de que algun elemento cumpla la condición
                    libros.getTitulo().equalsIgnoreCase(titulo));
        return encontrado ? "Libro encontrado" : "Libro no encontrado";
    }
}
