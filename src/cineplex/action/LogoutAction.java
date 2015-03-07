package cineplex.action;

import org.springframework.stereotype.Repository;

/**
 * Created by wlw on 15-3-7.
 */
@Repository
public class LogoutAction extends BaseAction{
    public String execute(){
        String key="user";
        if (session.containsKey(key)){
            session.remove(key);
        }
        return SUCCESS;
    }
}

