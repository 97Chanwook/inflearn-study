package inflearn.study.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name="requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        printStartLine(request);
//        printAllHeader(request);
//        printEasyHeader(request);
        printEtc(request);
    }

    private static void printStartLine(HttpServletRequest request) {
        System.out.println("--- REQUEST-LINE - start ---");
        System.out.println("METHOD : "+ request.getMethod());
        System.out.println("PROTOCOL : "+ request.getProtocol());
        System.out.println("SCHEME : "+ request.getScheme());


        System.out.println("URL : "+ request.getRequestURL());  // http://localhost:8080/request-header
        System.out.println("URI : "+ request.getRequestURI());  // /request-header

        System.out.println("QUERY : "+ request.getQueryString());
        System.out.println("HTTPS : "+ request.isSecure());
        System.out.println("--- REQUEST-LINE - end ---");
    }

    //Header의 모든 정보 확인
    private static void printAllHeader(HttpServletRequest request) {
        System.out.println("--- REQUEST-LINE - start ---");
        Enumeration<String> headerNames = request.getHeaderNames();

//        while(headerNames.hasMoreElements()){
//            String headerName = headerNames.nextElement();
//            System.out.println(headerName + " : " + request.getHeaderNames());
//        }

        request.getHeaderNames().asIterator()
                .forEachRemaining(headerName -> System.out.println(headerName + " : " + request.getHeaderNames()));

        // 특정 Header 가져오기
//        request.getHeader("Content-Type");
        System.out.println("--- REQUEST-LINE - end ---");
    }

    private static void printEasyHeader(HttpServletRequest request) {
        System.out.println("--- REQUEST-LINE - start ---");

        System.out.println("[HOST 편의 조회]");
        System.out.println("Server = "+request.getServerName());
        System.out.println("Port = "+request.getServerPort());
        System.out.println();

        System.out.println("[Accept-Language 편의 조회]");
        request.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("Locale = "+ locale));
        System.out.println();
        System.out.println("Now Locale = "+request.getLocale());
        System.out.println();

        System.out.println("[cookie 편의 조회]");
        if (request.getCookies() != null ) {
            for (Cookie cookie : request.getCookies()) {
                System.out.println(cookie.getName() + " : " + cookie.getValue());
            }
        }
        System.out.println();

        System.out.println("[Content 편의 조회]");
        System.out.println("Content-Type = "+request.getContentType());
        System.out.println("Content-Length = "+request.getContentLength());
        System.out.println("Character-Encoding = "+request.getCharacterEncoding());
        System.out.println("--- REQUEST-LINE - end ---");
    }

    private static void printEtc(HttpServletRequest request){
        System.out.println("--- REQUEST-LINE - start ---");

        System.out.println("[Remote 정보 조회]");
        System.out.println("Remote Host = "+request.getRemoteHost());
        System.out.println("Remote Address = "+request.getRemoteAddr());
        System.out.println("Remote Port = "+request.getRemotePort());
        System.out.println();

        System.out.println("[Local 정보]");
        System.out.println("Local Name = "+request.getLocalName());
        System.out.println("Local Address = "+request.getLocalAddr());
        System.out.println("Local Port = "+request.getLocalPort());
        System.out.println("--- REQUEST-LINE - end ---");


    }
}
