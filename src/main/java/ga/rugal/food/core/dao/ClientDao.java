package ga.rugal.food.core.dao;

import ga.rugal.food.core.entity.Client;
import ml.rugal.sshcommon.hibernate.Updater;
import ml.rugal.sshcommon.page.Pagination;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rugal Bernstein
 */
public interface ClientDao
{

    Client deleteByPK(Integer id);

    @Transactional(readOnly = true)
    Client getByPK(Integer id);

    @Transactional(readOnly = true)
    Pagination getPage(int pageNo, int pageSize);

    Client save(Client bean);

    Client updateByUpdater(Updater<Client> updater);
}
