package ga.rugal.food.core.dao.impl;

import ga.rugal.food.core.dao.TagDao;
import ga.rugal.food.core.entity.Menu;
import ga.rugal.food.core.entity.Tag;
import ga.rugal.food.core.entity.Tagging;
import java.util.List;
import ml.rugal.sshcommon.hibernate.HibernateBaseDao;
import ml.rugal.sshcommon.page.Pagination;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rugal Bernstein
 */
@Repository
public class TagDaoImpl extends HibernateBaseDao<Tag, Integer> implements TagDao
{

    private static final Logger LOG = LoggerFactory.getLogger(TagDaoImpl.class.getName());

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
    public Tag getByPK(Integer id)
    {
        Tag entity = get(id);
        return entity;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    @Transactional(readOnly = true)
    public List<Tag> getTagsOfMenu(Menu menu)
    {
        //I prefer subquery
        //select * from tag where tid in (select tid from tagging where mid = 36);
        //Subquery for menus that from given menu
        DetachedCriteria subquery1 = DetachedCriteria.forClass(Tagging.class);
        subquery1.add(Restrictions.eq("menu", menu));
        subquery1.setProjection(Property.forName("tag.tid"));

        //Get tag list
        Criteria crit = createCriteria();
        crit.add(Subqueries.propertyIn("tid", subquery1));
        return crit.list();
    }

    @Override
    @Transactional(readOnly = true)
    public Tag getByName(String name)
    {
        Tag entity = super.findUniqueByProperty("name", name);
        return entity;
    }

    @Override
    public Tag save(Tag bean)
    {
        getSession().save(bean);
        return bean;
    }

    @Override
    public Tag deleteByPK(Integer id)
    {
        Tag entity = super.get(id);
        if (entity != null)
        {
            getSession().delete(entity);
        }
        return entity;
    }

    @Override
    protected Class<Tag> getEntityClass()
    {
        return Tag.class;
    }

}
