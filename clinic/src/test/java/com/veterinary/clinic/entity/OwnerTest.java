package com.veterinary.clinic.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OwnerTest {
    private static Owner owner;

    @BeforeAll
    static void init(){
        owner = new Owner();
        owner.setFirstName("John");
    }

    @Test
    void owner(){
//        SessionFactory sessionFactory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Owner.class)
//                .buildSessionFactory();
//
//        try (sessionFactory; Session session = sessionFactory.getCurrentSession()) {
//            session.beginTransaction();
//
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Owner>> violations = validator.validate(owner);

        assertEquals(0, violations.size());
    }
}
