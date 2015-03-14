package cineplex.service.impl;

import cineplex.dao.ActivityDao;
import cineplex.dao.TicketDao;
import cineplex.model.Activity;
import cineplex.model.User;
import cineplex.service.ActivityManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wlw on 15-3-14.
 */
@Service
public class ActivityManageServiceImpl implements ActivityManageService {

    @Autowired
    ActivityDao activityDao;

    @Autowired
    TicketDao ticketDao;

    @Override
    public void addActivity(Activity activity, List activityDetailList) {
        activityDao.addActivity(activity, activityDetailList);
    }

    @Override
    public List getAllIcanDoActivity(User user) {
        return activityDao.getAllCanDoActivity(user);
    }
}
