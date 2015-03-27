package cineplex.dao;

import cineplex.model.NumberCountPerDay;

import java.util.Date;
import java.util.List;

/**
 * Created by wlw on 15-3-18.
 */
public interface NumberCountPerDayDao {
    public void addCount(Date date,Integer number);
    public NumberCountPerDay findById(Date date);
    public List oneTimeSegmentNumberCount(Date begin,Date end);
}
