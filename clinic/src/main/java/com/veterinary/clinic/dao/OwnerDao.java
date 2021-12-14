package com.veterinary.clinic.dao;

import com.veterinary.clinic.entity.Owner;

import java.util.List;

public interface OwnerDao {
    Owner create(Owner owner);
    Owner findByPhone(String phoneNumber);
    Owner findById(long id);
    Owner update(Owner owner);
    String delete(long id);
    List<Owner> findAll();
}
