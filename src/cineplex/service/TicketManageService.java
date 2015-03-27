package cineplex.service;

import cineplex.exception.MyException;
import cineplex.model.User;

import java.util.Date;
import java.util.List;

/**
 * Created by wlw on 15-3-12.
 */
public interface TicketManageService {
    public String buyTicket(Integer screeningProgramId, User user, Integer number) throws MyException;
    public String buyTicket(Integer screeningProgramId, String cardNumber, Integer number) throws MyException;
    public String buyTicketNoMember(Integer screeningProgramId, Integer number) throws MyException;
    public List getOnesTicket(User user);
    public List getOneMonthNumberPerday(Date month);
}
