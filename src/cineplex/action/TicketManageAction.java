package cineplex.action;

import cineplex.Utility.Utility;
import cineplex.exception.MyException;
import cineplex.model.MemberDetail;
import cineplex.model.ScreeningProgram;
import cineplex.model.User;
import cineplex.service.ScreeningProgramManageService;
import cineplex.service.TicketManageService;
import cineplex.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wlw on 15-3-11.
 */
@Repository
public class TicketManageAction extends BaseAction {

    @Autowired
    ScreeningProgramManageService screeningProgramManageService;

    @Autowired
    UserManageService userManageService;

    @Autowired
    TicketManageService ticketManageService;

    public String getAllFilms()
    {
        String title_array[]=new String[]{"电影名称","日期","开始时间","结束时间","票价","放映地点",""};
        request.setAttribute("title", title_array);
        List list=screeningProgramManageService.getNowOpenScreeningProgram();
        List body_list=new LinkedList();
        List e_list=new LinkedList();
        e_list.add("<input type=\"submit\" value=\"购买\" class=\"buy\"/>");
        for(int i=0;i<list.size();++i)
        {
            body_list.add(((ScreeningProgram)list.get(i)).toList(e_list));
        }
        request.setAttribute("table_body", body_list);
        return SUCCESS;
    }

    Integer screeningProgramId;
    Integer number;

    public Integer getScreeningProgramId() {
        return screeningProgramId;
    }

    public void setScreeningProgramId(Integer screeningProgramId) {
        this.screeningProgramId = screeningProgramId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String buyTicket()
    {
        User user=(User)session.get("user");
        try {
            String s=ticketManageService.buyTicket(screeningProgramId, user,number);
            request.setAttribute("mess", s);
        } catch (MyException e) {
            request.setAttribute("mess", e.getMessage());
        }
        return SUCCESS;
    }

    public String toBuyTicket()
    {
        ScreeningProgram screeningProgram=screeningProgramManageService.getScreeningProgramManageById(screeningProgramId);
        String title_list[]=new String[]{"电影名称","日期","开始时间","结束时间","票价","放映地点","张数"};
        String value_list[]=new String[]{
                screeningProgram.getFilmName(),
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
