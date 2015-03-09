package cineplex.service.impl;

import cineplex.dao.ScreeningProgramDao;
import cineplex.exception.MyException;
import cineplex.model.ScreeningProgram;
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
        if(screeningProgramDao.findJoinScreenProgram(screeningProgram).isEmpty())
        {
            screeningProgramDao.save(screeningProgram);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void changeScreeningProgram(ScreeningProgram screeningProgram) {
        if(screeningProgramDao.findById(screeningProgram.getScreeningProgramId())!=null)
        {
            screeningProgramDao.update(screeningProgram);
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
}
