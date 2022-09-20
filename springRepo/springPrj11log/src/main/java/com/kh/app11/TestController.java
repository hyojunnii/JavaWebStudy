package com.kh.app11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j //로거변수자동생성(롬복)
public class TestController {

	//private final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@GetMapping("test")
	@ResponseBody //return view로안함
	public String test() {
		log.trace("[트레이스] 로그 남기기 ~~");
		log.debug("[디버그] 로그 남기기 ~~");
		log.info("[인포] 로그 남기기 ~~");
		log.warn("[경고] 로그 남기기 !!");
		log.error("[에러] 로그 남기기 !!");
		return "test~";
	}
	
}
