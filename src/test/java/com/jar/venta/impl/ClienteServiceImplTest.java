package com.jar.venta.impl;

import com.jar.venta.service.ClienteService;
import com.jar.venta.dto.ClienteDTO;
import com.jar.venta.model.Cliente;
import com.jar.venta.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

class ClienteServiceImplTest {

    private final ClienteRepository clienteRepository = Mockito.mock(ClienteRepository.class);
    private final ClienteService clienteService = new ClienteServiceImpl(clienteRepository);

    @Test
    void obtenerClienteTest() {
        // Configuración del mock
        Cliente cliente = new Cliente(1L, "Juan Perez", "Av. Principal 123", "123456789", "juan@mail.com");
        Mockito.when(clienteRepository.findById(1L)).thenReturn(Mono.just(cliente));

        // Llamada al servicio
        Mono<ClienteDTO> clienteDTOMono = clienteService.obtenerCliente(1L);

        // Verificación de la respuesta
        StepVerifier.create(clienteDTOMono)
                .expectNextMatches(clienteDTO -> clienteDTO.getId().equals(1L) &&
                        clienteDTO.getNombre().equals("Juan Perez"))
                .expectComplete()
                .verify();

        // Verifica que el método del repositorio haya sido llamado
        Mockito.verify(clienteRepository).findById(1L);
    }
}