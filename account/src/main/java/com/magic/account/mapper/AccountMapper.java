package com.magic.account.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author laoma
 * @create 2022-07-17 0:28
 */
@Mapper
public interface AccountMapper {
    @Update("update account_tbl set money=money-#{money} where user_id=#{account}")
    int updateAccount(@Param("account") String account, @Param("money") Double money);

    @Select("select money from account_tbl where user_id=#{account}")
    Double getMoneyByAccount(String account);
}
