package uz.atm.entity.faunders;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Author: Shoxruh Bekpulatov
 * Time: 1/20/23 2:39 PM
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class OpfDetail {

    @Column(name = "opf_detail_code")
    private Integer code;

    @Column(name = "opf_detail_name")
    private String name;

    @Column(name = "opf_detail_name_ru")
    @JsonProperty("name_ru")
    private String nameRu;

    @Column(name = "opf_detail_name_uz_cyrl")
    @JsonProperty("name_uz_cyrl")
    private String nameUzCyrl;

    @Column(name = "opf_detail_name_uz_latn")
    @JsonProperty("name_uz_latn")
    private String nameUzLatn;

}
