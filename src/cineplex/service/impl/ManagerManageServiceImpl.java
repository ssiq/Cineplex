package cineplex.service.impl;

import cineplex.model.Manager;
import cineplex.service.ManagerManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wlw on 15-3-6.
 */
@Service
public class ManagerManageServiceImpl implements ManagerManageService{

    @Override
    public boolean loginManager(Manager manager) {
        return false;
    }
}
