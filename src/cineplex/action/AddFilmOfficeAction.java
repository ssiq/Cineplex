package cineplex.action;

import cineplex.model.FilmOffice;
import cineplex.service.FilmOfficeManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by wlw on 15-3-6.
 */
@Repository
public class AddFilmOfficeAction extends BaseAction {

    @Autowired
    private FilmOfficeManageService filmOfficeManageService;

    private FilmOffice filmOffice;

    public String execute(){
        request.setAttribute("mess", "");
        if(filmOffice==null)
        {
            filmOffice=new FilmOffice();
            filmOffice.setFilmOfficeName("");
            filmOffice.setSize("");
            System.out.println("its first in addFilmOffice");
            return INPUT;
        }else{
            System.out.println("its next in addFilmOffice");
            System.out.println("name:" + filmOffice.getFilmOfficeName());
            System.out.println("size:"+filmOffice.getSize());
            String size=filmOffice.getSize();
            String message="";
            try{
                Integer.parseInt(size.trim());
                filmOffice.setSize(size.trim());
            }catch (NumberFormatException e){
                e.printStackTrace();
                message="影厅大小应该为整数";
                request.setAttribute("mess", message);
                return INPUT;
            }

            if(filmOfficeManageService.addFilmOffice(filmOffice)){
                request.setAttribute("mess", "添加影厅成功");
                return SUCCESS;
            }else{
                message="该影厅已存在";
                request.setAttribute("mess", message);
                return INPUT;
            }
        }
    }

    public FilmOffice getFilmOffice() {
        return filmOffice;
    }

    public void setFilmOffice(FilmOffice filmOffice) {
        this.filmOffice = filmOffice;
    }
}
