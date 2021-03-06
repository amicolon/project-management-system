package com.amicolon.converters;

import com.amicolon.commands.TaskCommand;
import com.amicolon.domain.Task;
import com.amicolon.services.middlewares.CategoryService;
import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;

@Component
public class TaskCommandToTask implements Converter<TaskCommand, Task>
{

	private final CategoryService categoryService;

	@Autowired
	public TaskCommandToTask(CategoryService categoryService)
	{
		this.categoryService = categoryService;
	}

	@Override
	@Synchronized
	@Nullable
	public Task convert(TaskCommand source)
	{
		if (source == null) {
			return null;
		}

		return Task.builder()
				.id(source.getId())
				.title(source.getTitle())
				.description(source.getDescription())
				.startDate(source.getStartDate())
				.finishDate(LocalDate.parse(source.getFinishDate(), ISO_LOCAL_DATE))
				.priority(source.getPriority())
				.state(source.getState())
				.category(categoryService.findCategoryById(source.getCategoryId()))
				.build();

	}

}
