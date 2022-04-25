package main;

import chap01print.PrintTest;
import chap02var.VarTest;
import chap03oper.OperTest;

public class Main {

	public static void main(String[] args) {

		PrintTest pt = new PrintTest();
		
		pt.test();
//		pt.test2();
		
		VarTest vt = new VarTest();
		
//		vt.test();
		vt.test2();
		vt.test3();
		vt.test4();
		
		OperTest ot = new OperTest();
		
		ot.test();
		ot.test2();
		ot.test3();
		ot.test4();
		
	}

}
