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
public class BuyTicketAction extends BaseAction {

    @Autowired
    ScreeningProgramManageService screeningProgramManageService;

    @Autowired
    UserManageService userManageService;

    @Autowired
    TicketManageService ticketManageService;

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
}
