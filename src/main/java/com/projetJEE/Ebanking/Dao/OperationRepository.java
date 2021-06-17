package com.projetJEE.Ebanking.Dao;

import com.projetJEE.Ebanking.entities.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface OperationRepository extends JpaRepository<Operation, Long> {

}
