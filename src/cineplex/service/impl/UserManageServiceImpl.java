package cineplex.service.impl;

import cineplex.dao.UserDao;
import cineplex.exception.MyException;
import cineplex.model.MemberDetail;
import cineplex.model.User;
import cineplex.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wlw on 15-3-6.
 */
@Service
public class UserManageServiceImpl implements UserManageService{

    @Autowired
    private UserDao userDao;

    @Override
    public User login(String username, String password) {
        List list=userDao.find("username", username);
        if(list.isEmpty()){
            return null;
        }else{
            User user=(User)list.get(0);
            if(user.getPassword().equals(password))
            {
                return user;
            }else{
                return user;
            }
        }
    }

    @Override
    public boolean addWaiter(User user) {
        if(userDao.find("username", user.getUsername()).isEmpty()){
            userDao.save(user);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void addMember(User user, MemberDetail memberDetail) throws MyException {
        if(userDao.find("username", user.getUsername()).isEmpty()){
            userDao.save(user);
            userDao.save(memberDetail);
        }else{
            throw new MyException("这个用户已存在");
        }
    }
}
