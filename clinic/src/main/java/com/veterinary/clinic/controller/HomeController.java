package com.veterinary.clinic.controller;

import com.veterinary.clinic.config.ClinicAppConfig;
import com.veterinary.clinic.entity.AnimalOwner;
import com.veterinary.clinic.service.AnimalOwnerService;
import com.veterinary.clinic.service.AnimalOwnerServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ClinicAppConfig.class);
        AnimalOwnerService animalOwnerService = context.getBean("animalOwnerService", AnimalOwnerServiceImpl.class);

        AnimalOwner animalOwner = new AnimalOwner();
        animalOwner.setFirstName("Firstname1");
        animalOwner.setLastName("Lastname1");
        animalOwner.setPatronymic("Patronymic1");
        animalOwner.setPhone("+0001112233");
        animalOwner.setEmail("mail@mail.com");

        System.out.println(animalOwnerService.create(animalOwner));

        return "home";
    }
}
