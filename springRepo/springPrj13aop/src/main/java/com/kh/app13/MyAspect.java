package com.kh.app13;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@EnableAspectJAutoProxy
@Component
@Aspect
public class MyAspect {
	
	/*
	 * Before : 타겟 실행 전
	 * After : 타겟 실행 후 (예외상관없음)
	 * AfterReturning : 타겟 실행 후 (예외없을때만)
	 * AfterThrowing : 타겟 실행 후 (예외발생시)
	 * Around : 전, 후 모두 //메소드 형태 지정 (파라미터, 예외)
	 */
	//@Before("target(com.kh.app13.member.service.MemberServiceImpl)")
	//@After("target(com.kh.app13.member.service.MemberServiceImpl)")
	//@AfterReturning("target(com.kh.app13.member.service.MemberServiceImpl)")
	//@Around("target(com.kh.app13.member.service.MemberServiceImpl)")
	public Object MyAdvice(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("충고할게요 ~");
		//Object[] oarr = jp.getArgs();
		System.out.println(jp.getSignature().toShortString());
		System.out.println(jp.getSignature().toString());
		System.out.println(jp.getSignature().toLongString());
		Object result = jp.proceed();
		System.out.println("충고했어요 ~");
		return result;
	}
	
	//target : 해당 클래스, 상위타입 인터페이스의 메소드
	//@Around("target(com.kh.app13.member.dao.MemberDaoImpl)")
	//@Around("target(com.kh.app13.member.dao.MemberDao)")
	
	//within : 특정 패키지 || 특정 클래스의 모든 메소드 (인터페이스 X)
	//@Around("within(com.kh.app13.member.dao.MemberDaoImpl)")
	//@Around("within(com.kh.app13.member.dao.*)")
	//@Around("within(com..*)")
	
	//execution : 표현식 사용 
	//@Around("execution(표현식)")
    //@Around("execution(public int com.kh.app13.member.dao.MemberDaoImpl.join(String, String))")
    //@Around("execution(public * com.kh.app13.member.dao.MemberDaoImpl.join(String, String))")   //리턴타입 무관
    //@Around("execution(public java.lang.String com.kh.app13.member.dao.MemberDaoImpl.join(String, String))")
    //@Around("execution(public int com.kh.app13.member.dao.MemberDaoImpl.join(String, int))")
    //@Around("execution(public int com.kh.app13.member.dao.MemberDaoImpl.join(..))")   //매개변수 갯수 상관 X
    //@Around("execution(public int com.kh.app13.member.dao.MemberDaoImpl.j*(String, String))")   //메소드 이름이 j 로 시작하는
    //@Around("execution(public int com.kh.app13.member.dao.MemberDaoImpl.*n(String, String))")   //메소드 이름이 j 로 끝나는
    //@Around("execution(public int com.kh.app13.member.dao.MemberDaoImpl.*(String, String))")   //메소드 이름 상관 X
    //@Around("execution(public * com.kh.app13.member.dao.*.*(..))")   //해당 패키지 내 모든 메소드
    //@Around("execution(public * com..*.*(..))")   //com 패키지 내 모든 메소드
    @Around("execution(* com..*.*(..))")   //com 패키지 내 모든 메소드
	public Object timeAdvice(ProceedingJoinPoint jp) throws Throwable {
		long a = System.nanoTime();
		Object resultObj = jp.proceed();
		long b = System.nanoTime();
		long result = b - a;
		System.out.println("시간 :: " + result);
		//log.trace("경과시간 : " + result);
		return resultObj;
	}
}//class
