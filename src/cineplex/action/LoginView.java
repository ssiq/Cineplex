package cineplex.action;

/**
 * Created by wlw on 15-3-7.
 */
public class LoginView extends BaseAction {
    public String execute(){
        if(session.get("user")==null)
        {
            return SUCCESS;
        }else{
            return INPUT;
        }
    }
}
