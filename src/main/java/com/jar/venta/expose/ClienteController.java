package com.jar.venta.expose;

import com.jar.venta.model.Cliente;
import com.jar.venta.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Cliente> crearCliente(@RequestBody Cliente cliente) {
        return clienteService.crearCliente(cliente); // Retorna un Mono de Cliente
    }

    @GetMapping("/{id}")
    public Mono<Cliente> obtenerClientePorId(@PathVariable Long id) {
        return clienteService.obtenerClientePorId(id); // Retorna un Mono de Cliente
    }

    @PutMapping("/{id}")
    public Mono<Cliente> actualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.actualizarCliente(id, cliente); // Retorna un Mono de Cliente
    }

    @DeleteMapping("/{id}")
    public Mono<Void> eliminarCliente(@PathVariable Long id) {
        return clienteService.eliminarCliente(id); // Retorna un Mono<Void> para eliminar cliente
    }
}
