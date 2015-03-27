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
public class DisplayMapsInTable extends TagSupport {

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
        while (iterator.hasNext())
        {
            String key=(String)iterator.next();
            sb.append("<div>");
            sb.append("<p>"+key+"</p>");
            sb.append(BaseDisplay.generateMapInTable((Map)map.get(key)));
            sb.append("</div>");
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
