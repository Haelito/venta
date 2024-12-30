package com.jar.venta.service;


import com.jar.venta.dto.ClienteDTO;
import com.jar.venta.model.Cliente;
import reactor.core.publisher.Mono;

public interface ClienteService {

    Mono<ClienteDTO> obtenerCliente(Long id);
    Mono<ClienteDTO> crearCliente(Cliente cliente);
    Mono<ClienteDTO> actualizarCliente(Long id, Cliente cliente);
    Mono<Void> eliminarCliente(Long id);
}