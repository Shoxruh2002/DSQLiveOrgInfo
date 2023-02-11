package uz.atm.utils.properties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 23/08/22
 * Time: 15:19
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "dsq.api")
public class DSQApiProperties {

    private Url url;
    private String user;
    private String password;

    @Data
    public static class Url {
        private String protocol;
        private String domain;
        private Path path;

        @Data
        public static class Path {
            private String loginAPI; //login API
            private String juridicInfoAPI; //yuridik shaxslar va YTT lar haqida info oluvchi API
            private String individualInfoAPI; //JShShIR so'rovi orqali YaTT haqida ma'lumot oluvchi API
            private String financialStatementsFormOneAPI; //Moliyaviy hisobotlar (1chi shakli) oluvchi API
            private String financialStatementsFormTwoAPI; //Moliyaviy hisobotlar (2chi shakli) oluvchi API
            private String doubtfulTaxpayerAPI; //Shubhali soliq to'lovchilar haqida malumot oluvchi API
            private String purchaseInfoAPI;  //Davlat xaridlari haqida malumot junatiladigan API
            private String taxGapInfoAPI; // Yuridik shaxslar ni soliq uzulish koeffitsientini beruvchi API

        }
    }


}
