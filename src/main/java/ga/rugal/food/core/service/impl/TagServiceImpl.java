package ga.rugal.food.core.service.impl;

import ga.rugal.food.core.dao.TagDao;
import ga.rugal.food.core.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rugal Bernstein
 */
@Service
public class TagServiceImpl implements TagService
{

    @Autowired
    private TagDao tagDao;

    @Override
    public TagDao getDAO()
    {
        return this.tagDao;
    }
}
