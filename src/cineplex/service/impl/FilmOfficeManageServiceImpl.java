package cineplex.service.impl;

import cineplex.dao.FilmOfficeDao;
import cineplex.model.FilmOffice;
import cineplex.service.FilmOfficeManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<String> getAllFilmOfficeName() {
        List list=filmOfficeDao.all();
        System.out.println("film list:"+list);
        List<String> fnameList=new ArrayList<String>();
        for(int i=0;i<list.size();++i)
        {
            FilmOffice fo=(FilmOffice)list.get(i);
            fnameList.add(fo.getFilmOfficeName());
        }
        return fnameList;
    }

    @Override
    public FilmOffice getById(String filmOfficeName) {
        List list=filmOfficeDao.find("filmOfficeName", filmOfficeName);
        if(list.isEmpty())
        {
            return null;
        }else{
            return (FilmOffice)list.get(0);
        }
    }
}
