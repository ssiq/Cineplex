package cineplex.action;

import cineplex.model.MemberDetail;
import cineplex.model.User;
import cineplex.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by wlw on 15-3-14.
 */
@Repository
public class ChangeMyDetailAction extends BaseAction{

    @Autowired
    private UserManageService userManageService;

    private MemberDetail memberDetail;
    private User user;

    public MemberDetail getMemberDetail() {
        return memberDetail;
    }

    public void setMemberDetail(MemberDetail memberDetail) {
        this.memberDetail = memberDetail;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getView()
    {
        user=(User)session.get("user");
        memberDetail=userManageService.getDetail(user);
        return SUCCESS;
    }

    public String doAction()
    {
        User user1=(User)session.get("user");
        user1.setPassword(user.getPassword());
        MemberDetail memberDetail1=userManageService.getDetail(user1);
        memberDetail1.setAge(memberDetail.getAge());
        memberDetail1.setPlace(memberDetail.getPlace());
        memberDetail1.setSex(memberDetail.getSex());
        userManageService.changeUser(user1);
        userManageService.changeMemberDetail(memberDetail1);
        request.setAttribute("mess", "修改成功");
        return SUCCESS;
    }
}
