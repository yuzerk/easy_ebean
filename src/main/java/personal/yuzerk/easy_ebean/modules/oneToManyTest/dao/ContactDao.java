package personal.yuzerk.easy_ebean.modules.oneToManyTest.dao;


import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Repository;
import personal.yuzerk.easy_ebean.common.basic.BaseDao;
import personal.yuzerk.easy_ebean.modules.oneToManyTest.entity.Contact;

import java.util.List;

/**
 * @author yuzk
 * @date 2017/11/24
 */
@Repository
public class ContactDao extends BaseDao<Contact> {

    public Contact geta() {

        return createQuery()
                .where()
                .eq("id","1ef85f9bd57941b2aa993d74778b0f89")
                .findOne();
    }

    public List<Contact> getByCustomerId(String customerId) {

        return createQuery()
                .where()
                .eq("customerId",customerId)
                .findList();
    }

    public Contact findFetch() {

        return createQuery()
                .fetch("customer")
                .where()
                .eq("type", "email")
                .findUnique();
    }

    public void contactChangeCustomerId(String customerId, String id){

        Contact contact = findById(id);
        contact.setCustomerId(customerId);
        saveOrUpdate(contact);
    }
}
