package com.roc.bank2.mapper;



import com.roc.bank2.entity.AccountInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AccountMapper {

    @Update("update account_info set account_balance=account_balance+#{amount} where account_no=#{accountNo}")
    int updateAccountBalance(@Param("accountNo") String accountNo, @Param("amount") Double amount);

    @Select("select count(1) from de_duplication where tx_no = #{txNo}")
    int isExistTx(String txNo);

    @Insert("insert into de_duplication values(#{txNo},now());")
    int addTx(String txNo);

    @Select("select * from account_info where id=#{id}")
    AccountInfo findById(@Param("id") Integer id);
}