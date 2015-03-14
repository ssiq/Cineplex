package cineplex.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by wlw on 15-3-14.
 */
@Entity
@Table
public class AnswerActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "paymentableGenerator", strategy = "native")
    private Integer answerActivityId;
    @ManyToOne(targetEntity=ActivityDetail.class,cascade=CascadeType.ALL, optional=false)
    private ActivityDetail activityDetail;
    private String answer;
    @ManyToOne(targetEntity=User.class,cascade=CascadeType.ALL, optional=false)
    private User user;

    public Integer getAnswerActivityId() {
        return answerActivityId;
    }

    public void setAnswerActivityId(Integer answerActivityId) {
        this.answerActivityId = answerActivityId;
    }

    public ActivityDetail getActivityDetail() {
        return activityDetail;
    }

    public void setActivityDetail(ActivityDetail activityDetail) {
        this.activityDetail = activityDetail;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
