package cineplex.tags;

import cineplex.model.ActivityDetail;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.List;

/**
 * Created by wlw on 15-3-14.
 */
public class DisplayQuestionTag extends TagSupport {
    public int doEndTag() throws JspException {
        ServletRequest req = pageContext.getRequest();
        List list=(List)req.getAttribute("question_list");
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<list.size();++i)
        {
            StringBuilder question_sb=new StringBuilder();
            ActivityDetail activityDetail=(ActivityDetail)list.get(i);
            question_sb.append("题目");
            question_sb.append(i);
            question_sb.append(":");
            question_sb.append(activityDetail.getQuestion());
            sb.append(BaseDisplay.wrapWithDiv(question_sb.toString()));
            StringBuilder answer_sb=new StringBuilder();
            String answer[]=activityDetail.getAnswer().split(";");
            for(int j=0;j<answer.length;++j)
            {
                answer_sb.append("<label><input type=\"radio\" name=\"answerList[");
                answer_sb.append(i);
                answer_sb.append("]\" value=\"");
                answer_sb.append(answer[j]);
                answer_sb.append("\"/>");
                answer_sb.append(answer[j]);
                answer_sb.append("</label>");
            }
            sb.append(BaseDisplay.wrapWithDiv(answer_sb.toString()));
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
