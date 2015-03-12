package cineplex.dao.impl;

import cineplex.dao.BaseDao;
import cineplex.dao.TicketDao;
import cineplex.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by wlw on 15-3-12.
 */
@Repository
public class TicketDaoImpl implements TicketDao {

    @Autowired
    BaseDao baseDao;

    @Override
    public void save(Ticket ticket) {
        baseDao.save(ticket);
    }
}
