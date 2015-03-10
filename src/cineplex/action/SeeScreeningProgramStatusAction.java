package cineplex.action;

import cineplex.model.User;
import cineplex.service.ScreeningProgramManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wlw on 15-3-9.
 */
@Repository
public class SeeScreeningProgramStatusAction extends BaseAction{

    @Autowired
    private ScreeningProgramManageService screeningProgramManageService;

    public String execute(){
        User user=(User)session.get("user");
        List list=screeningProgramManageService.getMyScreeningProgramManage(user);
        request.setAttribute("MyList", list);
        return SUCCESS;
    }
}
