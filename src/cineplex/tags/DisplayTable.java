package cineplex.tags;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.List;

/**
 * Created by wlw on 15-3-12.
 */
public class DisplayTable extends TagSupport {

    private String tableName;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int doEndTag() throws JspException {
        ServletRequest req = pageContext.getRequest();
        StringBuilder sb = new StringBuilder();
        List list=(List)req.getAttribute(tableName);
        for(int i=0;i<list.size();++i)
        {
            StringBuilder in_sb=new StringBuilder();
            List l=(List)list.get(i);
            in_sb.append(BaseDisplay.wrapWithTh(l.get(0).toString()));
            for(int j=1;j<l.size();++j)
            {
                in_sb.append(BaseDisplay.wrapWithTd(l.get(j).toString()));
            }
            sb.append(BaseDisplay.wrapWithTr(in_sb.toString()));
        }

        JspWriter writer=pageContext.getOut();
        try {
            writer.print("<table>"+sb.toString()+"</table>");
        } catch (IOException e) {
            e.printStackTrace();
            throw new JspException(e.getMessage());
        }
        return EVAL_PAGE;
    }
}
