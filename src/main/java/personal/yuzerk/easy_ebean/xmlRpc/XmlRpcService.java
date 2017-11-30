package personal.yuzerk.easy_ebean.xmlRpc;


import org.apache.log4j.Logger;
import personal.yuzerk.easy_ebean.modules.oneToManyTest.entity.Contact;
import personal.yuzerk.easy_ebean.modules.oneToManyTest.entity.Customer;
import personal.yuzerk.easy_ebean.xmlRpc.config.MyAuthenticationHandler;

import java.util.List;

/**
 *处理rpc的请求，将其转至apiService处理
 *
 * @author yuzk
 * @date 2017/11/28
 */
public class XmlRpcService {

    private static final Logger log = Logger.getLogger(XmlRpcService.class);

    private XmlRpcApiService apiService;
    private MyAuthenticationHandler handler;

    public XmlRpcService() {
    }

    public XmlRpcService(XmlRpcApiService apiService, MyAuthenticationHandler myAuthenticationHandler) {
        this.apiService = apiService;
        this.handler = myAuthenticationHandler;
    }



    //TODO 各个服务函数：内部调用apiService实现
    public Customer findCustomer(String name) {

        Customer customer = apiService.findCustomer(name);
        if(customer.getContacts() == null) {
            System.out.println(" is null ");
        }
        else {
            System.out.println(customer.getContacts().size());
        }
        return customer;
    }


    public List<Contact> getContact() {

        return apiService.geta();
    }

    public List<Contact> getContacts(String name) {
        return apiService.getByCustomer(name);
    }
}
