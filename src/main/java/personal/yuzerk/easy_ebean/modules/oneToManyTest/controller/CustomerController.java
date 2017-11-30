package personal.yuzerk.easy_ebean.modules.oneToManyTest.controller;


import org.springframework.web.bind.annotation.*;
import personal.yuzerk.easy_ebean.common.basic.BaseController;
import personal.yuzerk.easy_ebean.modules.oneToManyTest.entity.Customer;
import personal.yuzerk.easy_ebean.modules.oneToManyTest.service.CustomerService;
import personal.yuzerk.easy_ebean.result.MyPagedList;
import personal.yuzerk.easy_ebean.result.Result;

/**
 * @author yuzk
 * @date 2017/11/24
 */
@RestController
@RequestMapping("/cus")
public class CustomerController extends BaseController<CustomerService> {

    @GetMapping("/insert")
    public void insert(String name, Integer sex) {

        service.insert(name,sex);
    }

    @GetMapping("/get")
    public Result get(String name)  {

       return success(service.getByName(name));
    }

    @PostMapping("/page")
    public Result getPage(@RequestBody MyPagedList<Customer> pagedList) {

        return success(service.gets(pagedList));
    }

    @GetMapping("/trans")
    public Result testTranscation(String name) {

        return success(service.testTransaction(name));
    }
}
