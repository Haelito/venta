package com.jar.venta.service;

import com.jar.venta.dto.FacturaDTO;
import com.jar.venta.model.Factura;
import reactor.core.publisher.Mono;

public interface FacturaService {

    Mono<FacturaDTO> obtenerFactura(Long id);
    Mono<FacturaDTO> crearFactura(Factura factura);
    Mono<FacturaDTO> actualizarFactura(Long id, Factura factura);
    Mono<Void> eliminarFactura(Long id);
}
