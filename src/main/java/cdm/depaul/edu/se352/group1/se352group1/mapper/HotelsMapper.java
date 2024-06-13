package cdm.depaul.edu.se352.group1.se352group1.mapper;


import cdm.depaul.edu.se352.group1.se352group1.dao.Hotels;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HotelsMapper {
    int deleteByPrimaryKey(Integer hotelId);

    int insert(Hotels record);

    Hotels selectByPrimaryKey(Integer hotelId);

    List<Hotels> selectAll();

    List<Hotels> selectAllSortedByPrice();

    int updateByPrimaryKey(Hotels record);
}