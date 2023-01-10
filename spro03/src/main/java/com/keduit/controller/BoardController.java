package com.keduit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.keduit.domain.BoardVO;
import com.keduit.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("-------------BoardController list---");
		model.addAttribute("list", service.getList());
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		
		log.info("-----------register ----" + board);
		Long bno = service.register(board);
		log.info("----------bno -----------" + bno);
		
		rttr.addFlashAttribute("result",bno); //addFlashAttribute : 회원가입 같은거 할때 뒤로가기 누르고 다시 돌아오면 작성한 것들이 저장되는데 저장되지 않게 하기 위해 사용 (도배방지용)
		
		
		return "redirect:/board/list";
	}
	
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("bno") Long bno, Model model) {
		log.info("/get or /modify");
		model.addAttribute("board", service.get(bno));
	}
	
	
	
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		log.info("----------controller  modify----------" + board);
		
		if(service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
			
		}
		
		return "redirect:/board/list";
		
	}
	
	@GetMapping("/register")
	public void register(){
		
	}
	
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		log.info("-------------------remove -----------" + bno);
		
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
		
		
		
		
	}
}
