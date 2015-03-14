package cineplex.action;

import cineplex.service.ScreeningProgramManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wlw on 15-3-13.
 */
@Repository
public class CreateActivityAction extends BaseAction {
    @Autowired
    ScreeningProgramManageService screeningProgramManageService;

    private List filmList;

    public List getFilmList() {
        return filmList;
    }

    public void setFilmList(List filmList) {
        this.filmList = filmList;
    }

    public String getActivityView()
    {
        filmList=screeningProgramManageService.getAllFilmName();
        return SUCCESS;
    }
}
