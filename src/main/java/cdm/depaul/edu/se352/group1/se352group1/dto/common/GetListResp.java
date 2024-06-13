package cdm.depaul.edu.se352.group1.se352group1.dto.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author lxie
 * @date 12/18/23
 * @description example
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetListResp<T> {

    private List<T> records;


}
