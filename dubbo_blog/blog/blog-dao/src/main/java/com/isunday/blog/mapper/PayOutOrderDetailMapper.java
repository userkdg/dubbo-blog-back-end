package com.isunday.blog.mapper;

import com.isunday.blog.model.PayOutOrderDetail;
import com.isunday.blog.model.PayOutOrderDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayOutOrderDetailMapper {
    int countByExample(PayOutOrderDetailExample example);

    int deleteByExample(PayOutOrderDetailExample example);

    int deleteByPrimaryKey(Integer payOutOrderDetailId);

    int insert(PayOutOrderDetail record);

    int insertSelective(PayOutOrderDetail record);

    List<PayOutOrderDetail> selectByExample(PayOutOrderDetailExample example);

    PayOutOrderDetail selectByPrimaryKey(Integer payOutOrderDetailId);

    int updateByExampleSelective(@Param("record") PayOutOrderDetail record, @Param("example") PayOutOrderDetailExample example);

    int updateByExample(@Param("record") PayOutOrderDetail record, @Param("example") PayOutOrderDetailExample example);

    int updateByPrimaryKeySelective(PayOutOrderDetail record);

    int updateByPrimaryKey(PayOutOrderDetail record);
}