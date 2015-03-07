package cineplex.service;

import cineplex.model.FilmOffice;

import java.util.List;

/**
 * Created by wlw on 15-3-6.
 */
public interface FilmOfficeManageService {
    public boolean addFilmOffice(FilmOffice filmOffice);
    public List<String> getAllFilmOfficeName();
}
