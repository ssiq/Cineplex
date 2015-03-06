package cineplex.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by wlw on 15-3-6.
 */
@Entity
@Table
public class FilmOffice {
    @Id
    private String filmOfficeName;
    private String size;

    public String getFilmOfficeName() {
        return filmOfficeName;
    }

    public void setFilmOfficeName(String filmOfficeName) {
        this.filmOfficeName = filmOfficeName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
