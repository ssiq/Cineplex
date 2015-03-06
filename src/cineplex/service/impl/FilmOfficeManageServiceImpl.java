package cineplex.service.impl;

import cineplex.dao.FilmOfficeDao;
import cineplex.model.FilmOffice;
import cineplex.service.FilmOfficeManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wlw on 15-3-6.
 */
@Service
public class FilmOfficeManageServiceImpl implements FilmOfficeManageService {

    @Autowired
    private FilmOfficeDao filmOfficeDao;

    @Override
    public boolean addFilmOffice(FilmOffice filmOffice) {
        if(filmOfficeDao.find("filmOfficeName", filmOffice.getFilmOfficeName()).isEmpty()){
            filmOfficeDao.save(filmOffice);
            return true;
        }else{
            return false;
        }
    }
}
