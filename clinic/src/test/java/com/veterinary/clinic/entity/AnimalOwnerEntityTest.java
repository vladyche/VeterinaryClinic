package com.veterinary.clinic.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class AnimalOwnerEntityTest {

    @Test
    void getAnimalOwner() {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(AnimalOwner.class)
                .buildSessionFactory();

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        AnimalOwner animalOwner = new AnimalOwner();
        animalOwner.setFirstName("Firstname");
        animalOwner.setLastName("Lastname");
        animalOwner.setPatronymic("Patronymic");
        animalOwner.setPhone("+0001112233");
        animalOwner.setEmail("mail@mail.com");

        Set<ConstraintViolation<AnimalOwner>> constraintViolations = validator.validate(animalOwner);

        //Show errors
//        if (constraintViolations.size() > 0) {
//            for (ConstraintViolation<AnimalOwner> violation : constraintViolations) {
//                violation.getMessageTemplate();
//            }
//        } else {
//            System.out.println("Valid Object");
//        }

        try (sessionFactory; Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            session.save(animalOwner);
            AnimalOwner o = session.get(AnimalOwner.class, 1L);

            assertEquals(animalOwner, o);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
