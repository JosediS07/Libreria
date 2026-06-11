package com.example.libreria.servicio;

import org.springframework.stereotype.Service;

//Gestiona la lógica de negocio

@Service
public class ServicioLibro {

    public String buscarLibro(String titulo){
        if (titulo.equalsIgnoreCase("El quijote")){
            return "Libro encontrado";
        }else{
            return "Libro no encontrado";

        }
    }




}
