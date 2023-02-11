package uz.atm.entity.faunders;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Author: Shoxruh Bekpulatov
 * Time: 12/26/22 12:56 PM
 **/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class District {

    @Column(name = "district_code")
    private Integer code;

    @Column(name = "district_name")
    private String name;

    @Column(name = "district_name_ru")
    @JsonProperty("name_ru")
    private String nameRu;

    @Column(name = "district_name_uz_cyrl")
    @JsonProperty("name_uz_cyrl")
    private String nameUzCyrl;

    @Column(name = "district_name_uz_latn")
    @JsonProperty("name_uz_latn")
    private String nameUzLatn;

    @Column(name = "district_administrativeCenterCode")
    private String administrativeCenterCode;

    @Column(name = "district_regionCode")
    private String regionCode;

    @Column(name = "district_region_id")
    @JsonProperty("region_id")
    private Long regionId;

    @Column(name = "district_region_id_2")
    @JsonProperty("regionId")
    private Long regionId2;

    @Column(name = "district_districtId")
    private Integer districtId;

    @Column(name = "district_districts_id")
    @JsonProperty("districts_id")
    private Integer districtsId;

    @Column(name = "district_active")
    private String active;
}

