package cineplex.tags;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by wlw on 15-3-27.
 */
public class DisplayMapInTable extends TagSupport {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int doEndTag() throws JspException {
        ServletRequest req = pageContext.getRequest();

        Map map=(Map)req.getAttribute(name);
        Iterator iterator=map.keySet().iterator();
        StringBuilder sb=new StringBuilder();
        sb.append("<table>");
        while (iterator.hasNext())
        {
            StringBuilder insb=new StringBuilder();
            String name=(String)iterator.next();
            String val=map.get(name).toString();
            insb.append(BaseDisplay.wrapWithTh(name));
            insb.append(BaseDisplay.wrapWithTd(val));
            sb.append(BaseDisplay.wrapWithTr(insb.toString()));
        }
        sb.append("</table>");

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
