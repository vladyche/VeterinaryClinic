package com.veterinary.clinic.controller;

import com.veterinary.clinic.config.AppBeans;
import com.veterinary.clinic.entity.AnimalOwner;
import com.veterinary.clinic.service.AnimalOwnerService;
import com.veterinary.clinic.service.AnimalOwnerServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/animal-owner")
public class AnimalOwnerController {

    @GetMapping("")
    public String animalOwnerIndexPage(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppBeans.class);
        AnimalOwnerService animalOwnerService = context.getBean("animalOwnerService", AnimalOwnerServiceImpl.class);

        context.close();
        return "animal-owner/animal-owner-index";
    }

    @GetMapping("/{animal_owner_id}")
    public String animalOwnerPage(@PathVariable String animal_owner_id, Model model){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppBeans.class);
        AnimalOwnerService animalOwnerService = context.getBean("animalOwnerService", AnimalOwnerServiceImpl.class);

        model.addAttribute("animalOwner", animalOwnerService.readById(Long.parseLong(animal_owner_id)));

        context.close();
        return "animal-owner/animal-owner";
    }

    @GetMapping("/create")
    public String animalOwnerCreatePage(Model model){
        model.addAttribute("animalOwner", new AnimalOwner());
        return "animal-owner/animal-owner-create";
    }

    @PostMapping("/create")
    public String animalOwnerCreate(@Validated @ModelAttribute("animalOwner") AnimalOwner animalOwner, BindingResult result){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppBeans.class);
        AnimalOwnerService animalOwnerService = context.getBean("animalOwnerService", AnimalOwnerServiceImpl.class);

        if(result.hasErrors()){
            return "animal-owner/animal-owner-create";
        }

        AnimalOwner o = animalOwnerService.create(animalOwner);

        String url = "/animal-owner/update/" + o.getId();
        return "redirect:" + url;
    }

    @GetMapping("/update/{animal_owner_id}")
    public String animalOwnerUpdatePage(@PathVariable String animal_owner_id, Model model){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppBeans.class);
        AnimalOwnerService animalOwnerService = context.getBean("animalOwnerService", AnimalOwnerServiceImpl.class);

        model.addAttribute("animalOwner", animalOwnerService.readById(Long.parseLong(animal_owner_id)));

        context.close();
        return "animal-owner/animal-owner-update";
    }

    @PostMapping("/update")
    public String animalOwnerUpdate(@Validated @ModelAttribute("animalOwner") AnimalOwner animalOwner, BindingResult result){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppBeans.class);
        AnimalOwnerService animalOwnerService = context.getBean("animalOwnerService", AnimalOwnerServiceImpl.class);

        if(result.hasErrors()){
            return "animal-owner/animal-owner-update";
        }

        AnimalOwner o = animalOwnerService.update(animalOwner);

        String url = "/animal-owner/update/" + o.getId();
        return "redirect:" + url;
    }

    @GetMapping("/search")
    public String animalOwnerSearchPage(){
        return "animal-owner/animal-owner-search";
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
        return "animal-owner/animal-owner-search";
    }
}

