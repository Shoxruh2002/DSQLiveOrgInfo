package uz.atm.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 03/08/22
 * Time: 16:34
 */
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class DataDto<T> {

    public T body;

    public AppErrorDto error;

    public boolean success;

    public Long total;

    public DataDto(boolean success) {
        this.success = success;
    }

    public DataDto(T body) {
        this.body = body;
        this.success = true;
    }

    public DataDto(AppErrorDto error) {
        this.error = error;
        this.success = false;
    }

    public DataDto(T body, Long totalCount) {
        this.body = body;
        this.success = true;
        this.total = totalCount;
    }
}
