package cineplex.dao.impl;

import cineplex.dao.BaseDao;
import cineplex.dao.RechargeRecordDao;
import cineplex.model.RechargeRecord;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wlw on 15-3-13.
 */
@Repository
public class RechargeRecordDaoImpl implements RechargeRecordDao {
    @Autowired
    BaseDao baseDao;

    @Override
    public void save(RechargeRecord rechargeRecord) {
        baseDao.save(rechargeRecord);
    }

    @Override
    public void update(RechargeRecord rechargeRecord) {
        baseDao.update(rechargeRecord);
    }

    @Override
    public List find(String colunmName, Object column) {
        Session session = baseDao.getSession();
        String hql="from cineplex.model.RechargeRecord as rr where rr."+colunmName+"=?";
        Query query = session.createQuery(hql);
        List list=query.list();
        return list;
    }
}
