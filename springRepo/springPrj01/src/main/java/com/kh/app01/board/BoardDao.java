package com.kh.app01.board;

import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {

	public int write() {
		System.out.println("board 다오 호출됨..");
		return 1;
	}

}
