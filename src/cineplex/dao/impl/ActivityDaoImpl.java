package cineplex.dao.impl;

import cineplex.dao.ActivityDao;
import cineplex.dao.BaseDao;
import cineplex.model.Activity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wlw on 15-3-14.
 */
@Repository
public class ActivityDaoImpl implements ActivityDao{
    @Autowired
    BaseDao baseDao;

    @Override
    public void addActivity(Activity activity, List activityDetailList) {
        baseDao.save(activity);
        for(int i=0;i<activityDetailList.size();++i)
        {
            baseDao.save(activityDetailList.get(i));
        }
    }

    @Override
    public List getActivityByFilmName(String filmName) {
        Session session = baseDao.getSession();
        String hql="from cineplex.model.Activity as fo where filmName='"+filmName+"'";
        Query query = session.createQuery(hql);
        return query.list();
    }

    @Override
    public List getActivityDetailbyActivity(Activity activity) {
        Session session = baseDao.getSession();
        String hql="from cineplex.model.ActivityDetail as ad where ad.activity=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, activity);
        return query.list();
    }
}
