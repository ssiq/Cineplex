package cineplex.timerTask;

import cineplex.Utility.Utility;
import cineplex.dao.ActivityDao;
import cineplex.dao.ScreeningProgramDao;
import cineplex.dao.UserDao;
import cineplex.model.Activity;
import cineplex.model.ActivityDetail;
import cineplex.model.MemberDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by wlw on 15-3-15.
 */
@Component("dayTask")
public class DayTask {

    @Autowired
    private UserDao userDao;

    private void changeMemberState()
    {
        List list=userDao.findOverOneYearMember();
        for(int i=0;i<list.size();++i)
        {
            MemberDetail memberDetail=(MemberDetail)list.get(i);
            if(memberDetail.getState().equals(MemberDetail.ACTIVE))
            {
                if(memberDetail.getMoney()<200)
                {
                    memberDetail.setState(MemberDetail.SLEEP);
                }
            }else if(memberDetail.getState().equals(MemberDetail.SLEEP)){
                memberDetail.setState(MemberDetail.STOP);
            }
            memberDetail.setLastStateChangeDate(Utility.getNowDate());
            userDao.save(memberDetail);
        }
    }

    @Autowired
    private ScreeningProgramDao screeningProgramDao;

    @Autowired
    private ActivityDao activityDao;

    private void accountActivity()
    {
        List activityList=screeningProgramDao.allCanSummaryActivity();
        for(int i=0;i<activityList.size();++i)
        {
            Activity activity=(Activity)activityList.get(i);
            List detailList=activityDao.getActivityDetailbyActivity(activity);
            for(int j=0;j<detailList.size();++j)
            {
                ActivityDetail activityDetail=(ActivityDetail)detailList.get(j);
            }
        }
    }

    @Scheduled(cron = " 0 0 0 * * ?")
    public void doTask()
    {
        changeMemberState();
        accountActivity();
    }
}
