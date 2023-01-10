package com.tunadag.mapper;

import com.tunadag.dto.request.RegisterRequestDto;
import com.tunadag.dto.response.RegisterResponseDto;
import com.tunadag.repository.entity.Auth;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IAuthMapper {

    IAuthMapper INSTANCE = Mappers.getMapper(IAuthMapper.class);
    
    Auth fromRegisterRequestDto(final RegisterRequestDto dto);

    @Mappings({
            @Mapping(source = "id", target = "authid")
    })
    RegisterResponseDto fromAuth(final Auth auth);
}
