package cineplex.action;

import cineplex.model.MemberDetail;
import cineplex.model.User;
import cineplex.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by wlw on 15-3-15.
 */
@Repository
public class CancelAction extends BaseAction {
    @Autowired
    private UserManageService userManageService;

    public String execute()
    {
        User user=(User)session.get("user");
        MemberDetail memberDetail=userManageService.getDetail(user);
        memberDetail.setState(MemberDetail.CANCEL);
        userManageService.changeMemberDetail(memberDetail);
        request.setAttribute("mess", "取消成功");
        return SUCCESS;
    }
}
