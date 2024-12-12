package com.example.api_rest.service;

import com.example.api_rest.dto.ClienteDTO;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    public ClienteDTO obtenerCliente(String tipoDocumento, String numeroDocumento) {
        
        if (!"C".equals(tipoDocumento) && !"P".equals(tipoDocumento)) {
            throw new IllegalArgumentException("El tipo de documento es inválido");
        }

        
        if ("C".equals(tipoDocumento) && "23445322".equals(numeroDocumento)) {
            return new ClienteDTO(
                "Daniel", 
                "Andrés", 
                "Caicedo", 
                "Bohorquez", 
                "1032488904", 
                "Calle 8 no 101 - 3", 
                "Bogotá, Cundinamarca"
            );
        }
      
        throw new RuntimeException("Cliente no encontrado");
    }
}
