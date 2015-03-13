package cineplex.action;

import cineplex.dao.UserDao;
import cineplex.exception.MyException;
import cineplex.model.User;
import cineplex.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by wlw on 15-3-12.
 */
@Repository
public class RechargeAction extends BaseAction{
    @Autowired
    private UserManageService userManageService;

    private String cardNumber;
    private Double money;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String execute()
    {
        User user=(User)session.get("user");
        try {
            userManageService.recharge(cardNumber, money, user);
            request.setAttribute("mess", "充值成功");
        } catch (MyException e) {
            e.printStackTrace();
            request.setAttribute("mess", e.getMessage());
        }
        return SUCCESS;
    }
}
