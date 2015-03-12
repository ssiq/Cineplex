package cineplex.service;

import cineplex.exception.MyException;
import cineplex.model.MemberDetail;
import cineplex.model.User;

/**
 * Created by wlw on 15-3-6.
 */
public interface UserManageService {
    public User login(String username, String password);
    public boolean addWaiter(User user);
    public void addMember(User user,MemberDetail memberDetail) throws MyException;
    public MemberDetail getDetail(User user);
    public void changeMemberDetail(MemberDetail memberDetail);
}
