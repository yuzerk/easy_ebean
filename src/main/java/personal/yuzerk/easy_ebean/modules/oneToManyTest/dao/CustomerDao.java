package personal.yuzerk.easy_ebean.modules.oneToManyTest.dao;

import org.springframework.stereotype.Repository;
import personal.yuzerk.easy_ebean.common.basic.BaseDao;
import personal.yuzerk.easy_ebean.modules.oneToManyTest.entity.Customer;

/**
 * @author yuzk
 * @date 2017/11/24
 */
@Repository
public class CustomerDao extends BaseDao<Customer> {

    public void insert(String name, Integer sex) {

        saveOrUpdate(new Customer().setName(name).setSex(sex));
    }

    public Customer findByName(String name) {

        return createQuery()
                .setDisableLazyLoading(true)
                .fetch("contacts")
                .where()
                .eq("name",name)
                .findUnique();
    }

    public Customer findByNameNotFetch(String name) {

        return createQuery()
                .setDisableLazyLoading(true)
                .where()
                .eq("name",name)
                .findUnique();
    }

    public Integer deleteByName(String name) {

        return createQuery()
                .where()
                .eq("name",name)
                .delete();
    }

    public Customer findIncludeSizeByName(String name) {

        return createQuery()
                .select("count")
                .setDisableLazyLoading(true)
                .where()
                .eq("name", name)
                .findUnique();
    }
}
