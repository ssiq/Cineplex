package cineplex.dao.impl;

import cineplex.dao.BaseDao;
import cineplex.dao.TicketDao;
import cineplex.model.Ticket;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List find(String name, Object value) {
        Session session = baseDao.getSession();
        String hql="from cineplex.model.Ticket as sp where sp."+name+"=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, value);
        List list=query.list();
        return list;
    }

    @Override
    public List allComsume() {
        Session session = baseDao.getSession();
        String hql="select sum(sp.screeningProgram.price) from cineplex.model.Ticket as sp group by sp.user";
        Query query = session.createQuery(hql);
        return query.list();
    }
}
