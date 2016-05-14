package ga.rugal.food.core.dao;

import ga.rugal.food.core.entity.Menu;
import ga.rugal.food.core.entity.Restaurant;
import ml.rugal.sshcommon.hibernate.Updater;
import ml.rugal.sshcommon.page.Pagination;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rugal Bernstein
 */
public interface MenuDao
{

    Menu save(Menu bean);

    Menu deleteByPK(Integer id);

    @Transactional(readOnly = true)
    Menu getByPK(Integer id);

    @Transactional(readOnly = true)
    Pagination getPage(int pageNo, int pageSize);

    Menu updateByUpdater(Updater<Menu> updater);

    @Transactional(readOnly = true)
    Integer countTotal();

    /**
     * Count the total number of matched menus with a specific restaurant
     *
     * @param r
     *
     * @return Give the number of menus
     */
    @Transactional(readOnly = true)
    int countMenusByRestaurant(Restaurant r);

    /**
     * Get a menu randomly from all matched menus
     *
     * @param r
     *
     * @return Give the number of menus corresponding to the specific restaurant if the restaurant
     *         exist, otherwise return 0 as the count number.
     */
    @Transactional(readOnly = true)
    Menu getRandomMenuByRestaurant(Restaurant r);
}
