package cineplex.action;

import cineplex.model.User;
import cineplex.service.TicketManageService;
import cineplex.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by wlw on 15-3-14.
 */
@Repository
public class MyDetailAction extends BaseAction {

    @Autowired
    UserManageService userManageService;

    @Autowired
    TicketManageService ticketManageService;

    public String execute()
    {
        User user=(User)session.get("user");
        return SeeOneMemberDetailAction.doGetDetail(user, userManageService, ticketManageService, request);
    }
}
