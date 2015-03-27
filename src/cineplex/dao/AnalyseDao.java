package cineplex.dao;

import cineplex.model.Analyse;

import java.util.Date;
import java.util.List;

/**
 * Created by wlw on 15-3-15.
 */
public interface AnalyseDao {
    public void save(Analyse analyse);
    public List all();
    public Analyse getAnalyseById(Date date);
}
