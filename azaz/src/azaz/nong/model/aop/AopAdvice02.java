package azaz.nong.model.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
public class AopAdvice02 {
	
	
	@Around("execution(public * azaz.nong.model..logon_*(..))")
	public Object around(ProceedingJoinPoint jp) throws Throwable{
		
		//request ��ü ��� ���
		RequestAttributes ra = RequestContextHolder.currentRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes)ra;	//request , response ��ü�� �ش�.
		
		HttpServletRequest request = sra.getRequest();
		HttpSession session = request.getSession();
		
		
		System.out.println(request.getRequestURI());

		Object view = "user/error";
		if(session != null) {
			if(session.getAttribute("memId") != null) {
				view =  jp.proceed();	//�������� �̵�
			}
		}
		return view;
	}
	
	/*
	 * @Before("execution(public * spring.model..main())") public void before() {
	 * System.out.println("before"); }
	 * 
	 * @After("execution(public * spring.model..main())") public void after() {
	 * System.out.println("after"); }
	 */
}
