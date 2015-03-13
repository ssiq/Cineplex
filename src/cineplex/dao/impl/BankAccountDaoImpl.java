package cineplex.dao.impl;

import cineplex.dao.BankAccountDao;
import cineplex.dao.BaseDao;
import cineplex.model.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by wlw on 15-3-13.
 */
@Repository
public class BankAccountDaoImpl implements BankAccountDao{
    @Autowired
    BaseDao baseDao;

    @Override
    public BankAccount getAccount(String cardNumber) {
        BankAccount bankAccount=(BankAccount)baseDao.load(BankAccount.class, cardNumber);
        return bankAccount;
    }

    @Override
    public void save(BankAccount bankAccount) {
        baseDao.save(bankAccount);
    }

    @Override
    public void update(BankAccount bankAccount) {
        baseDao.update(bankAccount);
    }
}
