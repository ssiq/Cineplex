package cineplex.dao;

import cineplex.model.Ticket;

import java.util.List;

/**
 * Created by wlw on 15-3-12.
 */
public interface TicketDao {
    public void save(Ticket ticket);
    public List find(String name, Object value);
    public List allComsume();
}
