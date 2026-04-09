package com.app.threetier.service;


import com.app.threetier.domain.vo.TaskVO;
import com.app.threetier.repository.TaskDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class TaskServiceImpl {
    private final TaskDAO taskDAO;

    @Override
    public void register (TaskVO taskVO) {taskVO.insert(taskVO);}
}
