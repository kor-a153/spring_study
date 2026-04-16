package com.app.restful.service;

import com.app.restful.domain.dto.PostDTO;
import com.app.restful.domain.vo.PostVO;

import java.util.List;

public interface PostService {

    public List<PostVO> getPostList(Long id);


    public void createPost(PostVO postVO);

    PostDTO modifyPost();
}
