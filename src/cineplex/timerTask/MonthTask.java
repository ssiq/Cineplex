package cineplex.timerTask;

import cineplex.Utility.Utility;
import cineplex.dao.TicketDao;
import cineplex.dao.UserDao;
import cineplex.model.MemberDetail;
import cineplex.model.Ticket;
import cineplex.service.TicketManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wlw on 15-3-15.
 */
@Component("MonthTask")
public class MonthTask {

    @Autowired
    private UserDao userDao;

    @Autowired
    private TicketDao ticketDao;

    private void addMap(Map<String,Integer> map,String key)
    {
        if(map.containsKey(key))
        {
            map.put(key, map.get(key)+1);
        }else{
            map.put(key, 0);
        }
    }

    private void initMap(Map<String,Integer> map,String s[])
    {
        for(int i=0;i<s.length;++i)
        {
            map.put(s[i], 0);
        }
    }

    private void writeResult(Map<String,Map<String,Integer>> analyseMap, Date now_month)
    {
        try {
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(
                    new FileOutputStream(Utility.generateAnalyseName(now_month)));
            objectOutputStream.writeObject(analyseMap);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(cron = "0 0 3 1 * ?")
    public void doTask()
    {
        Date now_month= Utility.getNowMonth();
        List list=userDao.allMember();
        Map<String,Map<String,Integer>> analyseMap=new HashMap<String, Map<String, Integer>>();

        Integer ageGroup[]=new Integer[]{18,29,59};

        Map<String,Integer> agemap=new HashMap<String, Integer>();
        String aNames[]=new String[]{"小于18岁","19到29岁","30到59岁","大于59岁"};
        initMap(agemap, aNames);
        analyseMap.put("年龄", agemap);

        Map<String,Integer> sexMap=new HashMap<String, Integer>();
        analyseMap.put("性别", sexMap);

        Map<String,Integer> placeMap=new HashMap<String, Integer>();
        analyseMap.put("住址", placeMap);

        Map<String,Integer> stateMap=new HashMap<String, Integer>();
        analyseMap.put("卡的状态", stateMap);

        for(int i=0;i<list.size();++i)
        {
            MemberDetail memberDetail=(MemberDetail)list.get(i);
            int age=Integer.parseInt(memberDetail.getAge());
            boolean isLess50=false;
            for(int j=0;j<ageGroup.length;++j)
            {
                if(age<=ageGroup[j])
                {
                    isLess50=true;
                    addMap(agemap, String.valueOf(j));
                }
            }
            if(!isLess50)
            {
                addMap(agemap, String.valueOf(ageGroup.length));
            }

            addMap(sexMap, memberDetail.getSex());
            addMap(placeMap, memberDetail.getPlace());
            addMap(stateMap, memberDetail.getState());
        }

        List consumeList=ticketDao.allComsume();
        Integer consumeGroup[]=new Integer[]{200,500,1000};
        String cNames[]=new String[]{"小于200元","200到500元","500到1000元","超过1000元"};
        Map<String,Integer> consumeMap=new HashMap<String, Integer>();
        initMap(consumeMap, cNames);
        for(int i=0;i<consumeList.size();++i)
        {
            Integer integer=(Integer)consumeList.get(i);
            boolean isGrater1000=true;
            for(int j=0;j<consumeGroup.length;++j)
            {
                if(integer<consumeGroup[j])
                {
                    isGrater1000=false;
                    addMap(consumeMap, String.valueOf(j));
                }
            }
            if(isGrater1000)
            {
                addMap(consumeMap, String.valueOf(consumeGroup.length));
            }
        }
        analyseMap.put("消费", consumeMap);

        writeResult(analyseMap, now_month);
    }
}
