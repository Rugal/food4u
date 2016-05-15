package ga.rugal.food.core.service.impl;

import ga.rugal.food.core.dao.MenuDao;
import ga.rugal.food.core.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ying Mi, Rugal Bernstein
 */
@Service
public class MenuServiceImpl implements MenuService
{

    @Autowired
    private MenuDao menuDao;

    @Override
    public MenuDao getDAO()
    {
        return this.menuDao;
    }
}
