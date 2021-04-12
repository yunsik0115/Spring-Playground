package springmvc.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //request 만들고 response 객체도 만든다 요청 가져오고 응답 반환함.
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);
        /*request = org.apache.catalina.connector.RequestFacade@7f53ad6d
         response = org.apache.catalina.connector.ResponseFacade@71944cf7
         WAS 서버에 의해 생성된 구현체들이 찍히는것을 볼 수 있다 */

        String username = request.getParameter("username");
        System.out.println("username = " + username);
        // query문 받아오는 방법

        response.setContentType("text/plain"); // 단순 text 문자로 response
        response.setCharacterEncoding("utf-8"); // utf-8 권장
        // 위 2줄은 헤더에 들어감
        response.getWriter().write("Hello" + username); // body 태그에 들어감.
    }
}
