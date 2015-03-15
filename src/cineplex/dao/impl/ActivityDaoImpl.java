package cineplex.dao.impl;

import cineplex.dao.ActivityDao;
import cineplex.dao.BaseDao;
import cineplex.model.Activity;
import cineplex.model.User;
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

    @Override
    public List getAllCanDoActivity(User user) {
        Session session = baseDao.getSession();
        String hql="select distinct ac " +
                "from cineplex.model.Activity as ac, cineplex.model.Ticket as t,cineplex.model.ScreeningProgram as s " +
                "where t.user=? and t.screeningProgram=s and ac.filmName=s.filmName";
        Query query = session.createQuery(hql);
        query.setParameter(0, user);
        return query.list();
    }

    @Override
    public void saveList(List list) {
        for(int i=0;i<list.size();++i)
        {
            baseDao.save(list.get(i));
        }
    }

    @Override
    public List getBestAnswerOneActivity(Activity activity) {
        Session session = baseDao.getSession();
        session.createSQLQuery("SELECT " +
                "from (SELECT  in1.d as d,in1.a as a " +
                "from (SELECT activityDetail_activityDetailId as d,answer as a,COUNT(user_username) as c from AnswerActivity as a WHERE  GROUP BY activityDetail_activityDetailId,answer) as in1," +
                "(SELECT activityDetail_activityDetailId as d,answer as a,COUNT(user_username) as c from AnswerActivity as a GROUP BY activityDetail_activityDetailId,answer) as in2 " +
                "WHERE in1.d=in2.d and in1.c>=in2.c) as ba,AnswerActivity aa");
        return null;
    }
}
