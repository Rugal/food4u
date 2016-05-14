package ga.rugal.food.springmvc.controller;

import ga.rugal.food.common.CommonLogContent;
import ga.rugal.food.core.dao.RestaurantDao;
import ga.rugal.food.core.entity.Restaurant;
import ga.rugal.food.core.service.RestaurantService;
import ga.rugal.food.core.service.StaticResourceService;
import java.util.Random;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Ying Mi
 */
@Controller
@RequestMapping(value = "/restaurant")
public class RestaurantAction
{

    private static final Logger LOG = LoggerFactory.getLogger(RestaurantAction.class.getName());

    @Autowired
    private Random random;

    @Autowired
    private StaticResourceService staticResourceService;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private RestaurantDao restaurantDao;

    /**
     * Find a restaurant randomly from table. Get restaurant information through URL /restaurant
     *
     * @param response
     *
     * @return Give successful message and restaurant data in JSON format if exists, otherwise
     *         return failed message
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Object randomRestaurant(HttpServletResponse response)
    {
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        int total = restaurantService.getDAO().countTotal();
        LOG.debug(CommonLogContent.RESTAURANT_NUMBER, total);
        if (0 == total)
        {
            LOG.warn(CommonLogContent.NO_RESTAURANT);
            return null;
        }
        response.setStatus(HttpServletResponse.SC_OK);
        Restaurant restaurant = (Restaurant) restaurantService.getDAO().getPage(random.nextInt(total), 1).getList().get(0);
        return restaurant;
    }

    /**
     * GET image by the request restaurant id. A default image will be returned if image cannot be
     * found.
     *
     * @param rid
     * @param response
     *
     * @return Give Message object in JSON format if any exception occurs; otherwise, return the
     *         icon data in byte array format.
     *
     */
    @ResponseBody
    @RequestMapping(value = "/{rid}/image")
    public Object getImage(@PathVariable("rid") Integer rid, HttpServletResponse response)
    {
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        Restaurant restaurant = restaurantDao.getByPK(rid);
        return null == restaurant ? null : staticResourceService.getImage(restaurant.getImage(), response);
    }

    /**
     * Get a specific restaurant by restaurant id. Return restaurant not found if the restaurant id
     * is invalid.
     *
     * @param rid
     * @param response
     *
     * @return Give successful message and restaurant data in JSON format if exists, otherwise
     *         return failed message
     */
    @ResponseBody
    @RequestMapping(value = "/{rid}")
    public Object getRestaurant(@PathVariable("rid") Integer rid, HttpServletResponse response)
    {
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        Restaurant restaurant = restaurantDao.getByPK(rid);
        //In case of invalid restaurant id
        if (null == restaurant)
        {
            LOG.warn(CommonLogContent.NO_RESTAURANT);
            return null;
        }
        response.setStatus(HttpServletResponse.SC_OK);
        return restaurant;

    }

}
