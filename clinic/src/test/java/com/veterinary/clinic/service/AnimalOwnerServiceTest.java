package com.veterinary.clinic.service;

import com.veterinary.clinic.config.ClinicAppConfig;
import com.veterinary.clinic.entity.AnimalOwner;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalOwnerServiceTest {

    @Test
    public void createTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ClinicAppConfig.class);
        AnimalOwnerService animalOwnerService = context.getBean("animalOwnerService", AnimalOwnerServiceImpl.class);

        AnimalOwner animalOwner = new AnimalOwner();
        animalOwner.setFirstName("Firstname");
        animalOwner.setLastName("Lastname");
        animalOwner.setPatronymic("Patronymic");
        animalOwner.setPhone("+0001112233");
        animalOwner.setEmail("mail@mail.com");

        assertEquals(animalOwner, animalOwnerService.create(animalOwner));

        context.close();

    }
}
