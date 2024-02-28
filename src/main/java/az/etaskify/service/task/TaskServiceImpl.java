package az.etaskify.service.task;

import az.etaskify.dto.request.task.TaskCreateRequestDto;
import az.etaskify.dto.request.task.TaskUpdateRequestDto;
import az.etaskify.dto.request.user.UsersListDto;
import az.etaskify.dto.response.task.TaskForUsersResponseDto;
import az.etaskify.dto.response.task.TaskResponseDto;
import az.etaskify.entity.task.Task;
import az.etaskify.entity.task.TaskStatus;
import az.etaskify.entity.user.User;
import az.etaskify.errors.ApplicationException;
import az.etaskify.errors.Errors;
import az.etaskify.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final ModelMapper modelMapper;

    @Override
    public TaskResponseDto findById(Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new ApplicationException(Errors.TASK_NOT_FOUND));
        return modelMapper.map(task, TaskResponseDto.class);
    }

    @Override
    public TaskResponseDto findTasksByOrganizationId(Long organizationId){
        List<Task> taskList = taskRepository.findTasksByOrganizationId(organizationId);
        List<TaskResponseDto> taskResponseDtos = new ArrayList<>();
        taskList.forEach(task ->
                taskResponseDtos.add(modelMapper.map(task, TaskResponseDto.class)));
        return (TaskResponseDto) taskResponseDtos;
    }

    @Override
    public TaskResponseDto findTasksByUserId(Long userId) {
        List<Task> taskList = taskRepository.findTasksByUserId(userId);
        List<TaskResponseDto> taskResponseDtos = new ArrayList<>();
        taskList.forEach(task ->
                taskResponseDtos.add(modelMapper.map(task, TaskResponseDto.class)));
        return (TaskResponseDto) taskResponseDtos;
    }

    @Override
    public TaskResponseDto create(TaskCreateRequestDto dto) {
        Task newTask = Task.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .deadline(dto.getDeadline())
                .createdAt(dto.getCreatedAt())
                .status(TaskStatus.NEW)
                .build();

        Task savedTask = taskRepository.save(newTask);
        return modelMapper.map(savedTask, TaskResponseDto.class);
    }

    @Override
    public TaskForUsersResponseDto assign(Long taskId, UsersListDto listsDto) {

        Task task = taskRepository.findById(taskId).orElseThrow(() -> new ApplicationException(Errors.TASK_NOT_FOUND));

        for (User user : listsDto.getUserList()) {
            user.getTasks().add(task);
        }

        TaskForUsersResponseDto taskForUsersResponseDto = modelMapper.map(task, TaskForUsersResponseDto.class);
        taskForUsersResponseDto.setUserList(listsDto.getUserList());
        return taskForUsersResponseDto;
    }

    @Override
    public TaskResponseDto update(Long taskId, TaskUpdateRequestDto dto) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new ApplicationException(Errors.TASK_NOT_FOUND));

        Task taskForUpdate = modelMapper.map(dto, Task.class);
        taskForUpdate.setId(taskId);
        return modelMapper.map(taskRepository.save(taskForUpdate), TaskResponseDto.class);
    }

    @Override
    public TaskResponseDto delete(Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new ApplicationException(Errors.TASK_NOT_FOUND));

        taskRepository.deleteById(taskId);
        return modelMapper.map(task, TaskResponseDto.class);
    }
}
