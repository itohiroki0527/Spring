package jp_co.spi.lesson.springmvc.logic;

import javax.security.auth.login.LoginException;

import jp_co.spi.lesson.springmvc.form.LoginForm;
import jp_co.spi.lessoon.springmvc.dao.UserDao;

public class LoginLogic {

	
	private LoginInfo loginInfo = null; //LoginForm とは別に作成
	
	LoginForm loginForm = new LoginForm();
	
	/*ログインを実行する*/
	// String userId, String passwordは入力されたIDとPASS
	public LoginInfo login(String userId, String password)throws LoginException {
		UserDao dao = new UserDao();
		// UserDaoのJDBCメソッドを利用するためdao.JDBC();を用意する。
		// 引数であるuserIdは上のString userIdと関係している
		// JSPで入力された値がある
		dao.JDBC(userId);
		// 	認証ロジックは簡易的でよい。
		//     ※guest/ guestguest の場合は認証 OK とする。
		String x = dao.user_id;
		String y = dao.user_pass;
		// 	認証 OK の場合、変数 loginInfo をインスタンス化し認証情報
		// 	を格納して返却する。
		// 	認証 NG の場合、例外を発行する。
		
		if((userId.equals(x))&&(password.equals(y))) {
			loginInfo = new LoginInfo();
			loginInfo.setUserId(userId);
			loginInfo.setPassword(password);
			return loginInfo;
		}else {
			// 間違ったIDとPASSだったときはこちら。
			// LoginExceptionにユーザー～の文章がとぶ
		throw new LoginException("ユーザーIDまたはパスワードが違います。");
		}
		
	}
	/* ログイン済みかどうかを確認する */
	public boolean isLive() {
		// loginInfoがインスタンス化されていればtrueを返却する
		if(loginInfo!=null) {
			return true;
		}else{
			return false;
		}
	}
}
