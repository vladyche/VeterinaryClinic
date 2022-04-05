package com.veterinary.clinic.service;

import com.veterinary.clinic.dao.AnimalOwnerDao;
import com.veterinary.clinic.entity.AnimalOwner;

import java.util.List;

public class AnimalOwnerServiceImpl implements AnimalOwnerService{
    private AnimalOwnerDao animalOwnerDao;

    public AnimalOwnerServiceImpl() {}

    public AnimalOwnerServiceImpl(AnimalOwnerDao animalOwnerDao) {
        this.animalOwnerDao = animalOwnerDao;
    }

    @Override
    public AnimalOwner create(AnimalOwner animalOwner) {
        return animalOwnerDao.save(animalOwner);
    }

    @Override
    public AnimalOwner readById(long id) {
        return animalOwnerDao.findById(id);
    }

    @Override
    public AnimalOwner readByPhone(String phone) {
        return animalOwnerDao.findByPhone(phone);
    }

    @Override
    public AnimalOwner update(AnimalOwner animalOwner) {
        return animalOwnerDao.update(animalOwner);
    }

    @Override
    public AnimalOwner delete(long id) {
        return null;
    }

    @Override
    public List<AnimalOwner> readAll() {
        return null;
    }
}
