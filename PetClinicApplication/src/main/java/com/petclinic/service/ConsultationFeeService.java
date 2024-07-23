package com.petclinic.service;


import com.petclinic.model.ConsultationFee;
import com.petclinic.repository.ConsultationFeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationFeeService {
    @Autowired
    private ConsultationFeeRepository consultationFeeRepository;

    public List<ConsultationFee> getAllConsultationFees() {
        return consultationFeeRepository.findAll();
    }

    public ConsultationFee getConsultationFeeById(Long id) {
        return consultationFeeRepository.findById(id).orElse(null);
    }

    public ConsultationFee saveConsultationFee(ConsultationFee consultationFee) {
        return consultationFeeRepository.save(consultationFee);
    }

    public void deleteConsultationFee(Long id) {
        consultationFeeRepository.deleteById(id);
    }
}

