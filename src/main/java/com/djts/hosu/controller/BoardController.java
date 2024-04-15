package com.djts.hosu.controller;

import com.djts.hosu.domain.BoardVO;
import com.djts.hosu.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
@Log4j2
public class BoardController {

    private final BoardService boardService;

    // 게시판 리스트 조회
    @GetMapping("/list")
    public void list(Model model){
        log.info("list................");

        List<BoardVO> list = boardService.list();
        log.info(list);

        model.addAttribute("list", list);
    }

    // 게시글 화면 조회 or 수정 화면 조회
    @GetMapping({"/{job}/{bno}"}) // value가 배열이다.
    public String read( // PathVariable인 경우, {bno}값이 계속 변하기 때문에, void를 쓰면, 그것.jsp..그것.jsp 계속 만들어야하니까 문자열로 처리
            @PathVariable(name = "job") String job,
            @PathVariable(name = "bno") Long bno, Model model ){// request된 {bno}를 Long bno에 바인딩함
        log.info("job: " + job);
        log.info("bno: " + bno);

        // read/modify 예외처리
        if((job.equals("read") || job.equals("modify")) ){
            throw new RuntimeException("Bad Request job");
        }

        BoardVO boardVO = boardService.get(bno); // 몇 번의 데이터를 가져와서

        log.info("boardVO: " + boardVO);

        model.addAttribute("vo", boardVO); // 몇 번의 데이터를 카트에 담아서

        return "/board/"+job; // 화면으로 뿌린다
    }

    @GetMapping("/register")
    public void register(){

    }

    @PostMapping("/register")
    public String registerPost(BoardVO boardVO, RedirectAttributes rttr){

        log.info("boardVO " + boardVO);

        Long bno = boardService.register(boardVO);

        rttr.addFlashAttribute("result", 123L);

        return "redirect:/board/list";
    }


    // 수정하기 화면 조회 -> 이렇게 만들어서 따로 controller를 2개를 둬도 되지만, 하나로 합칠 수 있다.
//    @GetMapping("/modify/{bno}")
//    public String modify(
//                        @PathVariable(name = "bno") Long bno, Model model
//    ){
//
//        log.info("bno: " + bno);
//
//        BoardVO boardVO = boardService.get(bno);
//
//        log.info("boardVO: " + boardVO);
//
//        model.addAttribute("vo", boardVO);
//
//        return "/board/modify";
//    }

}
