package io.katharsis.resource.mock.repository;

import io.katharsis.queryParams.RequestParams;
import io.katharsis.repository.annotations.*;
import io.katharsis.resource.exception.ResourceNotFoundException;
import io.katharsis.resource.mock.models.Task;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@JsonApiResourceRepository(Task.class)
public class TaskRepository {

    private static final ConcurrentHashMap<Long, Task> THREAD_LOCAL_REPOSITORY = new ConcurrentHashMap<>();

    @JsonApiSave
    public <S extends Task> S save(S entity) {
        entity.setId((long) (THREAD_LOCAL_REPOSITORY.size() + 1));
        THREAD_LOCAL_REPOSITORY.put(entity.getId(), entity);

        return entity;
    }

    @JsonApiFindOne
    public Task findOne(Long aLong, RequestParams requestParams) {
        Task task = THREAD_LOCAL_REPOSITORY.get(aLong);
        if (task == null) {
            throw new ResourceNotFoundException("");
        }
        return task;
    }

    @JsonApiFindAll
    public Iterable<Task> findAll(RequestParams requestParams) {
        return THREAD_LOCAL_REPOSITORY.values()
            .stream()
            .filter(value -> contains(value, requestParams.getIds()))
            .collect(Collectors.toList());
    }

    private boolean contains(Task value, List<String> ids) {
        for (String id : ids) {
            if (value.getId().equals(Long.valueOf(id))) {
                return true;
            }
        }

        return false;
    }

    @JsonApiDelete
    public void delete(Long aLong) {
        THREAD_LOCAL_REPOSITORY.remove(aLong);
    }
}
