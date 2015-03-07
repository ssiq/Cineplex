package cineplex.action;

import cineplex.model.FilmOffice;
import cineplex.model.ScreeningProgram;
import cineplex.model.User;
import cineplex.service.FilmOfficeManageService;
import cineplex.service.ScreeningProgramManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wlw on 15-3-7.
 */
@Repository
public class AddScreenProgramAction extends BaseAction{

    @Autowired
    private ScreeningProgramManageService screeningProgramManageService;

    @Autowired
    private FilmOfficeManageService filmOfficeManageService;

    private ScreeningProgram screeningProgram;
    private String filmOfficeName;

    public ScreeningProgram getScreeningProgram() {
        return screeningProgram;
    }

    public void setScreeningProgram(ScreeningProgram screeningProgram) {
        this.screeningProgram = screeningProgram;
    }

    public String getFilmOfficeName() {
        return filmOfficeName;
    }

    public void setFilmOfficeName(String filmOfficeName) {
        this.filmOfficeName = filmOfficeName;
    }

    public String execute(){
        System.out.println("addScreenProgram");
        request.setAttribute("list", filmOfficeManageService.getAllFilmOfficeName());
        request.setAttribute("selected", (filmOfficeName==null)?"":filmOfficeName);
        if(screeningProgram==null)
        {
            screeningProgram=new ScreeningProgram();
            return INPUT;
        }
        FilmOffice filmOffice=new FilmOffice();
        filmOffice.setFilmOfficeName(filmOfficeName);
        screeningProgram.setFilmOffice(filmOffice);
        if((User)session.get("user")==null)
        {
            System.out.print("error no user");
        }
        screeningProgram.setUser((User)session.get("user"));
        screeningProgram.setState(ScreeningProgram.WAIT);
        if(screeningProgramManageService.addScreeningProgram(screeningProgram))
        {
            request.setAttribute("mess", "你的计划已提交，请等待经理审核");
            return SUCCESS;
        }else{
            request.setAttribute("mess", "你所提交的计划与已存在的计划冲突");
            return INPUT;
        }
    }
}
