package com.veterinary.clinic.service;

import com.veterinary.clinic.entity.AnimalOwner;

import java.util.List;

public interface AnimalOwnerService {
    AnimalOwner create(AnimalOwner animalOwner);
    AnimalOwner readById(long id);
    AnimalOwner readByPhone(String phone);
    AnimalOwner update(AnimalOwner animalOwner);
    AnimalOwner delete(long id);
    List<AnimalOwner> readAll();
}
