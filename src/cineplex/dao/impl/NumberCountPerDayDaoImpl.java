package cineplex.dao.impl;

import cineplex.dao.BaseDao;
import cineplex.dao.NumberCountPerDayDao;
import cineplex.model.NumberCountPerDay;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by wlw on 15-3-18.
 */
@Repository
public class NumberCountPerDayDaoImpl implements NumberCountPerDayDao {

    @Autowired
    private BaseDao baseDao;
    private Date date;

    @Override
    public void addCount(Date date,Integer number) {
        this.date = date;
        NumberCountPerDay numberCountPerDay=findById(date);
        if(numberCountPerDay==null)
        {
            numberCountPerDay=new NumberCountPerDay();
            numberCountPerDay.setDate(date);
            numberCountPerDay.setNumber(number);
            baseDao.save(numberCountPerDay);
        }else{
            numberCountPerDay.setNumber(numberCountPerDay.getNumber()+number);
            baseDao.update(numberCountPerDay);
        }

    }

    @Override
    public List oneTimeSegmentNumberCount(Date begin, Date end) {
        Session session = baseDao.getSession();
        String hql="from cineplex.model.NumberCountPerDay where date>=? and date<?";
        Query query = session.createQuery(hql);
        query.setParameter(0, begin);
        query.setParameter(1, end);
        List list=query.list();
        return list;
    }

    @Override
    public NumberCountPerDay findById(Date date) {
        Session session = baseDao.getSession();
        String hql="from cineplex.model.NumberCountPerDay where date=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, date);
        List list=query.list();
        if(list.isEmpty())
        {
            return null;
        }else{
            return (NumberCountPerDay)list.get(0);
        }
    }
}
