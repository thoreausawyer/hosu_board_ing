package com.djts.hosu.service;

import com.djts.hosu.domain.BoardVO;
import com.djts.hosu.mappers.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j2
@RequiredArgsConstructor // 생성자 생성 방법 2 // 쉬움 Lombok 짱
@Transactional // 트랜잭션 걸어주고 가는게 좋음
public class BoardService {

    // 의존성 주입 // BoardMapper가 필요합니다. // 생성자는 "너 이렇게 안하면 객체 못 만들어" 라는 제한
    private final BoardMapper boardMapper;

    public Long register(BoardVO boardVO){

        log.info("--------------"+ boardVO);

        int count = boardMapper.insert(boardVO);

        return boardVO.getBno(); // 등록 성공 시 bno 값을 Long으로 던져줌

    }

    public java.util.List<BoardVO> list() {

        return boardMapper.getList();

    }

    public BoardVO get(Long bno) { // bno 전달해주면(request) mapper에서 값을 가지고(response) 나온다

        return boardMapper.select(bno);
    }

    public boolean modify(BoardVO vo){

        return boardMapper.update(vo) == 1; // 업데이트 성공 시 반환 1 (true)
    }

    public boolean remove(Long bno) {
        return true; // mapper 메서드 아직 안 만듦.
    }

}
