package ga.rugal.food.core.dao.impl;

import ga.rugal.food.core.dao.TaggingDao;
import ga.rugal.food.core.entity.Tagging;
import ml.rugal.sshcommon.hibernate.HibernateBaseDao;
import ml.rugal.sshcommon.page.Pagination;
import org.hibernate.Criteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rugal Bernstein
 */
@Repository
public class TaggingDaoImpl extends HibernateBaseDao<Tagging, Long> implements TaggingDao
{

    private static final Logger LOG = LoggerFactory.getLogger(TaggingDaoImpl.class.getName());

    @Override
    @Transactional(readOnly = true)
    public Pagination getPage(int pageNo, int pageSize)
    {
        Criteria crit = createCriteria();
        Pagination page = findByCriteria(crit, pageNo, pageSize);
        return page;
    }

    @Override
    @Transactional(readOnly = true)
    public Tagging getByPK(Long id)
    {
        Tagging entity = get(id);
        return entity;
    }

    @Override
    public Tagging save(Tagging bean)
    {
        getSession().save(bean);
        return bean;
    }

    @Override
    public Tagging deleteByPK(Long id)
    {
        Tagging entity = super.get(id);
        if (entity != null)
        {
            getSession().delete(entity);
        }
        return entity;
    }

    @Override
    protected Class<Tagging> getEntityClass()
    {
        return Tagging.class;
    }

}
