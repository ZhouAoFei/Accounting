package com.java.admin.mapper;


import com.java.admin.entity.Account;
import com.java.admin.vo.DataVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * <p>AccountMapper</p>
 *
 * @author 波波老师(微信 ： javabobo0513)
 */
@Mapper
public interface AccountMapper {

    /**
     * 根据ID查询账目信息
     * @param id
     * @return
     */
    Account getById(int id);

    /**
     * 新增账目
     * @param account
     * @return
     */
    int save (Account account);

    /**
     * 更新账目信息
     * @param account
     * @return
     */
    int update (Account account);

    /**
     * 根据ID删除指定账目记录
     * @param id
     * @return
     */
    int deleteById (int id);

    /**
     * 查询所有账目信息
     */
    List<Account> selectAll();

    List<DataVo> getLineData(@Param("type") int i);
}
