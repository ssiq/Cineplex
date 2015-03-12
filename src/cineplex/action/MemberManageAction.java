package cineplex.action;

import cineplex.Utility.Utility;
import cineplex.exception.MyException;
import cineplex.model.MemberDetail;
import cineplex.model.User;
import cineplex.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by wlw on 15-3-10.
 */
@Repository
public class MemberManageAction extends BaseAction{
    @Autowired
    UserManageService userManageService;

    private static final String lock="lock";

    User user;
    MemberDetail memberDetail;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MemberDetail getMemberDetail() {
        return memberDetail;
    }

    public void setMemberDetail(MemberDetail memberDetail) {
        this.memberDetail = memberDetail;
    }

    public String generateCardNumber(){
        int cardnumber = 0;
        synchronized (lock){
            try {
                String path=MemberManageAction.class.getResource("").getPath().replaceAll("%20", " ");
                String fileName=path+"/cardnumber";
                Scanner scanner=new Scanner(new File(fileName));
                cardnumber=Integer.parseInt(scanner.next());
                scanner.close();
                System.out.println("read file");
                PrintWriter printWriter=new PrintWriter(fileName);
                printWriter.print(cardnumber+1);
                printWriter.flush();
                printWriter.close();
                System.out.println("write file");
            } catch (FileNotFoundException e) {
                System.out.println("no that file");
                e.printStackTrace();
            }
        }
        return String.format("%07d", cardnumber);
    }

    @Override
    public String execute() {
        if(memberDetail.getMoney()<200)
        {
            request.setAttribute("mess", "首次充值至少需要２００元");
            return INPUT;
        }
        try {
            user.setIdentity("0");
            String cardnumber=generateCardNumber();
            memberDetail.setCardnumber(cardnumber);
            memberDetail.setUsername(user);
            memberDetail.setDate(Utility.getNowDate());
            memberDetail.setState(MemberDetail.ACTIVE);
            userManageService.addMember(user, memberDetail);
            request.setAttribute("mess", "你的卡号是"+cardnumber);
            return SUCCESS;
        } catch (MyException e) {
            request.setAttribute("mess", e.getMessage());
            return INPUT;
        }
    }
}
