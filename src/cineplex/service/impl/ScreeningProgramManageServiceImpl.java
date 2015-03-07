package cineplex.service.impl;

import cineplex.dao.ScreeningProgramDao;
import cineplex.model.ScreeningProgram;
import cineplex.service.ScreeningProgramManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public void acceptScreeningProgram(Integer screeningProgramId) {
        ScreeningProgram screeningProgram=screeningProgramDao.findById(screeningProgramId);
        if(screeningProgram!=null)
        {
            screeningProgram.setState(ScreeningProgram.ACCEPT);
            screeningProgramDao.update(screeningProgram);
        }
    }

    @Override
    public void refuseScreeningProgram(Integer screeningProgramId) {
        ScreeningProgram screeningProgram=screeningProgramDao.findById(screeningProgramId);
        if(screeningProgram!=null)
        {
            screeningProgram.setState(ScreeningProgram.REFUSE);
            screeningProgramDao.update(screeningProgram);
        }
    }
}
