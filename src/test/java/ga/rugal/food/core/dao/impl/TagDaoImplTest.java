package ga.rugal.food.core.dao.impl;

import ga.rugal.DBTestBase;
import ga.rugal.food.core.dao.MenuDao;
import ga.rugal.food.core.dao.TagDao;
import ga.rugal.food.core.entity.MealType;
import ga.rugal.food.core.entity.Menu;
import ga.rugal.food.core.entity.Tag;
import java.util.List;
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
public class TagDaoImplTest extends DBTestBase
{

    @Autowired
    private Tag tag;

    @Autowired
    private Menu menu;

    @Autowired
    private TagDao tagDao;

    @Autowired
    private MenuDao menuDao;

    public TagDaoImplTest()
    {
    }

    @Before
    public void setUp()
    {
        System.out.println("setUp");
        tagDao.save(tag);
    }

    @After
    public void tearDown()
    {
        System.out.println("tearDown");
        tagDao.deleteByPK(tag.getTid());
    }

    @Test
    public void testGetPage()
    {
        System.out.println("getPage");
        int pageNo = 1;
        int pageSize = 1;
        Pagination result = tagDao.getPage(pageNo, pageSize);
        Assert.assertEquals(1, result.getList().size());
    }

    @Test
    public void testGetByPK()
    {
        System.out.println("getByID");
        Integer id = tag.getTid();
        Assert.assertNotNull(tagDao.getByPK(id));
    }

    @Test
    public void testGetByName()
    {
        System.out.println("getByName");
        String name = MealType.breakfast.toString();
        Tag result = tagDao.getByName(name);
        Assert.assertNotNull(result);

    }

    @Test
    public void testGetTagsOfMenu()
    {
        System.out.println("getTagsOfMenu");
        Menu bean = menuDao.getByPK(35);

        List<Tag> result = tagDao.getTagsOfMenu(bean);
        Assert.assertEquals(2, result.size());
    }

}
