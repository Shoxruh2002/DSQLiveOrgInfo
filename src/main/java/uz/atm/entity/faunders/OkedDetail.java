package uz.atm.entity.faunders;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Author: Shoxruh Bekpulatov
 * Time: 12/26/22 12:49 PM
 **/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class OkedDetail {
    @Column(name = "oked_detail_code")
    private Integer code;

    @Column(name = "oked_detail_name")
    private String name;

    @Column(name = "oked_detail_name_ru")
    @JsonProperty("name_ru")
    private String nameRu;

    @Column(name = "oked_detail_name_uz_cyrl")
    @JsonProperty("name_uz_cyrl")
    private String nameUzCyrl;

    @Column(name = "oked_detail_name_uz_latn")
    @JsonProperty("name_uz_latn")
    private String nameUzLatn;

    @Column(name = "oked_detail_section")
    private String section;

    @Column(name = "oked_detail_name_short_ru")
    @JsonProperty("name_short_ru")
    private String nameShortRu;

    @Column(name = "oked_detail_name_short_uz_cyrl")
    @JsonProperty("name_short_uz_cyrl")
    private String nameShortUzCyrl;

    @Column(name = "oked_detail_name_short_uz_latn")
    @JsonProperty("name_short_uz_latn")
    private String nameShortUzLatn;

    @Column(name = "oked_detail_pkm275")
    private Integer pkm275;

    @Column(name = "oked_detail_employee_limit_mf")
    @JsonProperty("employee_limit_mf")
    private Integer employeeLimitMf;

    @Column(name = "oked_detail_employee_limit_lf")
    @JsonProperty("employee_limit_lf")
    private Integer employeeLimitLf;


}
