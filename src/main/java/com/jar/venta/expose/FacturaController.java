package com.jar.venta.expose;

import com.jar.venta.service.FacturaService;
import com.jar.venta.dto.FacturaDTO;
import com.jar.venta.model.Factura;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/facturas")
public class FacturaController {

    private final FacturaService facturaService;

    // Constructor para inyectar el servicio de Factura
    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    // Obtener una factura por su ID
    @GetMapping("/{id}")
    public Mono<FacturaDTO> obtenerFactura(@PathVariable Long id) {
        return facturaService.obtenerFactura(id);
    }

    // Crear una nueva factura
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<FacturaDTO> crearFactura(@RequestBody Factura factura) {
        return facturaService.crearFactura(factura);
    }

    // Actualizar una factura existente
    @PutMapping("/{id}")
    public Mono<FacturaDTO> actualizarFactura(@PathVariable Long id, @RequestBody Factura factura) {
        return facturaService.actualizarFactura(id, factura);
    }

    // Eliminar una factura por su ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> eliminarFactura(@PathVariable Long id) {
        return facturaService.eliminarFactura(id);
    }
}
