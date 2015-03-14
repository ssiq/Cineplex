package cineplex.service;

import cineplex.model.Activity;
import cineplex.model.ActivityDetail;
import cineplex.model.AnswerActivity;
import cineplex.model.User;

import java.util.List;

/**
 * Created by wlw on 15-3-14.
 */
public interface ActivityManageService {
    public void addActivity(Activity activity,List activityDetailList);
    public List getAllIcanDoActivity(User user);
    public List getActivityDetailByActivityId(String activityId);
    public void setAnswer(List list);
}
