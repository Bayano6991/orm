package com.de.fhswf.orm.data_factory;

import com.de.fhswf.orm.entity.Address;
import com.de.fhswf.orm.entity.Child;
import com.de.fhswf.orm.entity.Hobby;
import com.de.fhswf.orm.entity.Parent;
import com.de.fhswf.orm.repositories.HobbyRepository;
import com.de.fhswf.orm.repositories.ParentRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired private ParentRepository parentRepository;
    @Autowired private HobbyRepository hobbyRepository;

    List<String> hobbies = List.of("Fußball", "Lesen", "Reiten", "Schwimmen", "Gitarre", "Kochen", "Reisen", "Tennis",
            "Basketball", "Radfahren", "Malen");


    private final Faker faker = new Faker();

    @Override
    public void run(String... args) throws Exception {

        Hobby h1 = new Hobby(); h1.setName(getRandomHobby());
        Hobby h2 = new Hobby(); h2.setName(getRandomHobby());
        Hobby h3 = new Hobby(); h3.setName(getRandomHobby());

        hobbyRepository.saveAll(List.of(h1, h2, h3));



        for (int i = 0; i < 10; i++) {
            Address address = new Address();
            address.setCity(faker.address().city());
            address.setStreet(faker.address().streetName());
            address.setZipCode(faker.address().zipCode());

            Parent parent = new Parent();
            parent.setFirstname(faker.name().fullName());
            parent.setLastname(faker.name().lastName());
            parent.setEmail(faker.internet().emailAddress());
            parent.setAddress(address);

            Child child = new Child();
            child.setFirstname(faker.name().firstName());
            child.setLastname(faker.name().lastName());
            child.setParent(parent);
            parent.getChildren().add(child);

            child.getHobbies().add(h1);
            child.getHobbies().add(h2);
            child.getHobbies().add(h3);

            parentRepository.save(parent);
        }
    }


    private String getRandomHobby() {
        Random random = new Random();
        return hobbies.get(random.nextInt(hobbies.size()));
    }
}
