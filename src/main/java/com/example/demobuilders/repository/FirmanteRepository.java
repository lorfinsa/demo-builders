package com.example.demobuilders.repository;

import com.example.demobuilders.domain.Firmante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirmanteRepository extends JpaRepository<Firmante, Integer> {

}
