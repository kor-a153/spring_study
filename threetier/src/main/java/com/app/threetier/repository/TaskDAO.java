package com.app.threetier.repository;


import com.app.threetier.domain.vo.TaskVO;
import com.app.threetier.mapper.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TaskDAO {
    private final TaskMapper taskMapper;
    public void insert (TaskVO taskVO)  {TaskMapper.insert(TaskVO);}
}