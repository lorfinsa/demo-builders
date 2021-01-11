package com.example.demobuilders;

import com.example.demobuilders.domain.Firmante;
import com.example.demobuilders.domain.Solicitud;
import com.example.demobuilders.dto.DtoProducto;
import com.example.demobuilders.repository.SolicitudRepository;
import com.example.demobuilders.service.MiService;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Slf4j
@Transactional
class ApplicationTests {

    @Autowired
    private MiService service;
    @Autowired
    private SolicitudRepository solicitudRepository;


    @Test
    void contextLoads() {
    }

    @Test
    //@Sql("solicitudStandarNueva.sql")
    public void guardarFirmante_existeSolicitudNueva_guardaYNoModificaSolicitud() {
        Solicitud solicitud = new Solicitud();
        
        Solicitud solicitudGuardada = solicitudRepository.save(solicitud);
        
        Firmante firmante = new Firmante();
        firmante.setNombre("Juan");
        
        Solicitud solicitudDevuelta = service.guardarFirmante(solicitudGuardada.getId(), firmante);

        assertThat(solicitudDevuelta.getId()).isEqualTo(solicitudGuardada.getId());
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
