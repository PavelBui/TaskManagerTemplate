package com.epam.learning.repository;

import com.epam.learning.entity.TaskUserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskUserRepository extends CrudRepository<TaskUserEntity, Integer> {

    Optional<TaskUserEntity> findByIdAndIsDeletedFalse(Integer id);

    List<TaskUserEntity> findAllByUserIdAndIsDeletedFalse(Integer id);

}
