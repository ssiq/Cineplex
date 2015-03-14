package cineplex.action;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wlw on 15-3-14.
 */
@Repository
public class DoAnswerActivityAction extends BaseAction {

    private List<String> answerList=new ArrayList<String>();

    public List<String> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<String> answerList) {
        this.answerList = answerList;
    }

    public String execute(){
        return SUCCESS;
    }
}
