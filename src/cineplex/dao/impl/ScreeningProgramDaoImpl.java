package cineplex.dao.impl;

import cineplex.dao.BaseDao;
import cineplex.dao.ScreeningProgramDao;
import cineplex.model.ScreeningProgram;
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
        String hql="from cineplex.model.ScreeningProgram as sp where sp.date='"+screeningProgram.getDate()+"' and " +
                "sp.beginTime<'"+screeningProgram.getEndTime()+"' and sp.endTime>'"+screeningProgram.getBeginTime()+"' and " +
                "sp.filmOffice.filmOfficeName='"+screeningProgram.getFilmOffice().getFilmOfficeName()+"'";
        Query query = session.createQuery(hql);
        return query.list();
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
}
