package com.petclinic.controller;


import com.petclinic.model.ConsultationFee;
import com.petclinic.service.ConsultationFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/fees")
public class ConsultationFeeController {
    @Autowired
    private ConsultationFeeService consultationFeeService;

    @GetMapping
    public String listFees(Model model) {
        model.addAttribute("fees", consultationFeeService.getAllConsultationFees());
        return "fees/list";
    }

    @GetMapping("/add")
    public String showAddFeeForm(Model model) {
        model.addAttribute("fee", new ConsultationFee());
        return "fees/add";
    }

    @PostMapping("/add")
    public String addFee(@ModelAttribute ConsultationFee fee) {
        consultationFeeService.saveConsultationFee(fee);
        return "redirect:/fees";
    }

    @GetMapping("/edit/{id}")
    public String showEditFeeForm(@PathVariable Long id, Model model) {
        ConsultationFee fee = consultationFeeService.getConsultationFeeById(id);
        if (fee != null) {
            model.addAttribute("fee", fee);
            return "fees/edit";
        }
        return "redirect:/fees";
    }

    @PostMapping("/edit/{id}")
    public String updateFee(@PathVariable Long id, @ModelAttribute ConsultationFee fee) {
        fee.setId(id);
        consultationFeeService.saveConsultationFee(fee);
        return "redirect:/fees";
    }

    @GetMapping("/delete/{id}")
    public String deleteFee(@PathVariable Long id) {
        consultationFeeService.deleteConsultationFee(id);
        return "redirect:/fees";
    }
}

