package com.ohgiraffers.lifecycle.xml;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

// 24-10-31 (목) 2교시 XML 방식으로 container 등록
public class LifeCycleTestServlet extends HttpServlet {
    // 서블릿 상속받기 (서블릿을 컨테이너에 삽입)

    /* comment. 각 메서드의 호출 횟수 카운트 할 필드 작성 */
    private int initCount = 1;
    private int serviceCount = 1;
    private int destroyCount = 1;

    public LifeCycleTestServlet(){
        System.out.println("기본 생성자 호출됨...");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        /* comment. 최초 요청 시 동작하는 메서드
         *   서블릿 컨테이너에 의해 호출되며, 두 번째 요청부터는 호출되지 않음 */
        System.out.println("xml 매핑 init() 메서드 호출 : " + initCount++);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
        /* comment.
         *   서블릿 컨테이너에 의해 호출되며,
         *   최초 요청 init()메서드 동작 후에 동작
         *   두번째 요청부터는 init() 호출 없이 바로 호출됨 */
        System.out.println("xml 매핑 service()메서드 호출됨 : " + serviceCount++);
    }

    @Override
    public void destroy() {
        super.destroy();
        /* comment. 파괴
         *   서블릿 컨테이너가 종료될 때 호출되는 메서드 */
        System.out.println("xml 매핑 destroy() 메서드 호출 : " + destroyCount++);
    }
}
