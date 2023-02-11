package uz.atm.entity.faunders;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Author: Shoxruh Bekpulatov
 * Time: 12/26/22 12:43 PM
 **/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class StatusDetail {

    @Column(name = "status_detail_code")
    private Integer code;

    @Column(name = "status_detail_name")
    private String name;

    @Column(name = "status_detail_name_ru")
    @JsonProperty("name_ru")
    private String nameRu;

    @Column(name = "status_detail_name_uz_cyrl")
    @JsonProperty("name_uz_cyrl")
    private String nameUzCyrl;

    @Column(name = "status_detail_name_uz_latn")
    @JsonProperty("name_uz_latn")
    private String nameUzLatn;

    @Column(name = "status_detail_group")
    private String group;

}
