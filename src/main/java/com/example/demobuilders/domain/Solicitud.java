package com.example.demobuilders.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String clienteId;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "solicitud_id")
    private List<Firmante> firmantes = new ArrayList<>();
    private String nombreRazonSocial;
    private String dniCuit;
    private Boolean visualizado;
}
