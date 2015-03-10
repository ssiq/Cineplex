package cineplex.dao.impl;

import cineplex.dao.BaseDao;
import cineplex.dao.ScreeningProgramDao;
import cineplex.model.ScreeningProgram;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wlw on 15-3-7.
 */
@Repository
public class ScreeningProgramDaoImpl implements ScreeningProgramDao {

    @Autowired
    BaseDao baseDao;

    @Override
    public void save(ScreeningProgram screeningProgram) {
        baseDao.save(screeningProgram);
    }

    @Override
    public List find(String column, String value) {
        Session session = baseDao.getSession();
        String hql="from cineplex.model.ScreeningProgram as sp where "+column+"='"+value+"'";
        Query query = session.createQuery(hql);
        return query.list();
    }

    @Override
    public void update(ScreeningProgram screeningProgram) {
        baseDao.update(screeningProgram);
    }

    @Override
    public List findJoinScreenProgram(ScreeningProgram screeningProgram) {
        Session session = baseDao.getSession();
        String hql="from cineplex.model.ScreeningProgram as sp where sp.date=? and " +
                "sp.beginTime<? and sp.endTime>? and " +
                "sp.filmOffice.filmOfficeName=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, screeningProgram.getDate());
        query.setParameter(1, screeningProgram.getEndTime());
        query.setParameter(2, screeningProgram.getBeginTime());
        query.setParameter(3, screeningProgram.getFilmOffice().getFilmOfficeName());
        List list=query.list();
        if(list.isEmpty())
        {
            System.out.println("no join sp");
        }else{
            for(int i=0;i<list.size();++i)
            {
                System.out.println("join sp:"+list.get(i));
            }
        }
        return list;
    }

    @Override
    public ScreeningProgram findById(Integer screeningProgramId) {
        Session session = baseDao.getSession();
        String hql="from cineplex.model.ScreeningProgram as sp where screeningProgramId="+screeningProgramId;
        Query query = session.createQuery(hql);
        List list=query.list();
        if(list.isEmpty())
        {
            return null;
        }else{
            return (ScreeningProgram)list.get(0);
        }
    }

    @Override
    public List findByUsername(String username) {
        Session session = baseDao.getSession();
        String hql="from cineplex.model.ScreeningProgram as sp where sp.user.username='"+username+"'";
        Query query = session.createQuery(hql);
        List list=query.list();
        return list;
    }
}
