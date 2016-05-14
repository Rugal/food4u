package ga.rugal.food.core.dao.impl;

import ga.rugal.DBTestBase;
import ga.rugal.food.core.dao.RestaurantDao;
import ga.rugal.food.core.entity.Restaurant;
import ml.rugal.sshcommon.page.Pagination;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Rugal Bernstein, Ying Mi
 */
public class RestaurantDaoImplTest extends DBTestBase
{

    @Autowired
    private Restaurant restaurant;

    @Autowired
    private RestaurantDao restaurantDao;

    public RestaurantDaoImplTest()
    {

    }

    @Before
    public void setUp()
    {

        System.out.println("setUp");
        restaurantDao.save(restaurant);
    }

    @After
    public void tearDown()
    {

        System.out.println("tearDown");
        restaurantDao.deleteByPK(restaurant.getRid());
    }

    @Test
    @Ignore
    public void testGetPage()
    {

        System.out.println("getPage");
        int pageNo = 1;
        int pageSize = 1;
        Pagination result = restaurantDao.getPage(pageNo, pageSize);
        Assert.assertEquals(1, result.getList().size());
    }

    @Test
    @Ignore
    public void testGetByPK()
    {

        System.out.println("getByID");
        Integer id = restaurant.getRid();
        Assert.assertNotNull(restaurantDao.getByPK(id));
    }
}
