package cineplex.action;

import cineplex.exception.MyException;
import cineplex.service.ScreeningProgramManageService;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wlw on 15-3-7.
 */
@Repository
public class CheckScreeningProgramAction extends BaseAction {
    @Autowired
    ScreeningProgramManageService screeningProgramManageService;

    public String execute(){
        List list= screeningProgramManageService.getAllUnchecked();
        request.setAttribute("UncheckedList", list);
        return SUCCESS;
    }

    Integer screeningProgramId;
    String message;
    String result;

    @JSON(serialize=false)
    public Integer getScreeningProgramId() {
        return screeningProgramId;
    }

    public void setScreeningProgramId(Integer screeningProgramId) {
        this.screeningProgramId = screeningProgramId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String accept()
    {
        try {
            screeningProgramManageService.acceptScreeningProgram(screeningProgramId);
            message="已同意";
            result="success";
        } catch (MyException e) {
            result="fail";
            message=e.getMessage();
        }
        return SUCCESS;
    }

    public String refuse()
    {
        try {
            screeningProgramManageService.refuseScreeningProgram(screeningProgramId);
            message="已拒绝";
        } catch (MyException e) {
            result="fail";
            message=e.getMessage();
        }
        return SUCCESS;
    }
}
