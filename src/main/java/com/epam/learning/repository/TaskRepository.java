package com.epam.learning.repository;

import com.epam.learning.entity.TaskEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends CrudRepository<TaskEntity, Integer> {

    Optional<TaskEntity> findByIdAndIsDeletedFalse(Integer id);

    List<TaskEntity> findAllByIsDeletedFalse();

    List<TaskEntity> findAllByUserIdAndIsDeletedFalse(Integer id);

}
