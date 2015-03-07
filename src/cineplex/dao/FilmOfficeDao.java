package cineplex.dao;

import cineplex.model.FilmOffice;

import java.util.List;

/**
 * Created by wlw on 15-3-6.
 */
public interface FilmOfficeDao {
    public void save(FilmOffice filmOffice);
    public List find(String column, String value);
    public List all();
}
