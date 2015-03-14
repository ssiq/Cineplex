package cineplex.action;

import cineplex.Utility.Utility;
import cineplex.model.Activity;
import cineplex.model.ActivityDetail;
import cineplex.model.User;
import cineplex.service.ActivityManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wlw on 15-3-14.
 */
@Repository
public class DoAddActivityAction extends BaseAction {

    @Autowired
    ActivityManageService activityManageService;

    private Activity activity;
    private List<ActivityDetail> activityDetailList=new ArrayList<ActivityDetail>();

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public List<ActivityDetail> getActivityDetailList() {
        return activityDetailList;
    }

    public void setActivityDetailList(List<ActivityDetail> activityDetailList) {
        this.activityDetailList = activityDetailList;
    }

    public String execute()
    {
        User user=(User)session.get("user");
        activity.setActivityId(Utility.generateId(user.getUsername()));
        for(int i=0;i<activityDetailList.size();++i)
        {
            activityDetailList.get(i).setActivity(activity);
        }
        activityManageService.addActivity(activity, activityDetailList);
        request.setAttribute("mess", "添加成功");
        return SUCCESS;
    }
}
