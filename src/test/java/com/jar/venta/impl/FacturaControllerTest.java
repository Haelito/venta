package com.jar.venta.impl;


import com.jar.venta.expose.FacturaController;
import com.jar.venta.dto.FacturaDTO;
import com.jar.venta.service.FacturaService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FacturaControllerTest {

    @Mock
    private FacturaService facturaService;

    @InjectMocks
    private FacturaController facturaController;

    private WebTestClient webTestClient;

    @Test
    public void testCrearFactura() {
        FacturaDTO facturaDTO = new FacturaDTO(1L, "F001", LocalDate.now(), 100.0, null);
        Mockito.when(facturaService.crearFactura(Mockito.any(com.jar.venta.model.Factura.class))).thenReturn(Mono.just(facturaDTO));

        webTestClient.post().uri("/facturas")
                .bodyValue(facturaDTO)
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CREATED)
                .expectBody()
                .jsonPath("$.numeroFactura").isEqualTo("F001");
    }
}