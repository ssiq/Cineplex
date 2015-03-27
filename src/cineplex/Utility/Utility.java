package cineplex.Utility;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wlw on 15-3-11.
 */
public class Utility {
    private Utility(){}

    public static Date getNowDate()
    {
        Calendar calendar=Calendar.getInstance();
        int y=calendar.get(Calendar.YEAR);
        int m=calendar.get(Calendar.MONTH);
        int d=calendar.get(Calendar.DAY_OF_MONTH);
        calendar.set(0,0,00,0,0,0);
        calendar.set(y,m,d);
        return calendar.getTime();
    }

    public static Time getNowTime()
    {
        Calendar calendar=Calendar.getInstance();
        return new Time(calendar.get(Calendar.HOUR_OF_DAY)*3600*60+
                calendar.get(Calendar.MINUTE)*3600+
                calendar.get(Calendar.SECOND)*60+
                calendar.get(Calendar.MILLISECOND));
    }

    public static String formatDate(Date date)
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    public static Double generateDiscount(Double integer)
    {
        if(integer<200)
        {
            return 0.0;
        }else if(integer<400){
            return 0.8;
        }else if(integer<800){
            return 0.7;
        }else{
            return 0.6;
        }
    }

    public static Double generateMoney(Double price,Integer number,Double discount)
    {
        double r=price.doubleValue()*number.doubleValue();
        return r*discount;
    }

    public static String generateId(String username)
    {
        Date date=new Date();
        return date.toString()+username;
    }

    public static List generateFromArrayToList(Object a[])
    {
        List list=new LinkedList();
        for(int i=0;i<a.length;++i)
        {
            list.add(a[i]);
        }
        return list;
    }

    public static Integer generateCreditFromMoney(Double money)
    {
        Integer m=money.intValue();
        return m/10;
    }

    public static Date getNowMonth()
    {
        Calendar calendar=Calendar.getInstance();
        int month=calendar.get(Calendar.MONTH)-1;
        if(month<0)
        {
            month=11;
        }
        calendar.set(calendar.get(Calendar.YEAR), month,0);
        return calendar.getTime();
    }

    public static Date getMonth(String year,String month)
    {
        Calendar calendar=Calendar.getInstance();
        calendar.set(Integer.parseInt(year),Integer.parseInt(month),0);
        return calendar.getTime();
    }

    public static String generateAnalyseName(Date date)
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        return format.format(date);
    }

    public static Date monthBegin(Date date)
    {
        Calendar calendar=Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),0);
        return calendar.getTime();
    }

    public static Date monthEnd(Date date)
    {
        Calendar calendar=Calendar.getInstance();
        int month=calendar.get(Calendar.MONTH)+1;
        if(month>11)
        {
            month=0;
        }
        calendar.set(calendar.get(Calendar.YEAR),month,0);
        return calendar.getTime();
    }
}
