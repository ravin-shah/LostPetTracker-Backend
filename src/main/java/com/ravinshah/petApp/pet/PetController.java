package com.ravinshah.petApp.pet;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PetController {

    @Autowired
    private PetService petService;

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/pet/{id}")
    public List<Pet> deletePet(@PathVariable("id") String id) {
        System.out.println("Delete Id" + id);
        petService.delete(id);
        return getAllPets();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/pet")
    public List<Pet> createPet(@RequestBody Pet pet) {
        petService.add(pet);
        return getAllPets();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/pet")
    public List<Pet> updatePetStatus(@RequestBody Pet pet) throws PetNotFoundException {
        System.out.println("Update pet" + pet);
        petService.update(pet);
        return getAllPets();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/pets")
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

}
