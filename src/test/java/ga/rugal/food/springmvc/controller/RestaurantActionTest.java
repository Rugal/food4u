package ga.rugal.food.springmvc.controller;

import ga.rugal.ControllerClientSideTestBase;
import ga.rugal.food.core.entity.Menu;
import ga.rugal.food.core.entity.Restaurant;
import ga.rugal.food.core.service.MenuService;
import ga.rugal.food.core.service.RestaurantService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author Ying Mi, Rugal Bernstein
 */
public class RestaurantActionTest extends ControllerClientSideTestBase
{

    public RestaurantActionTest()
    {

    }

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private Restaurant restaurant;

    @Autowired
    private MenuService menuService;

    @Autowired
    private Menu menu;

    @Before
    public void setUp()
    {
        System.out.println("setUp");
        restaurantService.getDAO().save(restaurant);
        menuService.getDAO().save(menu);
    }

    @After
    public void tearDown()
    {
        System.out.println("tearDown");
        menuService.getDAO().deleteByPK(menu.getMid());
        restaurantService.getDAO().deleteByPK(restaurant.getRid());
    }

    @Test
    public void testRandomRestaurant() throws Exception
    {
        System.out.println("randomRestaurant");
        MvcResult result = this.mockMvc.perform(get("/restaurant")
            .accept(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(status().isOk())
            .andDo(print())
            .andReturn();
        Restaurant getFromDB = restaurant.backToObject(result.getResponse().getContentAsString());
        Assert.assertNotNull(getFromDB);
    }

    @Test
    public void testGetRestaurant() throws Exception
    {
        System.out.println("getRestaurant");
        MvcResult result = this.mockMvc.perform(get(String.format("/restaurant/%d", restaurant.getRid()))
            .accept(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(status().isOk())
            .andDo(print())
            .andReturn();
        Restaurant getFromDB = restaurant.backToObject(result.getResponse().getContentAsString());
        Assert.assertNotNull(getFromDB);
    }

    @Test
    public void testGetImage() throws Exception
    {
        System.out.println("getImage");
        this.mockMvc.perform(get(String.format("/restaurant/%d", restaurant.getRid()))
            .accept(MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_JPEG_VALUE,
                    MediaType.IMAGE_PNG_VALUE, MediaType.APPLICATION_JSON_VALUE))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    public void testGetMissedImage() throws Exception
    {
        System.out.println("getMissedImage");
        this.mockMvc.perform(get(String.format("/restaurant/%d", 0))
            .accept(MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_JPEG_VALUE,
                    MediaType.IMAGE_PNG_VALUE, MediaType.APPLICATION_JSON_VALUE))
            .andDo(print())
            .andExpect(status().isNotFound());
    }
}
