package az.etaskify.service.task;

import az.etaskify.dto.request.task.TaskCreateRequestDto;
import az.etaskify.dto.request.task.TaskUpdateRequestDto;
import az.etaskify.dto.request.user.UsersListDto;
import az.etaskify.dto.response.task.TaskForUsersResponseDto;
import az.etaskify.dto.response.task.TaskResponseDto;

public interface TaskService {

    TaskResponseDto findById(Long taskId);

    TaskResponseDto findTasksByOrganizationId(Long organizationId);

    TaskResponseDto findTasksByUserId(Long userId);

    TaskResponseDto create(TaskCreateRequestDto dto);

    TaskForUsersResponseDto assign(Long taskId, UsersListDto listsDto);

    TaskResponseDto update(Long taskId, TaskUpdateRequestDto dto);

    TaskResponseDto delete(Long taskId);
}
