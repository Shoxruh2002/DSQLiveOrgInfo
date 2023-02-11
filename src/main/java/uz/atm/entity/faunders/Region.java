package uz.atm.entity.faunders;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Author: Shoxruh Bekpulatov
 * Time: 12/26/22 12:55 PM
 **/

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Region {

    @Column(name = "region_code")
    private Integer code;

    @Column(name = "region_name")
    private String name;

    @Column(name = "region_name_ru")
    @JsonProperty("name_ru")
    private String nameRu;

    @Column(name = "region_name_uz_cyrl")
    @JsonProperty("name_uz_cyrl")
    private String nameUzCyrl;

    @Column(name = "region_name_uz_latn")
    @JsonProperty("name_uz_latn")
    private String nameUzLatn;

    @Column(name = "region_administrative_cnter_code")
    private String administrativeCenterCode;

}
