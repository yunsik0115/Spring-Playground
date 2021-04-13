package springmvc.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 전체 parameter 조회
        Enumeration<String> parameterNames = req.getParameterNames();
        req.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println("paramName = " + req.getParameter(paramName)));
        
        // 2. 단일 parameter 조회
        String username = req.getParameter("username"); // 단일일 경우 사용
        System.out.println("username = " + username);
        String age = req.getParameter("age");
        System.out.println("age = " + age);

        // 3. 중복 parameter 조회
        // for example : uri/index?username=hello&age=20&username=hello2 .... etc
        String[] usernames = req.getParameterValues("username"); // 중복 파라미터일 경우 사용
        for (String name : usernames) {
            System.out.println("name = " + name);
        }

    }
}
