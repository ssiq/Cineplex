package cineplex.dao;

import cineplex.model.BankAccount;

/**
 * Created by wlw on 15-3-13.
 */
public interface BankAccountDao {
    public BankAccount getAccount(String cardNumber);
    public void save(BankAccount bankAccount);
    public void update(BankAccount bankAccount);
}
