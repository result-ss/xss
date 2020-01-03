package com.ss.gateway;

import com.ss.gateway.common.utils.Result;
import com.ss.gateway.service.impl.CoreBusinessServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xueshansheng
 * @date 2019/12/31 下午 5:31
 */
@WebServlet
@Slf4j
public class CoreController extends HttpServlet {

    @Autowired
    private CoreBusinessServiceImpl coreBusinessService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        log.info("收到请求，开始处理{}",request);
        Result<String> result = coreBusinessService.doBusiness(request);
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().append(result.getResult());
        log.info("处理结果，{}",result);
    }
}
