package personal.yuzerk.easy_ebean;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.junit.Test;
import personal.yuzerk.easy_ebean.util.JSONUtil;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author yuzk
 * @date 2017/11/28
 */
public class XMLRpcTest {

    @Test
    public void http() {
        try {

            XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
            config.setBasicEncoding("UTF-8");
            config.setBasicUserName("admin");
            config.setBasicPassword("123456");
            System.out.println(config.isEnabledForExtensions());
            config.setEnabledForExtensions(true);
            config.setServerURL(new URL("http://127.0.0.1:8080/xmlrpc"));

            XmlRpcClient client = new XmlRpcClient();
            client.setConfig(config);

            Object[] params = new Object[]{"bob"};
            Object result = client.execute("redirect.findCustomer", params);
            if(result == null) {
                System.out.println("result is null");
                return;
            }
            System.out.println(JSONUtil.serialize(result));

        } catch (XmlRpcException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
