package com.kh.app06.member.service;

import java.util.Map;

public interface MemberService {
	
	int join(Map<String, String> map);
	
	Map<String, String> login(Map<String, String> map);
	
}
