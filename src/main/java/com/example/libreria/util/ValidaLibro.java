package com.example.libreria.util;

import com.example.libreria.modelo.Libros;
import org.springframework.stereotype.Component;

@Component
public class ValidaLibro {

    public Libros libro;

    public boolean tituloValido(){
        return libro.getTitulo()!=null && !libro.getTitulo().isBlank();
    }
}
