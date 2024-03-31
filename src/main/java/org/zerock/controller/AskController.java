package org.zerock.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.Criteria;
import org.zerock.domain.AskListPageDTO;
import org.zerock.service.AskListService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/ask/*")
@AllArgsConstructor
public class AskController { // 페이지의 분기를 담당한다.

	private AskListService service;

	@PreAuthorize("permitAll")
	@GetMapping("/write") // 글쓰기 페이지로 보내는 역할
	// @PreAuthorize("isAuthenticated()") 시큐리티
	public void write() {
		log.info("write 메서드 실행 ... ");
	} // get : localhost/ask/write -> write.jsp
	
	@PreAuthorize("permitAll")
	@GetMapping("/main") // 페이징사용, 첫 페이지를 보여준다.
	public void main(Criteria cri, Model model) {
		log.info("cri : " + cri);
		model.addAttribute("cri", cri);
	}
	
	@PreAuthorize("permitAll")
	@GetMapping({ "/get", "/modify" }) // 상세보기 또는 수정페이지로 이동..
	public String get(@RequestParam("no") Long ask_list_no, Model model) { // @ModelAttribute("cri") Criteria cri,
		log.info("get 또는 modify 경로 메서드 실행");
		if(service.checkLock(ask_list_no) == true) {
			return "ask/lock";
		}
		model.addAttribute("AskListVO", service.get(ask_list_no)); // 첨부파일 리스트도 같이있음
		return "ask/get";
	}
	
	@PreAuthorize("permitAll")
	@GetMapping("/lock")
	public void lock() {

	}

}
