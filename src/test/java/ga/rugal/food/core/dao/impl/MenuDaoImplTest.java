package ga.rugal.food.core.dao.impl;

import ga.rugal.DBTestBase;
import ga.rugal.food.core.dao.MenuDao;
import ga.rugal.food.core.dao.RestaurantDao;
import ga.rugal.food.core.dao.TagDao;
import ga.rugal.food.core.dao.TaggingDao;
import ga.rugal.food.core.entity.Client;
import ga.rugal.food.core.entity.Menu;
import ga.rugal.food.core.entity.Restaurant;
import ga.rugal.food.core.entity.Tag;
import ga.rugal.food.core.entity.Tagging;
import ml.rugal.sshcommon.page.Pagination;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Rugal Bernstein
 */
public class MenuDaoImplTest extends DBTestBase
{

    @Autowired
    private Menu menu;

    @Autowired
    private Tagging tagging;

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private TagDao tagDao;

    @Autowired
    private Restaurant restaurant;

    @Autowired
    private Tag tag;

    @Autowired
    private Client client;

    @Autowired
    private TaggingDao taggingDao;

    @Autowired
    private RestaurantDao restaurantDao;

    public MenuDaoImplTest()
    {
    }

    @Before
    public void setUp()
    {
        //set null for client in tagging to prevent saving "client" object
        tagging.setClient(null);
        System.out.println("setUp");
        tagDao.save(tag);
        restaurantDao.save(restaurant);
        menuDao.save(menu);
        taggingDao.save(tagging);
        tagging.setClient(client);
    }

    @After
    public void tearDown()
    {
        System.out.println("tearDown");
        taggingDao.deleteByPK(tagging.getGid());
        menuDao.deleteByPK(menu.getMid());
        restaurantDao.deleteByPK(restaurant.getRid());
        tagDao.deleteByPK(tag.getTid());
    }

    @Test
    public void testGetPage()
    {
        System.out.println("getPage");
        int pageNo = 1;
        int pageSize = 1;
        Pagination result = menuDao.getPage(pageNo, pageSize);
        Assert.assertEquals(1, result.getList().size());
    }

    @Test
    public void testGetByID()
    {
        System.out.println("getByID");
        Integer id = menu.getMid();
        Assert.assertNotNull(menuDao.getByPK(id));
    }

    @Test
    public void testCountTotal()
    {
        System.out.println("countTotal");
        int count = menuDao.countTotal();
        Assert.assertTrue(count > 0);
    }

    @Test
    public void testCountMenusByRestaurant()
    {
        System.out.println("countMenusByRestaurant");
        Restaurant r = menu.getRestaurant();
        int count = menuDao.countMenusByRestaurant(r);
        Assert.assertTrue(count > 0);
    }

    @Test
    public void testGetRandomMenuByRestaurant()
    {
        System.out.println("getRandomMenuByRestaurant");
        Restaurant r = menu.getRestaurant();
        Menu m = menuDao.getRandomMenuByRestaurant(r);
        Assert.assertNotNull(m);

    }
}
