package com.app.yanawa.mapper.post;

import com.app.yanawa.domain.post.PostVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {
    public void insert(PostVO postvo);
}
