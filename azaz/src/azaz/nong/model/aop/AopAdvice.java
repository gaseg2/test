package azaz.nong.model.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class AopAdvice {

	public void test() {
		System.out.println("aop advice run");
	}
	
	public void after() {
		System.out.println("aop after");
	}
	
	// 타겟 전 / 후 동작
	public Object around(ProceedingJoinPoint jp) throws Throwable {
		jp.proceed();	// mvc 흐름을 이어준다. // main.do 호출 한다.
		return "1214/test";
	}
	
}
