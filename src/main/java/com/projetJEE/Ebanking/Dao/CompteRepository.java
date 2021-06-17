package com.projetJEE.Ebanking.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.projetJEE.Ebanking.entities.Compte;
@CrossOrigin("*")
@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, Long> {
	Optional<Compte> findByNumero(String numero);
}
