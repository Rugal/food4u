package ga.rugal.food.springmvc.controller;

import ga.rugal.food.common.CommonLogContent;
import ga.rugal.food.core.entity.Menu;
import ga.rugal.food.core.service.MenuService;
import ga.rugal.food.core.service.StaticResourceService;
import ga.rugal.food.core.service.TagService;
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
 * @author Ying Mi, Rugal Bernstein
 */
@Controller
@RequestMapping(value = "/menu")
public class MenuAction
{

    private static final Logger LOG = LoggerFactory.getLogger(MenuAction.class.getName());

    @Autowired
    private Random random;

    @Autowired
    private StaticResourceService staticResourceService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private TagService tagService;

    /**
     * GET image by the request menu id. We will return a default picture if no image found or path
     * not accessible for reading.<BR>
     * Currently, this image is {@link config.SystemDefaultProperties#DEFAULT_IMAGE}
     *
     * @param mid
     * @param response
     *
     * @return Give Message object in JSON format if any exception occurs; otherwise, return the
     *         icon data in byte array format.
     *
     */
    @ResponseBody
    @RequestMapping(value = "/{mid}/image", method = RequestMethod.GET)
    public Object getImage(@PathVariable("mid") Integer mid, HttpServletResponse response)
    {
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        Menu menu = menuService.getDAO().getByPK(mid);
        return null == menu ? null : staticResourceService.getImage(menu.getImage(), response);
    }

    @ResponseBody
    @RequestMapping(value = "/{mid}", method = RequestMethod.GET)
    public Object getMenu(@PathVariable("mid") Integer mid, HttpServletResponse response)
    {
        Menu menu = menuService.getDAO().getByPK(mid);
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        if (null == menu)
        {
            LOG.warn(CommonLogContent.NO_MENU);
            return null;
        }
        menu.setTags(tagService.getDAO().getTagsOfMenu(menu));
        response.setStatus(HttpServletResponse.SC_OK);
        return menu;
    }

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Object getRandomMenu(HttpServletResponse response)
    {
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        int total = menuService.getDAO().countTotal();
        LOG.debug(CommonLogContent.RESTAURANT_NUMBER, total);
        if (0 == total)
        {
            LOG.warn(CommonLogContent.NO_RESTAURANT);
            return null;
        }
        response.setStatus(HttpServletResponse.SC_OK);
        Menu menu = (Menu) menuService.getDAO().getPage(random.nextInt(total), 1).getList().get(0);
        menu.setTags(tagService.getDAO().getTagsOfMenu(menu));
        return menu;
    }
}
