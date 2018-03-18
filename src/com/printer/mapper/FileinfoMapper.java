package com.printer.mapper;

import com.printer.pojo.Fileinfo;
import com.printer.pojo.FileinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FileinfoMapper {
    int countByExample(FileinfoExample example);

    int deleteByExample(FileinfoExample example);

    int deleteByPrimaryKey(String orderid);

    int insert(Fileinfo record);

    int insertSelective(Fileinfo record);

    List<Fileinfo> selectByExample(FileinfoExample example);

    Fileinfo selectByPrimaryKey(String orderid);

    int updateByExampleSelective(@Param("record") Fileinfo record, @Param("example") FileinfoExample example);

    int updateByExample(@Param("record") Fileinfo record, @Param("example") FileinfoExample example);

    int updateByPrimaryKeySelective(Fileinfo record);

    int updateByPrimaryKey(Fileinfo record);
}