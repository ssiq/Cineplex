package cineplex.service;

import cineplex.model.ScreeningProgram;

/**
 * Created by wlw on 15-3-7.
 */
public interface ScreeningProgramManageService {
    public boolean addScreeningProgram(ScreeningProgram screeningProgram);
    public void changeScreeningProgram(ScreeningProgram screeningProgram);
    public void acceptScreeningProgram(Integer screeningProgramId);
    public void refuseScreeningProgram(Integer screeningProgramId);
}
