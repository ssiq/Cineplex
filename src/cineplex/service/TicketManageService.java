package cineplex.service;

import cineplex.exception.MyException;
import cineplex.model.User;

/**
 * Created by wlw on 15-3-12.
 */
public interface TicketManageService {
    public String buyTicket(Integer screeningProgramId, User user, Integer number) throws MyException;
}
