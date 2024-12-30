package com.jar.venta.impl;

import com.jar.venta.service.ClienteService;
import com.jar.venta.dto.ClienteDTO;
import com.jar.venta.model.Cliente;
import com.jar.venta.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    // Constructor
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Mono<ClienteDTO> obtenerCliente(Long id) {
        return clienteRepository.findById(id)  // Busca el cliente por ID
                .map(cliente -> new ClienteDTO(  // Mapea la entidad Cliente a ClienteDTO
                        cliente.getId(),
                        cliente.getNombre(),
                        cliente.getDireccion(),
                        cliente.getTelefono(),
                        cliente.getEmail()
                ));
    }

    @Override
    public Mono<ClienteDTO> crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente)
                .map(c -> new ClienteDTO(c.getId(), c.getNombre(), c.getDireccion(), c.getTelefono(), c.getEmail()));
    }

    @Override
    public Mono<ClienteDTO> actualizarCliente(Long id, Cliente cliente) {
        return clienteRepository.findById(id)
                .flatMap(existingCliente -> {
                    existingCliente.setNombre(cliente.getNombre());
                    existingCliente.setDireccion(cliente.getDireccion());
                    existingCliente.setTelefono(cliente.getTelefono());
                    existingCliente.setEmail(cliente.getEmail());
                    return clienteRepository.save(existingCliente)
                            .map(c -> new ClienteDTO(c.getId(), c.getNombre(), c.getDireccion(), c.getTelefono(), c.getEmail()));
                })
                .switchIfEmpty(Mono.empty());  // Si el cliente no existe, devuelve un Mono vacío
    }

    @Override
    public Mono<Void> eliminarCliente(Long id) {
        return clienteRepository.findById(id)
                .flatMap(existingCliente -> clienteRepository.delete(existingCliente))
                .then();
    }
}