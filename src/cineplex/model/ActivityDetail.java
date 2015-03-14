package cineplex.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by wlw on 15-3-14.
 */
@Entity
@Table
public class ActivityDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "paymentableGenerator", strategy = "native")
    private Integer activityDetailId;
    @ManyToOne(targetEntity=Activity.class,cascade=CascadeType.ALL, optional=false)
    private Activity activity;
    private String question;
    private String answer;

    public Integer getActivityDetailId() {
        return activityDetailId;
    }

    public void setActivityDetailId(Integer activityDetailId) {
        this.activityDetailId = activityDetailId;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "ActivityDetail{" +
                "activityDetailId=" + activityDetailId +
                ", activity=" + activity +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
