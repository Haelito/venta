package com.jar.venta.repository;

import com.jar.venta.model.Factura;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface FacturaRepository extends ReactiveCrudRepository<Factura, Long> {
}