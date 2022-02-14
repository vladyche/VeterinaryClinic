package com.veterinary.clinic.dao;

import com.veterinary.clinic.entity.AnimalOwner;

import java.util.List;

public interface AnimalOwnerDao {
    AnimalOwner save(AnimalOwner animalOwner);
    AnimalOwner findByPhone(String phoneNumber);
    AnimalOwner findById(long id);
    AnimalOwner update(AnimalOwner animalOwner);
    String delete(long id);
    List<AnimalOwner> findAll();
}
