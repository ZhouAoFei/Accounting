package com.java.admin.controller;


import com.java.admin.entity.Account;
import com.java.admin.service.AccountService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>账目表 API接口</p>
 *
 * @author 波波老师(微信 ： javabobo0513)
 */
@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    /**
     * 获取所有账目信息
     */
    @GetMapping("/getAllAccount")
    public Map getAllAccount(){
        Map<String, Object> map = new HashMap<>();
        List<Account> accountList = accountService.selectAll();
        map.put("code", "0000");
        map.put("msg", "成功");
        map.put("data", accountList);
        return map;
    }

    /**
     * @param account
     * @return添加账目
     */
    @PostMapping("/saveAccount")
    public Map saveAccount(@RequestBody Account account){
        HashMap map = new HashMap<>();
        account.setCreateTime(new Date());
        int save = accountService.save(account);
        if(save == 1){
            map.put("code", "0000");
            map.put("msg", "成功");
        }else{
            map.put("code", "0001");
            map.put("msg", "失败");
        }
        return map;
    }
    /**
     * 删除账目
     */
    @DeleteMapping("/deleteAccount/{id}")
    public Map updateAccount(@PathVariable("id") Integer id){
        Map<String, Object> map = new HashMap<>();
        int count = accountService.deleteById(id);
        if(count == 1){
            map.put("code", "0000");
            map.put("msg", "成功");
        }else{
            map.put("code", "0001");
            map.put("msg", "失败");
        }
        return map;
    }

    /**
     * @return
     * 获取统计页面数据
     */
    @GetMapping("/getLineData")
    public Map getLineData(){
        return accountService.getLineData();
    }

    /**
     * @param id
     * @return通过id获取指定账目的数据
     */
    @GetMapping("/getOneAccounts/{id}")
    public Map getOneAccounts(@PathVariable("id") Integer id) {
        HashMap<Object, Object> map = new HashMap<>();
        Account account = accountService.getById(id);
        if(account!=null){
            map.put("code", "0000");
            map.put("msg", "成功");
            map.put("data", account);
        }else{
            map.put("code", "0001");
            map.put("msg", "失败");
        }
        return map;
    }


    /**
     * @param
     * @return
     * 根据id编辑（修改）指定的账目数据
     */
    @PutMapping("/updateOneAccounts")
    public Map updateOneAccounts(@RequestBody Account account) {
        HashMap<Object, Object> map = new HashMap<>();
        account.setCreateTime(new Date());
        int update = accountService.update(account);
        if (update==1){
            map.put("code","0000");
            map.put("msg","成功！");
            map.put("data",account);
        }else {
            map.put("code","0001");
            map.put("msg","失败");
        }
        return map;
    }


}
