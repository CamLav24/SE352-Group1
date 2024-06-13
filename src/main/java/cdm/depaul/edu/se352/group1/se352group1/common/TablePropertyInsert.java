package cdm.depaul.edu.se352.group1.se352group1.common;

import cdm.depaul.edu.se352.group1.se352group1.dao.Hotels;
import cdm.depaul.edu.se352.group1.se352group1.dto.response.HotelDTO;

import java.util.ArrayList;
import java.util.List;

public class TablePropertyInsert {
    public static List<HotelDTO> addEntity(List<Hotels> hotelsList){
        List<HotelDTO> hotelDTOList = new ArrayList<>();
        for (Hotels hotel : hotelsList) {
            HotelDTO hotelDTO = new HotelDTO();
            hotelDTO.setHotelName(hotel.getName());

            hotelDTO.setHotelName(hotel.getName());
            hotelDTO.setHotelId(hotel.getHotelId().toString());
            hotelDTO.setPrice(hotel.getPrice().intValue());
            hotelDTO.setLocationId(hotel.getLocationId().toString());
            hotelDTO.setRoomLeft(hotel.getRoomsLeft());
            hotelDTO.setDescription(hotel.getDescription());

            hotelDTO.setImageUrl(hotel.getImageUrl());

            hotelDTOList.add(hotelDTO);
        }
        return hotelDTOList;
    }

}
