package com.app.yanawa.mapper.freewrite;


import com.app.yanawa.domain.freewrite.FreewriteDTO;
import com.app.yanawa.domain.freewrite.FreewriteVO;
import com.app.yanawa.domain.freewrite.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FreewriteMapper {
    public void insert(FreewriteVO freewriteVO);

    public List<FreewriteDTO> selectAll(@Param("pagination") Pagination pagination,@Param("order") String order);

    public int selectTotal();


}
