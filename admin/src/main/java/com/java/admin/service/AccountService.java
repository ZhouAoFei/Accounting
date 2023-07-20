package com.java.admin.service;




import com.java.admin.entity.Account;
import com.java.admin.mapper.AccountMapper;
import com.java.admin.vo.DataVo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AccountService {

    @Resource
    private AccountMapper accountMapper;

    /**
     * 根据ID查询账目信息
     * @param id
     * @return
     */
    public Account getById(int id){
        return accountMapper.getById(id);
    }

    /**
     * 新增账目
     *
     * @param account
     * @return
     */
    public int save (Account account){
        return accountMapper.save(account);
    }

    /**
     * 更新账目信息
     * @param account
     * @return
     */
    public int update (Account account){
        return accountMapper.update(account);
    }

    /**
     * 根据ID删除指定账目记录
     * @param id
     * @return
     */
    public int deleteById (int id){
        return accountMapper.deleteById(id);
    }

    /**
     * 查询所有账目信息
     */
    public List<Account> selectAll() {


        return accountMapper.selectAll();
    }
    //获取图表数据
    public Map getLineData() {
        Map<String, Object> map = new HashMap<>();
        //收入数据
        List<DataVo> list1 = accountMapper.getLineData(1);
        //开支数据
        List<DataVo> list2 = accountMapper.getLineData(2);
        map.put("list1", list1);
        map.put("list2", list2);
        return map;
    }
}
