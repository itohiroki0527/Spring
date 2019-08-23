package jp_co.good_works.lesson.startOfTheEnd.logic;

import javax.security.auth.login.LoginException;

import jp_co.good_works.lesson.startOfTheEnd.dao.D_User_Dao;
import jp_co.good_works.lesson.startOfTheEnd.exception.D_Login_Exception;
import jp_co.good_works.lesson.startOfTheEnd.form.D_Login_Form;

public class D_Login_Logic {

	
	private D_Login_Info loginInfo = null; //LoginForm とは別に作成
	
//	D_Login_Form loginForm = new D_Login_Form();
	
	/*ログインを実行する*/
	// String userId, String passwordは入力されたIDとPASS
	public D_Login_Info D_login(String userId, String password)throws D_Login_Exception {
		D_User_Dao dao = new D_User_Dao();
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
			loginInfo = new D_Login_Info();
			loginInfo.setUserId(userId);
			loginInfo.setPassword(password);
			return loginInfo;
		}else {
			// 間違ったIDとPASSだったときはこちら。
			// LoginExceptionにユーザー～の文章がとぶ
		throw new D_Login_Exception("ユーザーIDまたはパスワードが違います。");
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
