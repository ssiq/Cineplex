package cineplex.dao.impl;

import cineplex.dao.BaseDao;
import cineplex.dao.UserDao;
import cineplex.model.MemberDetail;
import cineplex.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
