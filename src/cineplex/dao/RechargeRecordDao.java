package cineplex.dao;

import cineplex.model.RechargeRecord;

import java.util.List;

/**
 * Created by wlw on 15-3-13.
 */
public interface RechargeRecordDao {
    public void save(RechargeRecord rechargeRecord);
    public void update(RechargeRecord rechargeRecord);
    public List find(String colunmName, Object column);
}
