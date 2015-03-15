package cineplex.service.impl;

import cineplex.dao.BankAccountDao;
import cineplex.dao.RechargeRecordDao;
import cineplex.dao.UserDao;
import cineplex.exception.MyException;
import cineplex.model.BankAccount;
import cineplex.model.MemberDetail;
import cineplex.model.RechargeRecord;
import cineplex.model.User;
import cineplex.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by wlw on 15-3-6.
 */
@Service
public class UserManageServiceImpl implements UserManageService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private BankAccountDao bankAccountDao;

    @Autowired
    private RechargeRecordDao rechargeRecordDao;

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

    @Override
    public MemberDetail getDetail(User user) {
        MemberDetail memberDetail=userDao.getDetail(user);
        return memberDetail;
    }

    @Override
    public void changeMemberDetail(MemberDetail memberDetail) {
        userDao.updateMemberDetail(memberDetail);
    }

    @Override
    public void recharge(String cardNumber, Double money, User user) throws MyException {
        BankAccount bankAccount=(BankAccount)bankAccountDao.getAccount(cardNumber);
        if(bankAccount==null)
        {
            throw new MyException("该银行账户不存在");
        }

        if(bankAccount.getBalance()<money)
        {
            throw new MyException("该银行账户余额不足");
        }

        MemberDetail memberDetail=userDao.getDetail(user);
        if(memberDetail==null)
        {
            throw new MyException("用户不存在");
        }

        bankAccount.setBalance(bankAccount.getBalance()-money);
        bankAccountDao.update(bankAccount);
        memberDetail.setMoney(memberDetail.getMoney()+money);
        userDao.updateMemberDetail(memberDetail);
        RechargeRecord rechargeRecord=new RechargeRecord();
        rechargeRecord.setMoney(money);
        rechargeRecord.setDate(new Date());
        rechargeRecord.setUser(user);
        rechargeRecordDao.save(rechargeRecord);
    }

    @Override
    public List getRechargeHistory(User user) {
        return rechargeRecordDao.find("user", user);
    }

    @Override
    public List getAllMember() {
        return userDao.allMember();
    }

    @Override
    public User getUserByUsername(String username) {
        List list=(List)userDao.find("username", username);
        if(list.isEmpty())
        {
            return null;
        }else{
            return (User)list.get(0);
        }
    }

    @Override
    public void changeUser(User user) {
        userDao.updateUser(user);
    }
}
