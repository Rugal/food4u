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
 * @author Ying Mi
 */
public class MenuActionTest extends ControllerClientSideTestBase
{

    public MenuActionTest()
    {

    }

    @Autowired
    private Restaurant restaurant;

    @Autowired
    private Menu menu;

    @Autowired
    private MenuService menuService;

    @Autowired
    private RestaurantService restaurantService;

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
    public void testGetRandomMenu() throws Exception
    {
        System.out.println("getRandomMenu");
        MvcResult result = this.mockMvc.perform(get("/menu")
            .accept(MediaType.APPLICATION_JSON_VALUE))
            .andDo(print())
            .andExpect(status().isOk())
            .andReturn();
        Menu getFromDB = menu.backToObject(result.getResponse().getContentAsString());
        Assert.assertNotNull(getFromDB);
    }

    @Test
    public void testGetMenu() throws Exception
    {
        System.out.println("getMenu");
        MvcResult result = this.mockMvc.perform(get(String.format("/menu/%d", menu.getMid()))
            .accept(MediaType.APPLICATION_JSON_VALUE))
            .andDo(print())
            .andExpect(status().isOk())
            .andReturn();
        Menu getFromDB = menu.backToObject(result.getResponse().getContentAsString());
        Assert.assertNotNull(getFromDB);
    }

    @Test
    public void testGetImage() throws Exception
    {
        System.out.println("getImage");
        this.mockMvc.perform(get(String.format("/menu/%d/image", menu.getMid()))
            .accept(MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_JPEG_VALUE,
                    MediaType.IMAGE_PNG_VALUE, MediaType.APPLICATION_JSON_VALUE
            ))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    public void testGetMissedImage() throws Exception
    {
        System.out.println("getMissedImage");
        this.mockMvc.perform(get(String.format("/menu/%d/image", 0))
            .accept(MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_JPEG_VALUE,
                    MediaType.IMAGE_PNG_VALUE, MediaType.APPLICATION_JSON_VALUE
            ))
            .andDo(print())
            .andExpect(status().isNotFound());
    }
}
