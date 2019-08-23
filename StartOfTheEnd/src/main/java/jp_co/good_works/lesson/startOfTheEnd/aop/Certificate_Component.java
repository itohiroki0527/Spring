package jp_co.good_works.lesson.startOfTheEnd.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.WebContentGenerator;
//
import jp_co.good_works.lesson.startOfTheEnd.controller.no_cert.D_LoginController;

// AOPを行うための機能
@Aspect
@Component
public class Certificate_Component extends WebContentGenerator {
//checkAuthenticatedメソッド前に処理をインジェクションする
	@Around("execution(* jp_co.good_works.lesson.startOfTheEnd.controller.*.*(..))")
	public String checkAuthenticated(ProceedingJoinPoint joinPoint)throws Throwable {
		// loginControllerをAOPとして指定している。（クラスのファイルを指定しなければならない）
		// インスタンス化と同じようなもの
		D_LoginController loginController = getApplicationContext().getBean(D_LoginController.class);
		// loginControllerのisLiveメソッドの呼び出し。※isLiveにF3押したら分かる。loginクラスのisliveメソッドを呼んで、またloginクラスのisliveメソッドを呼ぶ。
		// ここで何してるか？loginが成功するか失敗するかの処理。
		if(!loginController.isLive()) {
			// trueだったらログイン成功
			// 指定したコントローラーに遷移する
			// joinPointはメソッドの呼び出しができる
			return (String) joinPoint.proceed();
		}
		// falthだったらlogin.jspに行く。
		return"redirect:/login";
	}
}
