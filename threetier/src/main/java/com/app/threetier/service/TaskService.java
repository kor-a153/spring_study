package com.app.threetier.service;

import com.app.threetier.domain.vo.TaskVO;
import com.app.threetier.mapper.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskMapper taskMapper;

    public void register (TaskVO taskVO) {
        taskMapper.insert(taskVO);
    }
}
