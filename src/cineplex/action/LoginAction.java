package cineplex.action;

/**
 * Created by wlw on 15-3-6.
 */
public class LoginAction extends BaseAction{

    private String username;
    private String password;
    private String type;
    private static final String MEMBER="0";
    private static final String WAITER="1";
    private static final String MANAGER="2";

    public String execute(){
        if(type.equals(MEMBER)){
            return SUCCESS;
        }else if(type.equals(WAITER)){
            return SUCCESS;
        }else if(type.equals(MANAGER)){
            return SUCCESS;
        }else{
            return SUCCESS;
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
