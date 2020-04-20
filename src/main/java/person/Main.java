package person;

import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.Duration;
import java.time.Year;
import java.time.ZoneId;
import java.util.List;



@Log4j2
public class Main {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example");
    private static Faker faker = new Faker();

    private static Person randomPerson()
    {
            Person person = Person.builder()
                    .name(faker.name().fullName())
                    .dob(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                    .gender(faker.options().option(Person.Gender.class))
                    .address(Address.builder()
                            .country(faker.address().country())
                            .state(faker.address().state())
                            .city(faker.address().city())
                            .streetAddress(faker.address().streetAddress())
                            .zip(faker.address().zipCode())
                            .build())
                    .email(faker.internet().emailAddress())
                    .profession(faker.company().profession())
                    .build();
        return person;
    }


    public static void main(String[] args) {
        randomPerson();
    }

}
