package com.jar.venta.repository;

import com.jar.venta.model.Factura;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends ReactiveCrudRepository<Factura, Long> {
}