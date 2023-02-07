package com.ravinshah.petApp.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PetController {

    @Autowired
    private PetService petService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/pet")
    public void createPet(@RequestBody Pet pet) {
        petService.save(pet);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/pet")
    public Pet updatePetStatus(@RequestBody Pet pet) throws PetNotFoundException {

        petService.save(pet);
        return petService.getPet(pet.getId()).orElseThrow(() -> new PetNotFoundException("Pet not found"));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/pets")
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }



}
