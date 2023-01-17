package com.tunadag.mapper;

import com.tunadag.dto.request.UserProfileSaveRequestDto;
import com.tunadag.repository.entity.UserProfile;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserProfileMapper {

    IUserProfileMapper INSTANCE = Mappers.getMapper(IUserProfileMapper.class);

    UserProfile fromUserProfileDto(final UserProfileSaveRequestDto dto);
}
