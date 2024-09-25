package com.app.yanawa.repository.post;

import com.app.yanawa.domain.post.PostVO;
import com.app.yanawa.mapper.post.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PostDAO {
    private final PostMapper postMapper;

    public void save(PostVO postVO) {postMapper.insert(postVO);}
}
