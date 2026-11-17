package com.klu.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klu.springmvc.model.Task;

@Repository
public interface Task_repo extends JpaRepository<Task,Integer>{

}
