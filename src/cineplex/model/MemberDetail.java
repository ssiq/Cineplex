package cineplex.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by wlw on 15-3-10.
 */
@Entity
@Table
public class MemberDetail implements Serializable{
    @Id
    @OneToOne(targetEntity=User.class, cascade= CascadeType.ALL, optional=false)
    private User username;
    private String sex;
    private String place;
    private String age;
    @Column(length = 7)
    private String cardnumber;
    private Double money;
    private Date date;
    private String state;
    private Date lastStateChangeDate;
    private Integer credits;

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getLastStateChangeDate() {
        return lastStateChangeDate;
    }

    public void setLastStateChangeDate(Date lastStateChangeDate) {
        this.lastStateChangeDate = lastStateChangeDate;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public static final String ACTIVE="active";
    //暂停
    public static final String SLEEP="sleep";
    //停止
    public static final String STOP="stop";
    //取消
    public static final String CANCEL="cancel";
}
