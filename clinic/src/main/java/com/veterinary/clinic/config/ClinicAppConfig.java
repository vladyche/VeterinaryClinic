package com.veterinary.clinic.config;

import com.veterinary.clinic.dao.AnimalOwnerDao;
import com.veterinary.clinic.dao.AnimalOwnerDaoImpl;
import com.veterinary.clinic.entity.AnimalOwner;
import com.veterinary.clinic.service.AnimalOwnerService;
import com.veterinary.clinic.service.AnimalOwnerServiceImpl;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClinicAppConfig {

    @Bean
    public SessionFactory sessionFactory(){
        return new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(AnimalOwner.class)
                .buildSessionFactory();
    }

    @Bean
    public AnimalOwnerDao animalOwnerDao(){
        return new AnimalOwnerDaoImpl(sessionFactory());
    }

    @Bean
    public AnimalOwnerService animalOwnerService(){
        return new AnimalOwnerServiceImpl(animalOwnerDao());
    }
}
