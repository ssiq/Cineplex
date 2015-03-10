package cineplex.tags;

import cineplex.model.ScreeningProgram;

import java.util.List;

/**
 * Created by wlw on 15-3-7.
 */
public class BaseDisplay {

    public static String wrapWithTr(String s)
    {
        return "<tr>"+s+"</tr>";
    }

    public static String wrapWithTd(String s)
    {
        return "<td>"+s+"</td>";
    }

    public static String wrapWithTh(String s)
    {
        return "<th>"+s+"</th>";
    }

    public static String displayScreeningProgramTitle(){
        return wrapWithTr(
                wrapWithTh("影厅")+wrapWithTh("电影名称")+
                        wrapWithTh("服务员")+wrapWithTh("放映日期")+
                        wrapWithTh("开始时间")+wrapWithTh("结束时间")+
                        wrapWithTh("价格")+wrapWithTh("")
        );
    }

    public static String displayScreeningProgram(ScreeningProgram screeningProgram, String extra)
    {
        return wrapWithTr(
                wrapWithTd("<input type=\"hidden\" class=\"spid\" value=\""+
                                screeningProgram.getScreeningProgramId()+"\"/>"+
                        screeningProgram.getFilmOffice().getFilmOfficeName())+
                        wrapWithTd(screeningProgram.getFilmName())+
                        wrapWithTd(screeningProgram.getUser().getUsername())+
                        wrapWithTd(screeningProgram.getDate().toString())+
                        wrapWithTd(screeningProgram.getBeginTime().toString())+
                        wrapWithTd(screeningProgram.getEndTime().toString())+
                        wrapWithTd(screeningProgram.getPrice().toString())+
                        wrapWithTd(extra)
        );
    }

    static class DefaultExtraStr implements GetExtra{

        private String s;

        DefaultExtraStr(String s)
        {
            this.s=s;
        }

        @Override
        public String getExtra(Object o) {
            return s;
        }
    }

    public static String displayScreeningProgramTable(List list,String emptyStr,GetExtra getExtra)
    {
        StringBuilder sb=new StringBuilder();
        if(list!=null)
        {
            sb.append("<table>");
            sb.append(BaseDisplay.displayScreeningProgramTitle());
            for(int i=0;i<list.size();++i)
            {
                sb.append(displayScreeningProgram((ScreeningProgram)list.get(i), getExtra.getExtra(list.get(i))));
            }
            sb.append("</table>");
        }else{
            sb.append(emptyStr);
        }
        return sb.toString();
    }

    public static String displayUncheckedScreeningProgram(List list){
        if(list==null)
        {
            return "没有需要审核的计划";
        }
        String extraStr="<input type=\"button\" class=\"accept\" value=\"同意\"/>" +
                "<input type=\"button\" class=\"refuse\" value=\"拒绝\"/>";
        return displayScreeningProgramTable(list, "没有需要审核的计划", new DefaultExtraStr(extraStr));
    }

    public static class StateExtraStr implements GetExtra
    {
        @Override
        public String getExtra(Object o) {
            ScreeningProgram screeningProgram=(ScreeningProgram)o;
            if(screeningProgram.getState().equals(ScreeningProgram.REFUSE))
            {
                String s="<form action=\"changeMyScreeningProgram\" method=\"post\">" +
                        screeningProgram.getState() +
                        "<input type=\"hidden\" name=\"screeningProgram.screeningProgramId\" value=\"" +
                        screeningProgram.getScreeningProgramId() +
                        "\"/>" +
                        "<input type=\"submit\" class=\"change\" value=\"修改\"/>" +
                        "</form>";
                return s;
            }else{
                return screeningProgram.getState();
            }
        }
    }

    public static String displayAllMyScreeningProgram(List list)
    {
        if(list==null)
        {
            return "你没有提交过计划";
        }
        return displayScreeningProgramTable(list, "你没有提交过计划", new StateExtraStr());
    }
}
