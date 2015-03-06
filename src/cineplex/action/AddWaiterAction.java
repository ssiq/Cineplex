package cineplex.action;

import cineplex.model.User;
import cineplex.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by wlw on 15-3-6.
 */
@Repository
public class AddWaiterAction extends BaseAction{
    @Autowired
    private UserManageService userManageService;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String execute(){
        if(user==null)
        {
            System.out.println("fisrt in the addWaiter page");
            user=new User();
            user.setPassword("");
            user.setUsername("");
            return INPUT;
        }

        System.out.println("next time in the addWaiter page");
        user.setIdentity("1");
        if(userManageService.addWaiter(user)){
            request.setAttribute("mess", "服务员添加成功");
            return SUCCESS;
        }else{
            String message="用户名已存在";
            request.setAttribute("mess", message);
            return INPUT;
        }
    }
}
