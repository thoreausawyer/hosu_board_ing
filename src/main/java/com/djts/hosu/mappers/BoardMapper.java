package com.djts.hosu.mappers;

import com.djts.hosu.domain.BoardVO;

public interface BoardMapper {

    java.util.List<BoardVO> getList();

    int insert(BoardVO boardVO); // insert 할 때 DML은 int 타입이다. (DML ex)insert,update,delete)

    BoardVO select(Long bno);

    int update(BoardVO boardVO);

    // 게시글 삭제는 -> 내용물을 '삭제되었습니다.' 로 수정 해주는 게 낫고,
    //             -> column을 하나 둬서 Y/N 처리 해서 숨김 처리 하는 게 낫다. 왜? 외래키(foreign key)를 물고 있는 경우가 많아서.

}
