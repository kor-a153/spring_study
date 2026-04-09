package com.app.threetier.mapper;

import com.app.threetier.domain.vo.TaskVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.scheduling.config.Task;

@Mapper
public interface TaskMapper {
    // 점수 등록
    public void insert (TaskVO taskvo);
}
