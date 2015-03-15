package cineplex.service;

import cineplex.exception.MyException;
import cineplex.model.MemberDetail;
import cineplex.model.User;

import java.util.List;

/**
 * Created by wlw on 15-3-6.
 */
public interface UserManageService {
    public User login(String username, String password);
    public boolean addWaiter(User user);
    public void addMember(User user,MemberDetail memberDetail) throws MyException;
    public MemberDetail getDetail(User user);
    public void changeMemberDetail(MemberDetail memberDetail);
    public void recharge(String cardNumber, Double money,User user) throws MyException;
    public List getRechargeHistory(User user);
    public List getAllMember();
    public User getUserByUsername(String username);
    public void changeUser(User user);
}
