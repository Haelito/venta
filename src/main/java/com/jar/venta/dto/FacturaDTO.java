package com.jar.venta.dto;

import com.jar.venta.model.Cliente;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacturaDTO {

    private Long id;
    private String numeroFactura;
    private LocalDate fecha;
    private Double total;
    private Cliente cliente;


    // Constructor
    public FacturaDTO(Long id, LocalDate fecha, Double total, Long clienteId) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.clienteId = clienteId;
    }
}