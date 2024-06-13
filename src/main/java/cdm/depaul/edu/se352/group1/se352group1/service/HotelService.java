package cdm.depaul.edu.se352.group1.se352group1.service;


import javax.annotation.Resource;

import cdm.depaul.edu.se352.group1.se352group1.common.TablePropertyInsert;
import cdm.depaul.edu.se352.group1.se352group1.dao.Hotels;
import cdm.depaul.edu.se352.group1.se352group1.dto.common.GetListResp;
import cdm.depaul.edu.se352.group1.se352group1.dto.response.HotelDTO;
import cdm.depaul.edu.se352.group1.se352group1.mapper.HotelsMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService {

    @Resource
    HotelsMapper hotelsMapper;

    public GetListResp<HotelDTO> getSortedHotelList() {

        List<Hotels> hotelsList = hotelsMapper.selectAllSortedByPrice();

        List<HotelDTO> hotelDTOList = TablePropertyInsert.addEntity(hotelsList);
        GetListResp<HotelDTO> resp = new GetListResp<>();
        resp.setRecords(hotelDTOList);
        return resp;
    }

    public GetListResp<HotelDTO> getHotelList() {

        List<Hotels> hotelsList = hotelsMapper.selectAll();

        List<HotelDTO> hotelDTOList = TablePropertyInsert.addEntity(hotelsList);


        GetListResp<HotelDTO> resp = new GetListResp<>();
        resp.setRecords(hotelDTOList);
        return resp;
    }
}
