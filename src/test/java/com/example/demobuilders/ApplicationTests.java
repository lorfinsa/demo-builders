package com.example.demobuilders;

import com.example.demobuilders.builder.FirmanteBuilder;
import com.example.demobuilders.builder.SolicitudBuilder;
import com.example.demobuilders.domain.Firmante;
import com.example.demobuilders.domain.Solicitud;
import com.example.demobuilders.dto.DtoProducto;
import com.example.demobuilders.repository.SolicitudRepository;
import com.example.demobuilders.service.MiService;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
@Transactional
class ApplicationTests {

    @Autowired
    private MiService service;
    @Autowired
    private SolicitudRepository solicitudRepository;
    @Autowired
    private EntityManager em;


    @Test
    void contextLoads() {
    }

    @Test
    public void guardarFirmante_existeSolicitudNueva_guardaYNoModificaSolicitud() {
//        Solicitud solicitud = new Solicitud();
//        solicitud.setClienteId("789");
//        Solicitud solicitudGuardada = solicitudRepository.save(solicitud);

        //INICIALIZACION DEL TEST
        Solicitud solicitudDePruebaGuardada = SolicitudBuilder
                .solicitudNuevaClienteDefault()
                .conNombreVacio()
                .build(em);

        Firmante firmante = FirmanteBuilder.juan().build();
//        Firmante firmante = new Firmante();
//        firmante.setNombre("Juan");
        
        //EJECUCION
        Solicitud solicitudDevuelta = service.guardarFirmante(solicitudDePruebaGuardada.getId(), firmante);

        //ASSERTS
        assertThat(solicitudDevuelta.getId()).isEqualTo(solicitudDePruebaGuardada.getId());
        assertThat(solicitudDevuelta.getClienteId()).isEqualTo("789");
        
        assertThat(solicitudDevuelta.getFirmantes()).hasSize(1);
        assertThat(solicitudDevuelta.getFirmantes().get(0).getNombre()).isEqualTo("Juan");
        
    }

    @Test
    public void crearProductoDto_verificaQueLosCamposSonCorrectos() {
        DtoProducto dtoCreado = service.crearDtoProducto();
        log.error(dtoCreado.toString());

        assertThat(dtoCreado.getDescripcion()).isEqualTo("Producto comun");
        assertThat(dtoCreado.getHabilitado()).isTrue();
    }
}
