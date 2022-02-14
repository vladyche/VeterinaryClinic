package com.veterinary.clinic.dao;

import com.veterinary.clinic.configuration.ClinicAppConfig;
import com.veterinary.clinic.entity.AnimalOwner;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalOwnerDaoTest {

    @Test
    public void createTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ClinicAppConfig.class);
        AnimalOwnerDao animalOwnerDao = context.getBean("animalOwnerDao", AnimalOwnerDaoImpl.class);

        AnimalOwner animalOwner = new AnimalOwner();
        animalOwner.setFirstName("Firstname");
        animalOwner.setLastName("Lastname");
        animalOwner.setPatronymic("Patronymic");
        animalOwner.setPhone("+0001112233");
        animalOwner.setEmail("mail@mail.com");

        assertEquals(animalOwner, animalOwnerDao.save(animalOwner));

        context.close();
    }
}
