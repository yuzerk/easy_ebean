package personal.yuzerk.easy_ebean.modules.oneToManyTest.service;

import org.springframework.stereotype.Service;
import personal.yuzerk.easy_ebean.common.basic.BaseService;
import personal.yuzerk.easy_ebean.modules.oneToManyTest.dao.ContactDao;
import personal.yuzerk.easy_ebean.modules.oneToManyTest.entity.Contact;

/**
 * @author yuzk
 * @date 2017/11/24
 */
@Service
public class ContactService extends BaseService<ContactDao> {

    public void insert(String type,String typeDetail,String customerId) {

        dao.saveOrUpdate(new Contact()
                .setCustomerId(customerId)
                .setType(type)
                .setTypeDetail(typeDetail));
    }

    public Contact get(String id) {

        return dao.findById(id);
    }

    public Contact fetch2Properties() {
        return dao.findFetch();
    }

    public void contactChangeCustomerId(String customerId ,String id) {
        dao.contactChangeCustomerId(customerId, id);
    }
}
