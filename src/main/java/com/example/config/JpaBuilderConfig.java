package com.example.config;

import java.util.HashMap;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;

@Configuration
public class JpaBuilderConfig {

    @Bean
    public EntityManagerFactoryBuilder entityManagerFactoryBuilder(
            JpaVendorAdapter jpaVendorAdapter,
            ObjectProvider<PersistenceUnitManager> persistenceUnitManager) {

        return new EntityManagerFactoryBuilder(
                jpaVendorAdapter,
                new HashMap<>(),
                persistenceUnitManager.getIfAvailable());
    }
    
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        return new org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter();
    }

}
