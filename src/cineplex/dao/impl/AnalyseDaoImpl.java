package cineplex.dao.impl;

import cineplex.dao.AnalyseDao;
import cineplex.dao.BaseDao;
import cineplex.model.Analyse;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by wlw on 15-3-15.
 */
@Repository
public class AnalyseDaoImpl implements AnalyseDao {

    @Autowired
    private BaseDao baseDao;

    @Override
    public void save(Analyse analyse) {
        baseDao.save(analyse);
    }

    @Override
    public List all() {
        return baseDao.getAllList(Analyse.class);
    }

    @Override
    public Analyse getAnalyseById(Date date) {
        Session session = baseDao.getSession();
        String hql="from Analyse as a where a.date=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, date);
        List list=query.list();
        if(list.isEmpty())
        {
            return null;
        }else{
            return (Analyse)list.get(0);
        }
    }
}
