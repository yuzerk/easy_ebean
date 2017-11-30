package personal.yuzerk.easy_ebean.xmlRpc.config;


import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.XmlRpcRequest;
import org.apache.xmlrpc.server.RequestProcessorFactoryFactory;
import personal.yuzerk.easy_ebean.xmlRpc.XmlRpcService;

/**
 * @author yuzk
 * @date 2017/11/28
 */
public class MyRequestProcessorFactoryFactory implements RequestProcessorFactoryFactory{


    private final RequestProcessorFactory factory= new MyRequestProcessorFactory();
    private final XmlRpcService xmlRpcService;

    public MyRequestProcessorFactoryFactory(XmlRpcService xmlRpcService) {

        this.xmlRpcService = xmlRpcService;
    }

    @Override
    public RequestProcessorFactory getRequestProcessorFactory(Class aClass) throws XmlRpcException {
        return factory;
    }


    private class MyRequestProcessorFactory implements
            RequestProcessorFactory {

        @Override
        public Object getRequestProcessor(XmlRpcRequest arg0)
                throws XmlRpcException {
            return xmlRpcService;
        }

    }
}
