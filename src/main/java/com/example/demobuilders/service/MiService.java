package com.example.demobuilders.service;

import com.example.demobuilders.domain.Firmante;
import com.example.demobuilders.domain.Solicitud;
import com.example.demobuilders.dto.DtoProducto;
import com.example.demobuilders.repository.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MiService {

    @Autowired
    SolicitudRepository repository;

    public DtoProducto crearDtoProducto() {

        //... logica de negocio
        DtoProducto dto = new DtoProducto();
        dto.setDescripcion("Producto comun");
        dto.setHabilitado(true);
        return dto;
    }

    public Solicitud guardarFirmante(Integer solicitudId, Firmante firmante) {

        Solicitud solicitud = repository.getOne(solicitudId);
        
        solicitud.getFirmantes().add(firmante);
        
        return solicitud;
    }

}
