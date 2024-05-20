package cdm.depaul.edu.se352.group1.se352group1.mapper;

import cdm.depaul.edu.se352.group1.se352group1.dao.Images;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ImagesMapper {
    int deleteByPrimaryKey(Integer imageId);

    int insert(Images record);

    Images selectByPrimaryKey(Integer imageId);

    List<Images> selectAll();

    int updateByPrimaryKey(Images record);
}