package personal.yuzerk.easy_ebean.xmlRpc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.yuzerk.easy_ebean.modules.oneToManyTest.dao.ContactDao;
import personal.yuzerk.easy_ebean.modules.oneToManyTest.dao.CustomerDao;
import personal.yuzerk.easy_ebean.modules.oneToManyTest.entity.Contact;
import personal.yuzerk.easy_ebean.modules.oneToManyTest.entity.Customer;

import java.util.Arrays;
import java.util.List;

/**
 * @author yuzk
 * @date 2017/11/28
 */
@Service
public class XmlRpcApiService {


    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private ContactDao contactDao;

    public Customer findCustomer(String name) {

        return customerDao.findByName(name);
    }


    public List<Contact> geta() {

        return Arrays.asList(contactDao.geta(),contactDao.geta());
    }

    public List<Contact> getByCustomer(String name) {

        String id = customerDao.findByName(name).getId();
        return contactDao.getByCustomerId(id);
    }
}
