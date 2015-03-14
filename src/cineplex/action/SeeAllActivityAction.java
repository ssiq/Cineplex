package cineplex.action;

import cineplex.model.Activity;
import cineplex.model.User;
import cineplex.service.ActivityManageService;
import cineplex.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wlw on 15-3-14.
 */
@Repository
public class SeeAllActivityAction extends BaseAction{

    @Autowired
    ActivityManageService activityManageService;

    public String execute()
    {
        String title[]=new String[]{"相关电影","标题",""};
        request.setAttribute("title", title);

        User user=(User)session.get("user");
        List list=activityManageService.getAllIcanDoActivity(user);
        List list1=new LinkedList();
        for(int i=0;i<list.size();++i)
        {
            List in_list=new LinkedList();
            Activity activity=(Activity)list.get(i);
            in_list.add(activity.getFilmName());
            in_list.add(activity.getTitle());
            in_list.add("<form method=\"post\" action=\"answerActivity\">" +
                    "<input type=\"hidden\" name=\"activityId\" value=\""+activity.getActivityId()+"\"/>" +
                    "<input type=\"submit\" value=\"答题\"/>" +
                    "</form>");
            list1.add(in_list);
        }
        request.setAttribute("list", list1);
        return SUCCESS;
    }
}
