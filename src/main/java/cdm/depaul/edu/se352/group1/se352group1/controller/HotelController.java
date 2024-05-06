package cdm.depaul.edu.se352.group1.se352group1.controller;

import cdm.depaul.edu.se352.group1.se352group1.common.CommonResp;
import cdm.depaul.edu.se352.group1.se352group1.dto.GetHotelListReqBO;
import cdm.depaul.edu.se352.group1.se352group1.dto.common.GetListResp;
import cdm.depaul.edu.se352.group1.se352group1.dto.response.HotelDTL;
import cdm.depaul.edu.se352.group1.se352group1.service.HotelService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController {

    @Resource
    HotelService hotelService;

    @PostMapping("/hotel/getList")
    public CommonResp<GetListResp<HotelDTO>> getHotelList() {
        return CommonResp.ok(hotelService.getHotelList());
    }
}
