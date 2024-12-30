package com.jar.venta.expose;

import com.jar.venta.model.Cliente;
import com.jar.venta.service.ClienteService;
import com.jar.venta.dto.ClienteDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    // Constructor para inyectar el servicio de Cliente
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Obtener un cliente por su ID
    @GetMapping("/{id}")
    public Mono<ClienteDTO> obtenerCliente(@PathVariable Long id) {
        return clienteService.obtenerCliente(id);
    }

    // Crear un nuevo cliente
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ClienteDTO> crearCliente(@RequestBody Cliente cliente) {
        return clienteService.crearCliente(cliente);
    }

    // Actualizar un cliente existente
    @PutMapping("/{id}")
    public Mono<ClienteDTO> actualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.actualizarCliente(id, cliente);
    }

    // Eliminar un cliente por su ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> eliminarCliente(@PathVariable Long id) {
        return clienteService.eliminarCliente(id);
    }
}