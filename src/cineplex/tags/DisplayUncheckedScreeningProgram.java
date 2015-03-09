package cineplex.tags;

import cineplex.action.BaseAction;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.List;

/**
 * Created by wlw on 15-3-7.
 */
public class DisplayUncheckedScreeningProgram extends TagSupport {
    public int doEndTag() throws JspException {
        ServletRequest req = pageContext.getRequest();
        List list=(List)req.getAttribute("UncheckedList");
        JspWriter writer=pageContext.getOut();
        try{
            String s=BaseDisplay.displayUncheckedScreeningProgram(list);
            writer.print(s);
        }catch (Exception e){
            e.printStackTrace();
            throw new JspException(e.getMessage());
        }
        return EVAL_PAGE;
    }
}
