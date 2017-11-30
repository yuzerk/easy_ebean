package personal.yuzerk.easy_ebean.xmlRpc.config;

import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.XmlRpcServletServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import personal.yuzerk.easy_ebean.xmlRpc.XmlRpcApiService;
import personal.yuzerk.easy_ebean.xmlRpc.XmlRpcService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yuzk
 * @date 2017/11/28
 */
@WebServlet(urlPatterns = "/xmlrpc/*")
public class XmlRpcServlet extends HttpServlet {

    @Autowired
    private XmlRpcApiService apiService;

    //TODO 自动注入一个loginService 用来校验登录信息

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = this.getServletContext();

        //配置当前类可以使用自动注入的bean
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            // create a new XmlRpcServletServer object and set ErrorLogger Config
            XmlRpcServletServer server = new XmlRpcServletServer();
            MyXmlRpcErrorLogger errorLog = new MyXmlRpcErrorLogger();
            server.setErrorLogger(errorLog);

            // set up handler mapping of XmlRpcServletServer object
            PropertyHandlerMapping phm = new PropertyHandlerMapping();

            //新建Base authentication控制类
            MyAuthenticationHandler handler = new MyAuthenticationHandler(req); //这里可以再传入一个loginService,然后在handle里处理登录信息确认操作

            //当xmlRpcServer获取对应的Handler()的实例类的工厂类
            phm.setRequestProcessorFactoryFactory(new MyRequestProcessorFactoryFactory(
                    new XmlRpcService(apiService, handler)
            ));

            phm.setAuthenticationHandler(handler);

            //设置key对应的Handler处理类，client端以redirect.methodName来访问
            phm.addHandler("redirect", XmlRpcService.class);

            server.setHandlerMapping(phm);

            // more config of XmlRpcServletServer object
            XmlRpcServerConfigImpl serverConfig = (XmlRpcServerConfigImpl) server.getConfig();
            serverConfig.setEnabledForExtensions(true);
            serverConfig.setContentLengthOptional(false);
            server.execute(req, resp);

            if(errorLog.isHasError()) {
                //TODO 以warn输出到错误日志里
            }

        }catch (Exception e) {

            //TODO 以error输出到错误日志
            throw new ServletException(e);
        }
    }
}
