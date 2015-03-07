package cineplex.tags;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.List;

/**
 * Created by wlw on 15-3-7.
 */
public class DisplaySelectTag extends TagSupport {
    public int doEndTag() throws JspException {
        ServletRequest req = pageContext.getRequest();
        List list=(List)req.getAttribute("list");
        String str=(String)req.getAttribute("selected");
        if(list!=null)
        {
            JspWriter writer=pageContext.getOut();
            try{
                for(int i=0;i<list.size();++i)
                {
                    if(list.get(i).equals(str)){
                        writer.println("<option selected=\"selected\" value=\"" + list.get(i) + "\">");
                    }else{
                        writer.println("<option value=\"" + list.get(i) + "\">");
                    }
                    writer.println(list.get(i));
                    writer.println("</option>");
                }
            }catch (Exception e){
                e.printStackTrace();
                throw new JspException(e.getMessage());
            }
        }
        return EVAL_PAGE;
    }
}
