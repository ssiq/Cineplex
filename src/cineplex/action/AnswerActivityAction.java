package cineplex.action;

import cineplex.service.ActivityManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wlw on 15-3-14.
 */
@Repository
public class AnswerActivityAction extends BaseAction{

    @Autowired
    ActivityManageService activityManageService;

    private String activityId;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String execute()
    {
        List list=activityManageService.getActivityDetailByActivityId(activityId);
        request.setAttribute("question_list", list);
        return SUCCESS;
    }
}
