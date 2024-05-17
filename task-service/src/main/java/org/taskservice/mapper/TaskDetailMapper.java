package org.taskservice.mapper;

import org.mapstruct.*;
import org.taskservice.dto.TaskDetailDto;
import org.taskservice.dto.TaskDto;
import org.taskservice.dto.UserDto;
import org.taskservice.enitity.TaskDetail;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskDetailMapper {
    TaskDetail toEntity(TaskDetailDto taskDetailDto);

    TaskDetailDto toDto(TaskDetail taskDetail);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TaskDetail partialUpdate(TaskDetailDto taskDetailDto, @MappingTarget TaskDetail taskDetail);
}