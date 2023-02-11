package uz.atm.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import uz.atm.dto.AppErrorDto;
import uz.atm.dto.DataDto;
import uz.atm.entity.juridicInfo.JuridicInfo;
import uz.atm.repository.JuridicInfoRepository;
import uz.atm.service.caller.DSQCaller;

/**
 * @author Shoxruh Bekpulatov
 * Time : 11/02/23
 */
@Service
public class JuridicInfoService {

    private final JuridicInfoRepository juridicInfoRepository;
    private final DSQCaller dsqCaller;

    public JuridicInfoService( JuridicInfoRepository juridicInfoRepository, DSQCaller dsqCaller ) {
        this.juridicInfoRepository = juridicInfoRepository;
        this.dsqCaller = dsqCaller;
    }

    public DataDto<JuridicInfo> getJuridicEntityInfo( Long tin ) {
        if ( tin.toString().length() != 9 )
            return new DataDto<>(new AppErrorDto("Tin must be contains 9 numbers", HttpStatus.BAD_REQUEST));
        String endpoint = "/minfin2/finance/get-company";
        LinkedMultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("tin", tin.toString());
        DataDto<JuridicInfo> response = dsqCaller.getCall(params, endpoint, JuridicInfo.class);
        if ( !response.success ) {
            dsqCaller.loginCall();
            response = dsqCaller.getCall(params, endpoint, JuridicInfo.class);
        }
        if ( response.success )
            juridicInfoRepository.save(response.body);
        return response;
    }

    public JuridicInfo save( JuridicInfo juridicInfo ) {
        return juridicInfoRepository.save(juridicInfo);
    }
}
