package ga.rugal.food.core.dao.impl;

import ga.rugal.ControllerClientSideTestBase;
import ga.rugal.food.core.dao.ClientDao;
import ga.rugal.food.core.entity.Client;
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
public class ClientDaoImplTest extends ControllerClientSideTestBase
{

    @Autowired
    private Client client;

    @Autowired
    private ClientDao clientDao;

    public ClientDaoImplTest()
    {
    }

    @Before
    public void setUp()
    {
        System.out.println("setUp");
        clientDao.save(client);
    }

    @After
    public void tearDown()
    {
        System.out.println("tearDown");
        clientDao.deleteByPK(client.getCid());
    }

    @Test
    public void testGetPage()
    {
        System.out.println("getPage");
        int pageNo = 1;
        int pageSize = 1;
        Pagination result = clientDao.getPage(pageNo, pageSize);
        Assert.assertEquals(1, result.getList().size());
        System.out.println("verified");
    }

    @Test
    public void testGetByPK()
    {
        System.out.println("getByID");
        Integer id = client.getCid();
        Assert.assertNotNull(clientDao.getByPK(id));
    }
}
