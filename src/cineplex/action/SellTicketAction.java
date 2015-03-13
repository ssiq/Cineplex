package cineplex.action;

import cineplex.exception.MyException;
import cineplex.model.User;
import cineplex.service.ScreeningProgramManageService;
import cineplex.service.TicketManageService;
import cineplex.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by wlw on 15-3-13.
 */
@Repository
public class SellTicketAction extends BaseAction {

    @Autowired
    private ScreeningProgramManageService screeningProgramManageService;

    @Autowired
    private UserManageService userManageService;

    @Autowired
    private TicketManageService ticketManageService;

    private Integer screeningProgramId;
    private Integer number;

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

    private Integer type;
    private static final Integer HUIYUAN=0;
    private static final Integer FEIHUIYUAN=1;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    private String cardNumber;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String doSell()
    {
        try {
            String message="no path";
            if(type==HUIYUAN)
            {
                message=ticketManageService.buyTicket(screeningProgramId, cardNumber, number);
            }else if(type==FEIHUIYUAN){
                message=ticketManageService.buyTicketNoMember(screeningProgramId, number);
            }
            request.setAttribute("mess", message);
        } catch (MyException e) {
            e.printStackTrace();
            request.setAttribute("mess", e.getMessage());
        }
        return SUCCESS;
    }
}
