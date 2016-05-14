package ga.rugal.food.core.service.impl;

import ga.rugal.DBTestBase;
import ga.rugal.food.core.entity.Tag;
import ga.rugal.food.core.service.TagService;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Rugal Bernstein
 */
public class TagServiceImplTest extends DBTestBase
{

    @Autowired
    private TagService tagService;

    @Autowired
    private Tag tag;

    public TagServiceImplTest()
    {
    }

    @Before
    public void setUp()
    {
        System.out.println("setUp");
        tagService.getDAO().save(tag);
    }

    @After
    public void tearDown()
    {
        System.out.println("tearDown");
        tagService.getDAO().deleteByPK(tag.getTid());
    }

    @Test
    @Ignore
    public void test()
    {

    }
}
