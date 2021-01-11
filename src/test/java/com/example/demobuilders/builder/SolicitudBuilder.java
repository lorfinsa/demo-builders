package com.example.demobuilders.builder;

import com.example.demobuilders.domain.Solicitud;
import com.somospnt.test.builder.AbstractPersistenceBuilder;
import java.util.ArrayList;

public class SolicitudBuilder extends AbstractPersistenceBuilder<Solicitud> {
    
    public SolicitudBuilder(){
        instance = new Solicitud();
    }
    
    //CONFIGURACION INICIAL DE SOLICITUD
    public static SolicitudBuilder solicitudNuevaClienteDefault() {
        SolicitudBuilder miBuilder = new SolicitudBuilder();
        
        miBuilder.instance.setClienteId("789");
        miBuilder.instance.setFirmantes(new ArrayList<>());
        
        return miBuilder;
    }

    //CONFIGURACION INICIAL DE SOLICITUD
    public static SolicitudBuilder solicitudVisualizada() {
        SolicitudBuilder miBuilder = new SolicitudBuilder();
        
        miBuilder.instance.setClienteId("789");
        miBuilder.instance.setVisualizado(true);
        
        return miBuilder;
    }

    //AJUSTE DE CAMPOS
    public SolicitudBuilder conNombreVacio(){
        this.instance.setNombreRazonSocial("");
        return this;
    }
}
