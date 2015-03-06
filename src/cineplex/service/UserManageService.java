package cineplex.service;

import cineplex.model.User;

/**
 * Created by wlw on 15-3-6.
 */
public interface UserManageService {
    public User login(String username, String password);
    public boolean addWaiter(User user);
}
