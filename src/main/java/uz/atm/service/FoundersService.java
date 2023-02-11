package uz.atm.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import uz.atm.dto.DataDto;
import uz.atm.entity.faunders.Founders;
import uz.atm.repository.FoundersRepository;
import uz.atm.service.caller.DSQCaller;

import java.util.List;

/**
 * @author Shoxruh Bekpulatov
 * Time : 11/02/23
 */
@Slf4j
@Service
public class FoundersService {

    private final FoundersRepository foundersRepository;
    private final DSQCaller dsqCaller;

    public FoundersService( FoundersRepository foundersRepository, DSQCaller dsqCaller ) {
        this.foundersRepository = foundersRepository;
        this.dsqCaller = dsqCaller;
    }


    public DataDto<List<Founders>> getFounders( String tin ) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("tin", tin);
        DataDto<List<Founders>> dataDto = dsqCaller.getCall(params, "/minfin2/api/get/founders-by-tin", new ParameterizedTypeReference<>() {
        });
        if ( !dataDto.success ) {
            dsqCaller.loginCall();
            dataDto = dsqCaller.getCall(params, "minfin2/api/get/founders-by-tin", new ParameterizedTypeReference<>() {
            });
        }
        if ( dataDto.success )
            foundersRepository.saveAll(dataDto.body);

        return dataDto;
    }

    public List<Founders> saveAll( List<Founders> list ) {
        return foundersRepository.saveAll(list);
    }
}
