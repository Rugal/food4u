package ga.rugal.food.core.service.impl;

import ga.rugal.food.core.dao.RestaurantDao;
import ga.rugal.food.core.service.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ying Mi
 */
@Service
public class RestaurantServiceImpl implements RestaurantService
{

    private static final Logger LOG = LoggerFactory.getLogger(RestaurantServiceImpl.class.getName());

    @Autowired
    private RestaurantDao restaurantDao;

    @Override
    public RestaurantDao getDAO()
    {
        return this.restaurantDao;
    }

}
