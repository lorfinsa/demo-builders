package com.example.demobuilders.builder;

import com.example.demobuilders.domain.Firmante;
import com.somospnt.test.builder.AbstractPersistenceBuilder;

public class FirmanteBuilder extends AbstractPersistenceBuilder<Firmante> {

    public FirmanteBuilder(){
        this.instance = new Firmante();
    }
    
    //INIT
    public static FirmanteBuilder juan(){
        FirmanteBuilder firmanteBuilder = new FirmanteBuilder();
        
        firmanteBuilder.instance.setNombre("Juan");
        
        return firmanteBuilder;
    }
}
