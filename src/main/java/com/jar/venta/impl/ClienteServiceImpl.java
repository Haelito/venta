package com.jar.venta.impl;

import com.jar.venta.dto.ClienteDTO;
import com.jar.venta.model.Cliente;
import com.jar.venta.repository.ClienteRepository;
import com.jar.venta.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
    }

    @Override
    public Mono<ClienteDTO> obtenerCliente(Long id) {
        return null;
    }

    @Override
    public Mono<Cliente> crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente); // `Mono<Cliente>` para operación reactiva
    }

    @Override
    public Mono<Cliente> obtenerClientePorId(Long id) {
        return clienteRepository.findById(id); // `Mono<Cliente>` para obtener un cliente por ID
    }

    @Override
    public Mono<Void> eliminarCliente(Long id) {
        return clienteRepository.deleteById(id); // `Mono<Void>` para eliminar cliente
    }

    @Override
    public Mono<Cliente> actualizarCliente(Long id, Cliente cliente) {
        return clienteRepository.findById(id)
                .flatMap(existingCliente -> {
                    existingCliente.setNombre(cliente.getNombre());
                    existingCliente.setId(cliente.getId());
                    return clienteRepository.save(existingCliente);
                });
    }
}
