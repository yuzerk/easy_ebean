package personal.yuzerk.easy_ebean.modules.oneToManyTest.service;


import io.ebean.PagedList;
import io.ebean.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import personal.yuzerk.easy_ebean.common.basic.BaseService;
import personal.yuzerk.easy_ebean.exception.BadRequestException;
import personal.yuzerk.easy_ebean.modules.oneToManyTest.dao.ContactDao;
import personal.yuzerk.easy_ebean.modules.oneToManyTest.dao.CustomerDao;
import personal.yuzerk.easy_ebean.modules.oneToManyTest.entity.Customer;
import personal.yuzerk.easy_ebean.result.MyPagedList;

import java.util.List;

/**
 * @author yuzk
 * @date 2017/11/24
 */
@Service
public class CustomerService extends BaseService<CustomerDao> {

    @Autowired
    private ContactDao contactDao;

    public void insert(String name, Integer sex) {

        dao.insert(name,sex);
    }

    public Customer getByName(String name) {

        return dao.findByName(name);
    }

    public List<Customer> gets(MyPagedList<Customer> pagedList) {
        operatorPage(pagedList);
        PagedList<Customer> customers =  dao.createOrderBy().asc("name")
                .setFirstRow(pagedList.getFirstRow())   //设置本次查询需要获得的数据的第一条所在行，计数以0为最初值
                .setMaxRows(pagedList.getPageSize())    // 设置本次查询需要获得的条数，一般为page的大小
                .findPagedList();
        if(isEmpty(pagedList.getTotal())) {
            pagedList.setTotal(customers.getTotalCount());
        }
        //还可以返回成一个PagedList
        return customers.getList();
    }
//
//    @Transactional
    public Integer testTransaction(String name) {
        Customer customer = dao.findByNameNotFetch(name);
        if(isEmpty(customer)) {
            throw new BadRequestException("can not find name", HttpStatus.BAD_REQUEST);
        }
        contactDao.updateQuery()
                .set("customerId","1")
                .where()
                .eq("customerId",customer.getId())
                .update();

        Integer result = dao.deleteByName(name);
        result = 1/0;
        return result;
    }

    public Customer findIncludeSizeByName(String name) {
        return dao.findIncludeSizeByName(name);
    }

    public void save(Customer customer) {
        dao.saveOrUpdate(customer);
    }
}
