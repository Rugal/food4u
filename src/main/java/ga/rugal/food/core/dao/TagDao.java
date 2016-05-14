package ga.rugal.food.core.dao;

import ga.rugal.food.core.entity.Menu;
import ga.rugal.food.core.entity.Tag;
import java.util.List;
import ml.rugal.sshcommon.hibernate.Updater;
import ml.rugal.sshcommon.page.Pagination;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rugal Bernstein
 */
public interface TagDao
{

    Tag deleteByPK(Integer id);

    @Transactional(readOnly = true)
    Tag getByPK(Integer id);

    @Transactional(readOnly = true)
    Pagination getPage(int pageNo, int pageSize);

    Tag save(Tag bean);

    Tag updateByUpdater(Updater<Tag> updater);

    /**
     * Get a tag by its name, as tag table has unique index on name column, there will have at most
     * 1 matched tag.
     *
     * @param name
     *
     * @return
     */
    @Transactional(readOnly = true)
    Tag getByName(String name);

    /**
     * Get menu tags list.
     *
     * @param menu
     *
     * @return A list of tag of a menu.
     */
    @Transactional(readOnly = true)
    List<Tag> getTagsOfMenu(Menu menu);
}
