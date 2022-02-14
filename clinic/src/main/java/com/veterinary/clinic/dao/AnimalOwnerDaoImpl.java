package com.veterinary.clinic.dao;

import com.veterinary.clinic.entity.AnimalOwner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class AnimalOwnerDaoImpl implements AnimalOwnerDao {
    private SessionFactory sessionFactory;

    public AnimalOwnerDaoImpl(){}

    public AnimalOwnerDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public AnimalOwner save(AnimalOwner animalOwner) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(animalOwner);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.sessionFactory.close();
        }

        //TODO: return a real record from database

        return animalOwner;
    }

    @Override
    public AnimalOwner findByPhone(String phoneNumber) {
        return null;
    }

    @Override
    public AnimalOwner findById(long id) {
        return null;
    }

    @Override
    public AnimalOwner update(AnimalOwner animalOwner) {
        return null;
    }

    @Override
    public String delete(long id) {
        return null;
    }

    @Override
    public List<AnimalOwner> findAll() {
        return null;
    }
}
