package cineplex.action;

import cineplex.service.FilmOfficeManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by wlw on 15-3-7.
 */
@Repository
public class AllFilmOfficeAction extends BaseAction{
    @Autowired
    private FilmOfficeManageService filmOfficeManageService;

    public String execute(){
        System.out.println("addScreenProgram");
        request.setAttribute("list", filmOfficeManageService.getAllFilmOfficeName());
        request.setAttribute("selected", "");
        return SUCCESS;
    }
}
