package inflearn.study.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    // protected 로 선언된 service 메소드를 오버라이드
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // soutm -> 메소드 출력문 생성 단축키
        System.out.println("HelloServlet.service");

        // soutv -> 변수 출력문 생성 단축키
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        //파라미터 가져오기
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        //Response Header Setting
        response.setContentType("text/plain");  //Content-Type
        response.setCharacterEncoding("utf-8"); //Encoding

        //Response 결과 Setting
        response.getWriter().write("hello "+username);
    }
}
