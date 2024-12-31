package com.jar.venta.service;


import com.jar.venta.dto.ClienteDTO;
import com.jar.venta.model.Cliente;
import reactor.core.publisher.Mono;

public interface ClienteService {

    Mono<ClienteDTO> obtenerCliente(Long id);
    Mono<Cliente> crearCliente(Cliente cliente);
    Mono<Cliente> actualizarCliente(Long id, Cliente cliente);
    Mono<Void> eliminarCliente(Long id);

    Mono<Cliente> obtenerClientePorId(Long id);
}