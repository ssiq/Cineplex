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
public class DisplayTitle extends TagSupport {
    private String titleName;

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public int doEndTag() throws JspException {
        ServletRequest req = pageContext.getRequest();
        String list[]=(String[])req.getAttribute(titleName);
        StringBuilder sb=new StringBuilder();
        if(list!=null)
        {
            for(int i=0;i<list.length;++i)
            {
                sb.append(BaseDisplay.wrapWithTh(list[i]));
            }
            JspWriter writer=pageContext.getOut();
            try {
                writer.println(sb.toString());
            } catch (IOException e) {
                e.printStackTrace();
                throw new JspException(e.getMessage());
            }
        }

        return EVAL_PAGE;
    }
}
