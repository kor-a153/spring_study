package com.app.restful.service;

import com.app.restful.domain.vo.PostVO;

import java.util.List;

public class PostServiceImpl implements PostService {
    @Override
    public List<PostVO> getPostList(Long id) {
        return List.of();
    }

    @Override
    public void createPost(PostVO postVO) {

    }
}
