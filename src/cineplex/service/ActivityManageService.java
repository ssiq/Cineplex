package cineplex.service;

import cineplex.model.Activity;
import cineplex.model.ActivityDetail;

import java.util.List;

/**
 * Created by wlw on 15-3-14.
 */
public interface ActivityManageService {
    public void addActivity(Activity activity,List activityDetailList);
}
