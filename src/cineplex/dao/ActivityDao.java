package cineplex.dao;

import cineplex.model.Activity;
import cineplex.model.ActivityDetail;
import cineplex.model.User;

import java.util.List;

/**
 * Created by wlw on 15-3-14.
 */
public interface ActivityDao {
    public void addActivity(Activity activity,List activityDetailList);
    public List getActivityByFilmName(String filmName);
    public List getActivityDetailbyActivity(Activity activity);
    public List getAllCanDoActivity(User user);
    public void saveList(List list);
}
