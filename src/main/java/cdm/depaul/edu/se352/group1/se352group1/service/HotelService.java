package cdm.depaul.edu.se352.group1.se352group1.service;

import com.ht452.hotelpage452.dao.Hotels;
import com.ht452.hotelpage452.dto.GetHotelListReqBO;
import com.ht452.hotelpage452.dto.common.GetListResp;
import com.ht452.hotelpage452.dto.response.HotelDTO;
import com.ht452.hotelpage452.mapper.HotelsMapper;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService {

    @Resource
    HotelsMapper hotelsMapper;

    public GetListResp<HotelDTO> getHotelList() {

        List<Hotels> hotelsList = hotelsMapper.selectAll();
        List<HotelDTO> hotelDTOList = new ArrayList<>();
        for (Hotels hotel : hotelsList) {
            HotelDTO hotelDTO = new HotelDTO();
            hotelDTO.setHotelName(hotel.getName());

            hotelDTOList.add(hotelDTO);
        }

        GetListResp<HotelDTO> resp = new GetListResp<>();
        resp.setRecords(hotelDTOList);
        return resp;
    }
}
