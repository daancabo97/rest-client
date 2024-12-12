package com.example.api_rest.controller;

import com.example.api_rest.dto.ClienteDTO;
import com.example.api_rest.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<ClienteDTO> consultarCliente(
            @RequestParam String tipoDocumento,
            @RequestParam String numeroDocumento) {
        try {
            ClienteDTO cliente = clienteService.obtenerCliente(tipoDocumento, numeroDocumento);
            return ResponseEntity.ok(cliente);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
