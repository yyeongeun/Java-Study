package org.example.board.controller;

import ch.qos.logback.core.model.Model;
import org.example.board.dto.User1DTO;
import org.example.board.service.User1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class User1Controller {

    @Autowired
    private User1Service user1Service;

    @GetMapping("/user1/register")
    public String register(){
        return "/user1/register";
    }

    // 클라이언트(http) ---> 서버 ---> 데이터베이스에 저장
    @PostMapping("/user1/register")
    public String register(User1DTO user1DTO){
        System.out.println(user1DTO);

        user1Service.insertUser1(user1DTO);

        // 리다이렉트
        return "redirect:/user1/register";
    }

    @GetMapping("/user1/list")
    public String list(Model model){

        // 목록 요청
        List<User1DTO> user1List = user1Service.selectAllUser1();

        // 모델 참조 - View(Html)에서 Controller 데이터를 참조하기 위한 처리
        model.addAttribute("user1List", user1List);

        // 페이지 출력(포워드)
        return "/user1/list";
    }
    @GetMapping("/user1/modify")
    public String modify(int no, Model model){ // no 파라미터 수신

        System.out.println("no : "+ no);

        User1DTO user1DTO =

        return "/user1/modify";
    }

}
