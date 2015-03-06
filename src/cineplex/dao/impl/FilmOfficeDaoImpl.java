package cineplex.dao.impl;

import cineplex.dao.BaseDao;
import cineplex.dao.FilmOfficeDao;
import cineplex.model.FilmOffice;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wlw on 15-3-6.
 */
@Repository
public class FilmOfficeDaoImpl implements FilmOfficeDao {

    @Autowired
    private BaseDao baseDao;

    @Override
    public void save(FilmOffice filmOffice) {
        baseDao.save(filmOffice);
    }

    @Override
    public List find(String column, String value) {
        Session session = baseDao.getSession();
        String hql="from cineplex.model.FilmOffice as fo where "+column+"='"+value+"'";
        Query query = session.createQuery(hql);
        return query.list();
    }
}
