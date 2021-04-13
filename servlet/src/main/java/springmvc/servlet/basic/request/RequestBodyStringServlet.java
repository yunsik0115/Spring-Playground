package springmvc.servlet.basic.request;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletInputStream inputStream = req.getInputStream();
        // -> 이 코드는 바디의 내용을 바이트 코드를 반환한다. 따라서 String으로 보려면 문자표 지정필요.
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        // 바이트->문자변환하는 경우 인코딩 정보를 제공해야 함
        resp.getWriter().write("ok");
    }
}
