package personal.yuzerk.easy_ebean.modules.oneToManyTest.entity;

import personal.yuzerk.easy_ebean.common.basic.BaseEntity;
import personal.yuzerk.easy_ebean.util.ValidateUtil;

import javax.persistence.*;

/**
 * @author yuzk
 * @date 2017/11/23
 */
@Entity
@Table(name = "contact")
public class Contact extends BaseEntity {

    private String type;
    private String typeDetail;

    @ManyToOne(optional = false,cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId")
    private Customer customer;
//    private String customerId;

    public String getType() {
        return type;
    }

    public Contact setType(String type) {
        this.type = type;
        return this;
    }

    public String getTypeDetail() {
        return typeDetail;
    }

    public Contact setTypeDetail(String typeDetail) {
        this.typeDetail = typeDetail;
        return this;
    }

    public Contact setCustomerId(String id) {
        if(ValidateUtil.isEmpty(customer)) {
            customer = new Customer();
        }
        customer.setId(id);
        return this;
    }

    public Contact setCustomerName(String name) {
        if(ValidateUtil.isEmpty(customer)) {
            customer = new Customer();
        }
        customer.setName(name);
        return this;
    }
    public String getCustomerId() {
        return customer.getId();
    }
    public String getCustomerName() {
        if(customer == null) {
            return null;
        }
        return customer.getName();
    }

//
//    public String getCustomerId() {
//        return customerId;
//}
//
//    public Contact setCustomerId(String customerId) {
//        this.customerId = customerId;
//        return this;
//    }
}
