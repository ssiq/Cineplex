package cineplex.dao;

import cineplex.model.ScreeningProgram;

import java.util.List;

/**
 * Created by wlw on 15-3-7.
 */
public interface ScreeningProgramDao {
    public void save(ScreeningProgram screeningProgram);
    public List find(String column, String value);
    public void update(ScreeningProgram screeningProgram);
    public List findJoinScreenProgram(ScreeningProgram screeningProgram);
    public ScreeningProgram findById(Integer screeningProgramId);
    public List findByUsername(String username);
    public List all();
    public List allOpen();
}
