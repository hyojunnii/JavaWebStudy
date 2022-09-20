package com.kh.app09.member.vo;

import lombok.Data; 

//@ToString
//@Getter
//@Setter
//@NoArgsConstructor //기본생성자
//@AllArgsConstructor
//@RequiredArgsConstructor //final필드 받는 생성자
@Data
public class MemberVo {

	private String id;
	private String pwd;
	private String nick;
	
	
}
