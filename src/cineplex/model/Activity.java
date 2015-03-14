package cineplex.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by wlw on 15-3-14.
 */
@Entity
@Table
public class Activity {
    @Id
    private String activityId;
    private String filmName;
    private String title;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
