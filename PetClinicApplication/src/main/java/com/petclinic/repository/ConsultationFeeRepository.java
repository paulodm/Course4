package com.petclinic.repository;


import com.petclinic.model.ConsultationFee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationFeeRepository extends JpaRepository<ConsultationFee, Long> {
}

