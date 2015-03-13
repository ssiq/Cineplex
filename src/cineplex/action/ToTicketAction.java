package cineplex.action;

import cineplex.Utility.Utility;
import cineplex.model.ScreeningProgram;
import cineplex.service.ScreeningProgramManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wlw on 15-3-13.
 */
@Repository
public class ToTicketAction extends BaseAction {
    @Autowired
    ScreeningProgramManageService screeningProgramManageService;

    Integer screeningProgramId;

    public Integer getScreeningProgramId() {
        return screeningProgramId;
    }

    public void setScreeningProgramId(Integer screeningProgramId) {
        this.screeningProgramId = screeningProgramId;
    }

    public String toTicket()
    {
        ScreeningProgram screeningProgram=screeningProgramManageService.getScreeningProgramManageById(screeningProgramId);
        String title_list[]=new String[]{"电影名称","日期","开始时间","结束时间","票价","放映地点","张数"};
        String value_list[]=new String[]{
                screeningProgram.getFilmName()+
                        "<input type=\"hidden\" name=\"screeningProgramId\" value=\""+
                        screeningProgram.getScreeningProgramId()+"\"/>",
                Utility.formatDate(screeningProgram.getDate()),
                screeningProgram.getBeginTime().toString(),
                screeningProgram.getEndTime().toString(),
                screeningProgram.getPrice().toString(),
                screeningProgram.getFilmOffice().getFilmOfficeName(),
                "<input type=\"text\" name=\"number\"/>"
        };
        List list=new LinkedList();
        for(int i=0;i<title_list.length;++i)
        {
            List l=new LinkedList();
            l.add(title_list[i]);
            l.add(value_list[i]);
            list.add(l);
        }
        request.setAttribute("table", list);
        return SUCCESS;
    }
}
