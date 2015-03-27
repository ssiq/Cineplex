package cineplex.action;

import cineplex.Utility.Utility;
import cineplex.dao.TicketDao;
import cineplex.dao.UserDao;
import cineplex.model.MemberDetail;
import cineplex.model.NumberCountPerDay;
import cineplex.service.TicketManageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

/**
 * Created by wlw on 15-3-27.
 */
public class DoAnalyseAction extends BaseAction {

    @Autowired
    TicketManageService ticketManageService;

    private String month;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String execute()
    {
        System.out.println("month:"+month);
        String t[]=month.split("-");
        Date now_month=Utility.getMonth(t[0],t[1]);
        String fileName=Utility.generateAnalyseName(now_month);
        File file=new File(fileName);
        if(!file.exists())
        {
            return "no_analyse";
        }else{
            try {
                ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(file));
                Map map=(Map)objectInputStream.readObject();
                objectInputStream.close();
                request.setAttribute("analyse_result", map);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            List list=ticketManageService.getOneMonthNumberPerday(now_month);
            List day_count_list=new LinkedList();
            int month_sum=0;
            for(int i=0;i<list.size();++i)
            {
                NumberCountPerDay numberCountPerDay=(NumberCountPerDay)list.get(i);

                List in_list=new LinkedList();

                in_list.add(Utility.formatDate(numberCountPerDay.getDate()));
                in_list.add(numberCountPerDay.getNumber());

                month_sum+=numberCountPerDay.getNumber();

                day_count_list.add(in_list);
            }
            request.setAttribute("countDay", day_count_list);
            request.setAttribute("countMonth", month_sum);

            return SUCCESS;
        }
    }
}
