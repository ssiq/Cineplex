package cineplex.model;

import cineplex.action.ExtraList;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wlw on 15-3-7.
 */
@Entity
@Table
public class ScreeningProgram implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "paymentableGenerator", strategy = "native")
    private Integer screeningProgramId;
    private String filmName;
    private Date date;
    private Time beginTime;
    private Time endTime;
    private Double price;
    private String tag;
    private String state;
    @ManyToOne(targetEntity=User.class,cascade=CascadeType.ALL, optional=false)
    private User user;
    @ManyToOne(targetEntity=FilmOffice.class,cascade=CascadeType.ALL, optional=false)
    private FilmOffice filmOffice;
    private Integer left_number;
    private Integer card_buy_user;

    public Integer getScreeningProgramId() {
        return screeningProgramId;
    }

    public void setScreeningProgramId(Integer screeningProgramId) {
        this.screeningProgramId = screeningProgramId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date data) {
        this.date = data;
    }

    public Time getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Time beginTime) {
        this.beginTime = beginTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public FilmOffice getFilmOffice() {
        return filmOffice;
    }

    public void setFilmOffice(FilmOffice filmOffice) {
        this.filmOffice = filmOffice;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public Integer getLeft_number() {
        return left_number;
    }

    public void setLeft_number(Integer left_number) {
        this.left_number = left_number;
    }

    public Integer getCard_buy_user() {
        return card_buy_user;
    }

    public void setCard_buy_user(Integer card_buy_user) {
        this.card_buy_user = card_buy_user;
    }

    public final static String WAIT="wait";
    public final static String ACCEPT="accept";
    public final static String REFUSE="refuse";

    @Override
    public String toString() {
        return "ScreeningProgram{" +
                "screeningProgramId=" + screeningProgramId +
                ", filmName='" + filmName + '\'' +
                ", date=" + date +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", price=" + price +
                ", tag='" + tag + '\'' +
                ", state='" + state + '\'' +
                ", user=" + user +
                ", filmOffice=" + filmOffice +
                '}';
    }

    public List toList(ExtraList e){
        List list=new LinkedList();
        list.add(filmName);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        list.add(format.format(date));
        list.add(beginTime);
        list.add(endTime);
        list.add(price);
        list.add(filmOffice.getFilmOfficeName());
        list.addAll(e.toList(this));
        return list;
    }
}
