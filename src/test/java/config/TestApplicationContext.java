package config;

import ga.rugal.food.core.entity.Client;
import ga.rugal.food.core.entity.Menu;
import ga.rugal.food.core.entity.Restaurant;
import ga.rugal.food.core.entity.Tag;
import ga.rugal.food.core.entity.Tagging;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Java based application context configuration class.
 * <p>
 * Including data source and transaction manager configuration.
 *
 * @author Rugal Bernstein
 * @since 0.1
 */
@Configuration
public class TestApplicationContext
{

    private static final Logger LOG = LoggerFactory.getLogger(TestApplicationContext.class.getName());

    @Bean
    public Client client()
    {
        return new Client()
            .setCredential("Test credential")
            .setEmail("Test@email.com")
            .setName("Rugal Bernstein")
            .setPhone("123456789");
    }

    @Bean
    public Tag tag()
    {
        return new Tag()
            .setName("Test tag");
    }

    @Bean
    public Restaurant restaurant()
    {
        return new Restaurant()
            .setAddress("University of Winsor")
            .setName("CAW")
            .setPhone("321543654")
            .setPostalcode("N9C2M3");
    }

    @Bean
    @Autowired
    public Menu menu(Restaurant restaurant)
    {
        return new Menu()
            .setName("great cussine")
            .setPrice(10.23)
            .setImage(SystemDefaultProperties.DEFAULT_IMAGE)
            .setRestaurant(restaurant);
    }

    @Bean
    @Autowired
    public Tagging tagging(Restaurant restaurant, Menu menu, Tag tag, Client client)
    {
        return new Tagging()
            .setClient(client)
            .setMenu(menu)
            .setTag(tag)
            .setRate(5);
    }
}
