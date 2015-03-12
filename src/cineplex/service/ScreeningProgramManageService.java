package cineplex.service;

import cineplex.exception.MyException;
import cineplex.model.ScreeningProgram;
import cineplex.model.User;

import java.util.List;

/**
 * Created by wlw on 15-3-7.
 */
public interface ScreeningProgramManageService {
    public boolean addScreeningProgram(ScreeningProgram screeningProgram);
    public void changeScreeningProgram(ScreeningProgram screeningProgram) throws MyException;
    public void acceptScreeningProgram(Integer screeningProgramId) throws MyException;
    public void refuseScreeningProgram(Integer screeningProgramId) throws MyException;
    public List getAllUnchecked();
    public List getMyScreeningProgramManage(User user);
    public ScreeningProgram getScreeningProgramManageById(Integer screeningProgramId);
    public List getNowOpenScreeningProgram();
}
