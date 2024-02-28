package az.etaskify.controller;

import az.etaskify.dto.request.task.TaskCreateRequestDto;
import az.etaskify.dto.request.task.TaskUpdateRequestDto;
import az.etaskify.dto.request.user.UsersListDto;
import az.etaskify.dto.response.task.TaskForUsersResponseDto;
import az.etaskify.dto.response.task.TaskResponseDto;
import az.etaskify.service.task.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/tasks")
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskResponseDto> findById(@PathVariable Long taskId){
        return ResponseEntity.ok(taskService.findById(taskId));
    }

    @GetMapping("/{organizationId}")
    public ResponseEntity<TaskResponseDto> findTasksByOrganizationId(@PathVariable Long organizationId){
        return ResponseEntity.ok(taskService.findTasksByOrganizationId(organizationId));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<TaskResponseDto> findTasksByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(taskService.findTasksByOrganizationId(userId));
    }

    @PostMapping("/new")
    public ResponseEntity<TaskResponseDto> create(@RequestBody TaskCreateRequestDto dto) {
        return ResponseEntity.ok(taskService.create(dto));
    }

    @PutMapping("/{taskId}/users")
    public ResponseEntity<TaskForUsersResponseDto> assign(@PathVariable Long taskId,
                                                          @RequestBody UsersListDto listsDto) {
        return ResponseEntity.ok(taskService.assign(taskId, listsDto));
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<TaskResponseDto> update(@PathVariable Long taskId,
                                                  @RequestBody TaskUpdateRequestDto dto) {
        return ResponseEntity.ok(taskService.update(taskId, dto));
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<TaskResponseDto> delete(@PathVariable Long taskId) {
        return ResponseEntity.ok(taskService.delete(taskId));
    }
}
