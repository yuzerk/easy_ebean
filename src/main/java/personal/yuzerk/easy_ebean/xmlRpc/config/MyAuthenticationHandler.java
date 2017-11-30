package personal.yuzerk.easy_ebean.xmlRpc.config;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.XmlRpcRequest;
import org.apache.xmlrpc.server.AbstractReflectiveHandlerMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yuzk
 * @date 2017/11/28
 */
public class MyAuthenticationHandler implements AbstractReflectiveHandlerMapping.AuthenticationHandler{

    private HttpServletRequest request;

    public MyAuthenticationHandler(HttpServletRequest request){

        this.request = request;
    }

    @Override
    public boolean isAuthorized(XmlRpcRequest xmlRpcRequest) throws XmlRpcException {
        //TODO 校验身份
        return true;
    }
}
