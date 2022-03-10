package com.veterinary.clinic.controller;

import com.veterinary.clinic.config.AppBeans;
import com.veterinary.clinic.entity.AnimalOwner;
import com.veterinary.clinic.service.AnimalOwnerService;
import com.veterinary.clinic.service.AnimalOwnerServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/animal-owner")
public class AnimalOwnerController {

    @GetMapping("/{animal_owner_id}")
    public String animalOwner(@PathVariable String animal_owner_id, Model model){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppBeans.class);
        AnimalOwnerService animalOwnerService = context.getBean("animalOwnerService", AnimalOwnerServiceImpl.class);

        model.addAttribute("animalOwner", animalOwnerService.readById(Long.parseLong(animal_owner_id)));

        context.close();
        return "animal-owner";
    }

    @GetMapping("/create")
    public String animalOwnerCreate(){
        return "animal-owner-create";
    }

    @GetMapping("/update/{animal_owner_id}")
    public String animalOwnerUpdatePage(@PathVariable String animal_owner_id, Model model){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppBeans.class);
        AnimalOwnerService animalOwnerService = context.getBean("animalOwnerService", AnimalOwnerServiceImpl.class);

        model.addAttribute("animalOwner", animalOwnerService.readById(Long.parseLong(animal_owner_id)));

        context.close();
        return "animal-owner-update";
    }

    @PostMapping("/update")
    public String animalOwnerUpdate(@ModelAttribute("animalOwner") AnimalOwner animalOwner){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppBeans.class);
        AnimalOwnerService animalOwnerService = context.getBean("animalOwnerService", AnimalOwnerServiceImpl.class);

        animalOwnerService.update(animalOwner);

        String url = "/animal-owner/update/" + animalOwner.getId();
        return "redirect:" + url;
    }

    @GetMapping("/search")
    public String animalOwnerSearchPage(){
        return "animal-owner-search";
    }

    @PostMapping("/search")
    public String animalOwnerSearch(@RequestParam(name="phone") String phone, Model model){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppBeans.class);
        AnimalOwnerService animalOwnerService = context.getBean("animalOwnerService", AnimalOwnerServiceImpl.class);

        AnimalOwner animalOwner = animalOwnerService.readByPhone(phone);

        if(animalOwner != null){
            String url = "/animal-owner/" + animalOwner.getId();
            return "redirect:" + url;
        }

        context.close();
        return "animal-owner-search";
    }
}

