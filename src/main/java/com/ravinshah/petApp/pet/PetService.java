package com.ravinshah.petApp.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    PetRepository petRepository;

    public void add(Pet pet) {
        petRepository.save(pet);
    }

    public void update(Pet pet) throws PetNotFoundException {
        if(!petRepository.existsById(String.valueOf(pet.getId())))
            throw new PetNotFoundException("Pet not found");
        petRepository.save(pet);
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Optional<Pet> getPet(Long id) {
        return petRepository.findById(String.valueOf(id));
    }

    public void delete(String id) {
        if(petRepository.existsById(id))
            petRepository.deleteById(id);
    }
}
