package com.advantageshopping.data;

import com.advantageshopping.model.Usuario;
import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class UsuarioDataFactory {

    private final Faker faker;
    private static final Logger logger = LogManager.getLogger(UsuarioDataFactory.class);

    public UsuarioDataFactory(){
        faker = new Faker();
    }

    public Usuario criarUsuario(){
         Usuario usuario = new Usuario().builder().
                userName(faker.name().username()).
                email(faker.internet().emailAddress()).
                password(faker.internet().password()).
                fisrtName(faker.name().firstName()).
                lastName(faker.name().lastName()).
                phone(faker.phoneNumber().toString()).
                City(faker.address().city()).
                address(faker.address().fullAddress()).
                state(faker.address().state()).
                postal(faker.address().zipCode()).build();

         logger.info(usuario);

         return usuario;
    }
}
