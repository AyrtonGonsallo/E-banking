package com.projetJEE.Ebanking.Dao;

import com.projetJEE.Ebanking.entities.*;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface OperateurRepository extends JpaRepository<Operateur, Long> {
	
	Optional<Operateur> findByUsername(String username);

	Optional<Operateur> findByCin(String username);

}
