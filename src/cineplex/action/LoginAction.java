package cineplex.action;

import cineplex.model.User;
import cineplex.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by wlw on 15-3-6.
 */
@Repository
public class LoginAction extends BaseAction{

    @Autowired
    private UserManageService userManageService;

    private String username;
    private String password;
    private static final String MEMBER="0";
    private static final String WAITER="1";
    private static final String MANAGER="2";

    private String generate_return(User user)
    {
        if(user.getIdentity().equals(MEMBER)){
            return "member_logined";
        }else if(user.getIdentity().equals(WAITER)){
            return "waiter_logined";
        }else if(user.getIdentity().equals(MANAGER)){
            return "manager_logined";
        }else{
            return INPUT;
        }
    }

    public String execute(){

        User user=null;
        if(session.containsKey("user"))
        {
            System.out.println("old login");
            user=(User)session.get("user");
            return generate_return(user);
        }else{
            System.out.println("new login");
            if(username==null){
                username="";
            }

            if(password==null){
                password="";
            }

            user=userManageService.login(username.trim(), password.trim());
            if(user!=null){
                session.put("user", user);
                return generate_return(user);
            }else{
                return INPUT;
            }
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
