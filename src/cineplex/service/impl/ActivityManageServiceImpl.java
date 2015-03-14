package cineplex.service.impl;

import cineplex.dao.ActivityDao;
import cineplex.model.Activity;
import cineplex.service.ActivityManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wlw on 15-3-14.
 */
@Service
public class ActivityManageServiceImpl implements ActivityManageService {

    @Autowired
    ActivityDao activityDao;

    @Override
    public void addActivity(Activity activity, List activityDetailList) {
        activityDao.addActivity(activity, activityDetailList);
    }
}
