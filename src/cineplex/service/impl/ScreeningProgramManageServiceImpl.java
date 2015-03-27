package cineplex.service.impl;

import cineplex.dao.ScreeningProgramDao;
import cineplex.exception.MyException;
import cineplex.model.ScreeningProgram;
import cineplex.model.User;
import cineplex.service.ScreeningProgramManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wlw on 15-3-7.
 */
@Service
public class ScreeningProgramManageServiceImpl implements ScreeningProgramManageService {

    @Autowired
    ScreeningProgramDao screeningProgramDao;

    @Override
    public boolean addScreeningProgram(ScreeningProgram screeningProgram) {
        screeningProgram.setCard_buy_user(0);
        if(screeningProgramDao.findJoinScreenProgram(screeningProgram).isEmpty())
        {
            screeningProgramDao.save(screeningProgram);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void changeScreeningProgram(ScreeningProgram screeningProgram) throws MyException {
        if(screeningProgramDao.findById(screeningProgram.getScreeningProgramId())!=null)
        {
            System.out.println("to change sp:"+screeningProgram);
            List list=screeningProgramDao.findJoinScreenProgram(screeningProgram);
            if(!list.isEmpty())
            {

                if(list.size()>1||
                        ((ScreeningProgram)list.get(0)).getScreeningProgramId()!=screeningProgram.getScreeningProgramId())
                {
                    System.out.println("joined");
                    throw new MyException("与现有计划冲突");
                }
            }
            screeningProgramDao.update(screeningProgram);
        }else{
            throw new MyException("该计划不存在");
        }
    }

    private void checkScreeningProgram(Integer screeningProgramId,String action) throws MyException {
        ScreeningProgram screeningProgram=screeningProgramDao.findById(screeningProgramId);
        if(screeningProgram!=null)
        {
            if(screeningProgram.getState().equals(ScreeningProgram.WAIT)){
                screeningProgram.setState(action);
                screeningProgramDao.update(screeningProgram);
            }else{
                throw new MyException("你已审核该放映计划");
            }
        }else{
            throw new MyException("你已审核该放映计划");
        }
    }

    @Override
    public void acceptScreeningProgram(Integer screeningProgramId) throws MyException {
        checkScreeningProgram(screeningProgramId, ScreeningProgram.ACCEPT);
    }

    @Override
    public void refuseScreeningProgram(Integer screeningProgramId) throws MyException {
        checkScreeningProgram(screeningProgramId, ScreeningProgram.REFUSE);
    }

    @Override
    public List getAllUnchecked() {
        return screeningProgramDao.find("state", ScreeningProgram.WAIT);
    }

    @Override
    public List getMyScreeningProgramManage(User user) {
        List list=screeningProgramDao.findByUsername(user.getUsername());
        return list;
    }

    @Override
    public ScreeningProgram getScreeningProgramManageById(Integer screeningProgramId) {
        ScreeningProgram screeningProgram=screeningProgramDao.findById(screeningProgramId);
        if(screeningProgram!=null)
        {
            return screeningProgram;
        }else{
            return null;
        }
    }

    @Override
    public List getNowOpenScreeningProgram() {
        return screeningProgramDao.allOpen();
    }

    @Override
    public List getAll() {
        return screeningProgramDao.all();
    }

    @Override
    public List getAllFilmName() {
        return screeningProgramDao.allFilmName();
    }
}
