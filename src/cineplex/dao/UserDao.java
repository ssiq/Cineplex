package cineplex.dao;

import cineplex.model.User;

import java.util.List;

/**
 * Created by wlw on 15-3-6.
 */
public interface UserDao{
    public void save(User user);
    public List find(String column, String value);
}
