package com.petclinic.controller;



import com.petclinic.model.Pet;
import com.petclinic.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pets")
public class PetController {
    @Autowired
    private PetService petService;

    @GetMapping
    public String listPets(Model model) {
        model.addAttribute("pets", petService.getAllPets());
        return "pets/list";
    }

    @GetMapping("/add")
    public String showAddPetForm(Model model) {
        model.addAttribute("pet", new Pet());
        return "pets/add";
    }

    @PostMapping("/add")
    public String addPet(@ModelAttribute Pet pet) {
        petService.savePet(pet);
        return "redirect:/pets";
    }

    @GetMapping("/edit/{id}")
    public String showEditPetForm(@PathVariable Long id, Model model) {
        Pet pet = petService.getPetById(id);
        if (pet != null) {
            model.addAttribute("pet", pet);
            return "pets/edit";
        }
        return "redirect:/pets";
    }

    @PostMapping("/edit/{id}")
    public String updatePet(@PathVariable Long id, @ModelAttribute Pet pet) {
        pet.setId(id);
        petService.savePet(pet);
        return "redirect:/pets";
    }

    @GetMapping("/delete/{id}")
    public String deletePet(@PathVariable Long id) {
        petService.deletePet(id);
        return "redirect:/pets";
    }
}

