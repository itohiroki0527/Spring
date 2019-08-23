package jp_co.spi.lesson.springmvc.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.WebContentGenerator;

import jp_co.spi.lesson.springmvc.controller.no_cert.LoginController;

// AOP���s�����߂̋@�\
@Aspect
// ��ʑJ�ڂ̐���
@Component
// WebContentGenerator���p���BWebContentGenerator���āH
// 
public class Certificate_Component extends WebContentGenerator {
//checkAuthenticated���\�b�h�O�ɏ������C���W�F�N�V��������
	@Around("execution(* jp_co.spi.lesson.springmvc.controller.*.*(..))")
	// 
	public String checkAuthenticated(ProceedingJoinPoint joinPoint)throws Throwable {
		// loginController��AOP�Ƃ��Ďw�肵�Ă���B�i�N���X�̃t�@�C�����w�肵�Ȃ���΂Ȃ�Ȃ��j
		// �C���X�^���X���Ɠ����悤�Ȃ���
		LoginController loginController = getApplicationContext().getBean(LoginController.class);
		// loginController��isLive���\�b�h�̌Ăяo���B��isLive��F3�������番����Blogin�N���X��islive���\�b�h���Ă�ŁA�܂�login�N���X��islive���\�b�h���ĂԁB
		// �����ŉ����Ă邩�Hlogin���������邩���s���邩�̏����B
		if(loginController.isLive()) {
			// true�������烍�O�C������
			// �w�肵���R���g���[���[�ɑJ�ڂ���
			// joinPoint�̓��\�b�h�̌Ăяo�����ł���
			return (String) joinPoint.proceed();
		}
		// falth��������login.jsp�ɍs���B
		return"redirect:/login";
	}
}
