package cineplex.dao;

import cineplex.model.MemberDetail;
import cineplex.model.User;

import java.util.List;

/**
 * Created by wlw on 15-3-6.
 */
public interface UserDao{
    public void save(User user);
    public List find(String column, String value);
    public void save(MemberDetail memberDetail);
    public MemberDetail getDetail(User user);
    public void updateMemberDetail(MemberDetail memberDetail);
    public List findMemberDetail(String column, Object value);
    public List allMember();
    public void updateUser(User user);
    public List findOverOneYearMember();
    public List findAnalyse(String columnName);
}
