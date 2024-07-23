package com.petclinic.controller;



import com.petclinic.model.Owner;
import com.petclinic.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/owners")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @GetMapping
    public String listOwners(Model model) {
        model.addAttribute("owners", ownerService.getAllOwners());
        return "owners/list";
    }

    @GetMapping("/add")
    public String showAddOwnerForm(Model model) {
        model.addAttribute("owner", new Owner());
        return "owners/add";
    }

    @PostMapping("/add")
    public String addOwner(@ModelAttribute Owner owner) {
        ownerService.saveOwner(owner);
        return "redirect:/owners";
    }

    @GetMapping("/edit/{id}")
    public String showEditOwnerForm(@PathVariable Long id, Model model) {
        Owner owner = ownerService.getOwnerById(id);
        if (owner != null) {
            model.addAttribute("owner", owner);
            return "owners/edit";
        }
        return "redirect:/owners";
    }

    @PostMapping("/edit/{id}")
    public String updateOwner(@PathVariable Long id, @ModelAttribute Owner owner) {
        owner.setId(id);
        ownerService.saveOwner(owner);
        return "redirect:/owners";
    }

    @GetMapping("/delete/{id}")
    public String deleteOwner(@PathVariable Long id) {
        ownerService.deleteOwner(id);
        return "redirect:/owners";
    }
}

