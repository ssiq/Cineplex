package cineplex.action;

import cineplex.model.MemberDetail;
import cineplex.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wlw on 15-3-14.
 */
@Repository
public class SeeAllMemberAction extends BaseAction {

    @Autowired
    private UserManageService userManageService;

    public String execute()
    {
        String title[]=new String[]{"用户名","年龄","卡号","住址","性别","余额","当前状态",""};
        request.setAttribute("title", title);
        List list=userManageService.getAllMember();
        List list1=new LinkedList();
        for(int i=0;i<list.size();++i)
        {
            List in_list=new LinkedList();
            MemberDetail memberDetail=(MemberDetail)list.get(i);
            in_list.add(memberDetail.getUsername().getUsername());
            in_list.add(memberDetail.getAge());
            in_list.add(memberDetail.getCardnumber());
            in_list.add(memberDetail.getPlace());
            in_list.add(memberDetail.getSex());
            in_list.add(memberDetail.getMoney());
            in_list.add(memberDetail.getState());
            in_list.add("<form action=\"\" method=\"post\">" +
                    "<input type=\"hidden\" value=\""+
                    memberDetail.getUsername()+
                    "\"/>" +
                    "<input type=\"submit\" value=\"详情\"/>" +
                    "</form>");
            list1.add(in_list);
        }
        request.setAttribute("list", list1);
        return SUCCESS;
    }
}
