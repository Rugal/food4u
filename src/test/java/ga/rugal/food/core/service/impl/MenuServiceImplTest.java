package ga.rugal.food.core.service.impl;

import ga.rugal.DBTestBase;
import ga.rugal.food.core.dao.ClientDao;
import ga.rugal.food.core.dao.RestaurantDao;
import ga.rugal.food.core.dao.TagDao;
import ga.rugal.food.core.dao.TaggingDao;
import ga.rugal.food.core.entity.Client;
import ga.rugal.food.core.entity.Menu;
import ga.rugal.food.core.entity.Restaurant;
import ga.rugal.food.core.entity.Tag;
import ga.rugal.food.core.entity.Tagging;
import ga.rugal.food.core.service.MenuService;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Ying Mi, Rugal Bernstein
 */
public class MenuServiceImplTest extends DBTestBase
{

    @Autowired
    private Restaurant restaurant;

    @Autowired
    private Client client;

    @Autowired
    private Tag tag;

    @Autowired
    private Tagging tagging;

    @Autowired
    private Menu menu;

    @Autowired
    private RestaurantDao restaurantDao;

    @Autowired
    private ClientDao clientDao;

    @Autowired
    private TagDao tagDao;

    @Autowired
    private TaggingDao taggingDao;

    @Autowired
    private MenuService menuService;

    public MenuServiceImplTest()
    {

    }

    @Before
    public void setUp()
    {
        System.out.println("setUp");
        clientDao.save(client);
        tagDao.save(tag);
        restaurantDao.save(restaurant);
        menuService.getDAO().save(menu);
        taggingDao.save(tagging);
    }

    @After
    public void tearDown()
    {
        System.out.println("tearDown");
        taggingDao.deleteByPK(tagging.getGid());
        menuService.getDAO().deleteByPK(menu.getMid());
        restaurantDao.deleteByPK(restaurant.getRid());
        clientDao.deleteByPK(client.getCid());
        tagDao.deleteByPK(tag.getTid());
    }

    @Test
    @Ignore
    public void test()
    {

    }
}
