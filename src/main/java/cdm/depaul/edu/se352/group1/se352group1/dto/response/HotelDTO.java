package cdm.depaul.edu.se352.group1.se352group1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author simba@onlying.cn
 * @date 12/14/23 3:51PM
 * @description example
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelDTO {


    private String hotelId;
    private String hotelName;
    private String locationId;
    private String description;
    private Integer price;
    private Integer roomLeft;
}
