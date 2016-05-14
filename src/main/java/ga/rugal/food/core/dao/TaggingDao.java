package ga.rugal.food.core.dao;

import ga.rugal.food.core.entity.Tagging;
import ml.rugal.sshcommon.hibernate.Updater;
import ml.rugal.sshcommon.page.Pagination;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rugal Bernstein
 */
public interface TaggingDao
{

    Tagging deleteByPK(Long id);

    @Transactional(readOnly = true)
    Tagging getByPK(Long id);

    @Transactional(readOnly = true)
    Pagination getPage(int pageNo, int pageSize);

    Tagging save(Tagging bean);

    Tagging updateByUpdater(Updater<Tagging> updater);
}
