package cineplex.action;

import cineplex.Utility.Utility;
import cineplex.model.MemberDetail;
import cineplex.model.RechargeRecord;
import cineplex.model.Ticket;
import cineplex.model.User;
import cineplex.service.TicketManageService;
import cineplex.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wlw on 15-3-14.
 */
@Repository
public class SeeOneMemberDetailAction extends BaseAction{

    @Autowired
    private UserManageService userManageService;

    @Autowired
    private TicketManageService ticketManageService;

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String doGetDetail(User user)
    {
        MemberDetail memberDetail=userManageService.getDetail(user);
        List detail=new LinkedList();
        detail.add(Utility.generateFromArrayToList(new String[]{"用户名", memberDetail.getUsername().getUsername()}));
        detail.add(Utility.generateFromArrayToList(new String[]{"年龄", memberDetail.getAge()}));
        detail.add(Utility.generateFromArrayToList(new String[]{"卡号", memberDetail.getCardnumber()}));
        detail.add(Utility.generateFromArrayToList(new String[]{"住址", memberDetail.getPlace()}));
        detail.add(Utility.generateFromArrayToList(new String[]{"性别", memberDetail.getSex()}));
        detail.add(Utility.generateFromArrayToList(new String[]{"余额", memberDetail.getMoney().toString()}));
        detail.add(Utility.generateFromArrayToList(new String[]{"当前状态", memberDetail.getState()}));
        request.setAttribute("detail", detail);

        String rechargeTitle[]=new String[]{"缴费日期","缴费金额"};
        request.setAttribute("rechargeTitle", rechargeTitle);

        List rechargeList=userManageService.getRechargeHistory(user);
        List rechargeBody=new LinkedList();
        for(int i=0;i<rechargeList.size();++i)
        {
            List in_list=new LinkedList();
            RechargeRecord rechargeRecord=(RechargeRecord)rechargeList.get(i);
            in_list.add(Utility.formatDate(rechargeRecord.getDate()));
            in_list.add(rechargeRecord.getMoney());
            rechargeBody.add(in_list);
        }
        request.setAttribute("rechargeBody", rechargeBody);

        String buyTitle[]=new String[]{"座位号","电影名称","影厅名称"};
        request.setAttribute("buyTitle", buyTitle);

        List ticketList=ticketManageService.getOnesTicket(user);
        List buyBody=new LinkedList();
        for(int i=0;i<ticketList.size();++i)
        {
            List in_list=new LinkedList();
            Ticket ticket=(Ticket)ticketList.get(i);
            in_list.add(ticket.getSeatNumber());
            in_list.add(ticket.getScreeningProgram().getFilmName());
            in_list.add(ticket.getScreeningProgram().getFilmOffice().getFilmOfficeName());
            buyBody.add(in_list);
        }
        request.setAttribute("buyBody", buyBody);

        return SUCCESS;
    }

    public String execute()
    {
        User user=userManageService.getUserByUsername(username);
        return doGetDetail(user);
    }
}
