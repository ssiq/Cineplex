package cineplex.service.impl;

import cineplex.Utility.Utility;
import cineplex.dao.UserDao;
import cineplex.exception.MyException;
import cineplex.model.MemberDetail;
import cineplex.model.ScreeningProgram;
import cineplex.model.User;
import cineplex.service.ScreeningProgramManageService;
import cineplex.service.TicketManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wlw on 15-3-12.
 */
@Service
public class TicketManageServiceImpl implements TicketManageService{

    @Autowired
    UserDao userDao;

    @Autowired
    ScreeningProgramManageService screeningProgramManageService;

    @Override
    public String buyTicket(Integer screeningProgramId, User user, Integer number) throws MyException {
        MemberDetail memberDetail=userDao.getDetail(user);
        Double discount= Utility.generateDiscount(memberDetail.getMoney());
        ScreeningProgram screeningProgram=screeningProgramManageService.getScreeningProgramManageById(screeningProgramId);
        Double price=Utility.generateMoney(screeningProgram.getPrice(), number, discount);
        Integer leftnumber=screeningProgram.getLeft_number();
        if(price<=memberDetail.getMoney()&&leftnumber>=number) {
            memberDetail.setMoney(memberDetail.getMoney() - price);
            userDao.updateMemberDetail(memberDetail);
            StringBuilder message=new StringBuilder("购票成功座位号是:"+leftnumber);
            for(int i=1;i<number;++i)
            {
                message.append(","+(leftnumber-i));
            }
            screeningProgram.setLeft_number(leftnumber-number);
            screeningProgramManageService.changeScreeningProgram(screeningProgram);
            return message.toString();
        }else if (leftnumber<number){
            throw new MyException("票不足，只有"+leftnumber+"张");
        }else{
            throw new MyException("你的账户余额不足，请先充值，还差"+(memberDetail.getMoney()-price)+"元");
        }
    }
}
