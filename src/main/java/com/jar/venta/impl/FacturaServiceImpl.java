package com.jar.venta.impl;

import com.jar.venta.service.FacturaService;
import com.jar.venta.dto.FacturaDTO;
import com.jar.venta.model.Factura;
import com.jar.venta.repository.FacturaRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FacturaServiceImpl implements FacturaService {

    private final FacturaRepository facturaRepository;

    // Constructor
    public FacturaServiceImpl(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    @Override
    public Mono<FacturaDTO> obtenerFactura(Long id) {
        return facturaRepository.findById(id)  // Busca la factura por ID
                .map(factura -> new FacturaDTO(  // Mapea la entidad Factura a FacturaDTO
                        factura.getId(),
                        factura.getFecha(),
                        factura.getTotal(),
                        factura.getCliente().getId()
                ));
    }

    @Override
    public Mono<FacturaDTO> crearFactura(Factura factura) {
        return facturaRepository.save(factura)
                .map(f -> new FacturaDTO(f.getId(), f.getFecha(), f.getTotal(), f.getCliente().getId()));
    }

    @Override
    public Mono<FacturaDTO> actualizarFactura(Long id, Factura factura) {
        return facturaRepository.findById(id)
                .flatMap(existingFactura -> {
                    existingFactura.setFecha(factura.getFecha());
                    existingFactura.setTotal(factura.getTotal());
                    return facturaRepository.save(existingFactura)
                            .map(f -> new FacturaDTO(f.getId(), f.getFecha(), f.getTotal(), f.getCliente().getId()));
                })
                .switchIfEmpty(Mono.empty());  // Si la factura no existe, devuelve un Mono vacío
    }

    @Override
    public Mono<Void> eliminarFactura(Long id) {
        return facturaRepository.findById(id)
                .flatMap(existingFactura -> facturaRepository.delete(existingFactura))
                .then();
    }
}
