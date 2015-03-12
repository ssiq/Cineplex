package cineplex.tags;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.List;

/**
 * Created by wlw on 15-3-11.
 */
public class DisplayTableBody extends TagSupport {
    private String bodyName;

    public String getBodyName() {
        return bodyName;
    }

    public void setBodyName(String bodyName) {
        this.bodyName = bodyName;
    }

    public int doEndTag() throws JspException {
        ServletRequest req = pageContext.getRequest();
        StringBuilder sb = new StringBuilder();
        List list=(List)req.getAttribute(bodyName);
        for(int i=0;i<list.size();++i)
        {
            StringBuilder in_sb=new StringBuilder();
            List l=(List)list.get(i);
            for(int j=0;j<l.size();++j)
            {
                in_sb.append(BaseDisplay.wrapWithTd(l.get(j).toString()));
            }
            sb.append(BaseDisplay.wrapWithTr(in_sb.toString()));
        }
        JspWriter writer=pageContext.getOut();
        try {
            writer.print(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
            throw new JspException(e.getMessage());
        }
        return EVAL_PAGE;
    }
}
