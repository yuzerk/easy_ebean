package personal.yuzerk.easy_ebean.modules.oneToManyTest.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import personal.yuzerk.easy_ebean.common.basic.BaseController;
import personal.yuzerk.easy_ebean.modules.oneToManyTest.service.ContactService;
import personal.yuzerk.easy_ebean.protocol.ContactProtocol;
import personal.yuzerk.easy_ebean.result.Result;

import javax.validation.Valid;

/**
 * @author yuzk
 * @date 2017/11/24
 */
@RestController
@RequestMapping("/con")
public class ContactController extends BaseController<ContactService> {

    @PostMapping("/insert")
    public void insert(@RequestBody @Valid ContactProtocol.Insert.CustomerVo vo , BindingResult result) {

        service.insert(vo.getType(),vo.getTypeDetail(),vo.getCustomerId());
    }

    public Result get(String id) {

        return success(service.get(id));
    }

    @GetMapping("/fetch")
    public Result fetch2Properties() {
        return success(service.fetch2Properties());
    }
}
