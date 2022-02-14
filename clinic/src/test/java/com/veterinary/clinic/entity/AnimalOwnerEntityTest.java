package com.veterinary.clinic.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalOwnerEntityTest {

    @Test
    void getAnimalOwner(){
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(AnimalOwner.class)
                .buildSessionFactory();

        try (sessionFactory; Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            AnimalOwner animalOwner = new AnimalOwner();
            animalOwner.setFirstName("Firstname");
            animalOwner.setLastName("Lastname");
            animalOwner.setPatronymic("Patronymic");
            animalOwner.setPhone("+0001112233");
            animalOwner.setEmail("mail@mail.com");

            session.save(animalOwner);

            AnimalOwner o = session.get(AnimalOwner.class, 1L);

            assertEquals(animalOwner, o);
            
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
