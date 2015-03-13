package cineplex.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wlw on 15-3-13.
 */
@Entity
@Table
public class RechargeRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "paymentableGenerator", strategy = "native")
    private Integer rechargeRcordId;
    private Double money;
    @ManyToOne(targetEntity=User.class,cascade=CascadeType.ALL, optional=false)
    private User user;
    private Date date;

    public Integer getRechargeAccountId() {
        return rechargeRcordId;
    }

    public void setRechargeAccountId(Integer rechargeAccountId) {
        this.rechargeRcordId = rechargeAccountId;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
