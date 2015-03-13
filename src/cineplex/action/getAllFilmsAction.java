package cineplex.action;

import cineplex.dao.BaseDao;
import cineplex.model.BankAccount;
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
public class getAllFilmsAction extends BaseAction{
    @Autowired
    ScreeningProgramManageService screeningProgramManageService;

    private class buyExtra implements ExtraList{
        @Override
        public List toList(Object o) {
            ScreeningProgram screeningProgram=(ScreeningProgram)o;
            StringBuilder sb=new StringBuilder();
            sb.append("<form action=\"toBuy\" method=\"post\" >");
            sb.append("<input type=\"hidden\" name=\"screeningProgramId\" value=\"");
            sb.append(screeningProgram.getScreeningProgramId());
            sb.append("\"/><input type=\"submit\" value=\"购买\"/></form>");
            List list=new LinkedList();
            list.add(sb.toString());
            return list;
        }
    }

    private String getAllFilms(ExtraList e)
    {
        String title_array[]=new String[]{"电影名称","日期","开始时间","结束时间","票价","放映地点",""};
        request.setAttribute("title", title_array);
        List list=screeningProgramManageService.getNowOpenScreeningProgram();
        List body_list=new LinkedList();
        for(int i=0;i<list.size();++i)
        {
            body_list.add(((ScreeningProgram)list.get(i)).toList(e));
        }
        request.setAttribute("table_body", body_list);
        return SUCCESS;
    }

    public String getAllFilmsToBuy()
    {
        return getAllFilms(new buyExtra());
    }

    private class sellExtra implements ExtraList{
        @Override
        public List toList(Object o) {
            ScreeningProgram screeningProgram=(ScreeningProgram)o;
            StringBuilder sb=new StringBuilder();
            sb.append("<form action=\"toSell\" method=\"post\" >");
            sb.append("<input type=\"hidden\" name=\"screeningProgramId\" value=\"");
            sb.append(screeningProgram.getScreeningProgramId());
            sb.append("\"/><input type=\"submit\" value=\"卖票\"/></form>");
            List list=new LinkedList();
            list.add(sb.toString());
            return list;
        }
    }

    public String getAllFilmsToSell()
    {
        return getAllFilms(new sellExtra());
    }

}
