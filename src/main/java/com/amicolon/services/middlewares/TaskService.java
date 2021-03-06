package com.amicolon.services.middlewares;

import com.amicolon.commands.TaskCommand;
import com.amicolon.domain.Task;

public interface TaskService
{
	Task findTaskById(Long id);

	void deleteTaskByIdFromGivenCategoryWithId(Long categoryId, Long taskId);

	void persistTaskInDatabaseUsingTaskCommand(TaskCommand taskCommand);

	TaskCommand obtainTaskCommandById(Long id);

	void finishTaskByIdFromGivenCategoryWithId(Long categoryId, Long taskId);
}
