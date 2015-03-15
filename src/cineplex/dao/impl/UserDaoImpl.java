package cineplex.dao.impl;

import cineplex.dao.BaseDao;
import cineplex.dao.UserDao;
import cineplex.model.MemberDetail;
import cineplex.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by wlw on 15-3-6.
 */
@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    private BaseDao baseDao;

    @Override
    public void save(User user) {
        baseDao.save(user);
    }

    @Override
    public List find(String column, String value) {
        Session session = baseDao.getSession();
        String hql="from cineplex.model.User as u where "+column+"='"+value+"'";
        Query query = session.createQuery(hql);
        return query.list();
    }

    @Override
    public void save(MemberDetail memberDetail) {
        baseDao.save(memberDetail);
    }

    @Override
    public MemberDetail getDetail(User user) {
        Session session = baseDao.getSession();
        String hql="from cineplex.model.MemberDetail as m where m.username=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, user);
        List list=query.list();
        if(list.isEmpty())
        {
            return null;
        }else {
            return (MemberDetail)list.get(0);
        }
    }

    @Override
    public void updateMemberDetail(MemberDetail memberDetail) {
        baseDao.update(memberDetail);
    }

    @Override
    public List findMemberDetail(String column, Object value) {
        Session session = baseDao.getSession();
        String hql="from cineplex.model.MemberDetail as m where m."+column+"=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, value);
        List list=query.list();
        return list;
    }

    @Override
    public List allMember() {
        return baseDao.getAllList(MemberDetail.class);
    }

    @Override
    public void updateUser(User user) {
        baseDao.update(user);
    }

    @Override
    public List findOverOneYearMember() {
        Session session = baseDao.getSession();
        String hql="from cineplex.model.MemberDetail as m where m.lastStateChangeDate<?";
        Query query = session.createQuery(hql);
        Calendar calendar=Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR)-1, calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        query.setParameter(0, calendar.getTime());
        List list=query.list();
        return list;
    }
}
