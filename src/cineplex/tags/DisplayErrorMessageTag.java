package cineplex.tags;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Created by wlw on 15-3-6.
 */
public class DisplayErrorMessageTag extends TagSupport {
    public int doEndTag() throws JspException {
        ServletRequest req = pageContext.getRequest();
        String message=(String)req.getAttribute("mess");
        if(message!=null){
            JspWriter writer=pageContext.getOut();
            try{
                writer.print(message);
            }catch (Exception e){
                e.printStackTrace();
                throw new JspException(e.getMessage());
            }
        }
        return EVAL_PAGE;
    }
}
