package cineplex.action;

import cineplex.model.ActivityDetail;
import cineplex.model.AnswerActivity;
import cineplex.model.User;
import cineplex.service.ActivityManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wlw on 15-3-14.
 */
@Repository
public class DoAnswerActivityAction extends BaseAction {

    @Autowired
    private ActivityManageService activityManageService;

    private List<String> answerList=new ArrayList<String>();
    private List<Integer> activityDetailIdList=new ArrayList<Integer>();

    public List<String> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<String> answerList) {
        this.answerList = answerList;
    }

    public List<Integer> getActivityDetailIdList() {
        return activityDetailIdList;
    }

    public void setActivityDetailIdList(List<Integer> activityDetailIdList) {
        this.activityDetailIdList = activityDetailIdList;
    }

    public String execute(){
        User user=(User)session.get("user");
        List<AnswerActivity> answerActivityList=new LinkedList<AnswerActivity>();
        for(int i=0;i<answerList.size();++i)
        {
            AnswerActivity answerActivity=new AnswerActivity();
            answerActivity.setUser(user);
            answerActivity.setAnswer(answerList.get(i));
            ActivityDetail activityDetail=new ActivityDetail();
            activityDetail.setActivityDetailId(activityDetailIdList.get(i));
            answerActivity.setActivityDetail(activityDetail);
            answerActivityList.add(answerActivity);
        }
        activityManageService.setAnswer(answerActivityList);
        request.setAttribute("mess", "您的答案已提交");
        return SUCCESS;
    }
}
