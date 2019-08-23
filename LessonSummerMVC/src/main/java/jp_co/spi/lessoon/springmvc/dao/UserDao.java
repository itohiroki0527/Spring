package jp_co.spi.lessoon.springmvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {
	// user_idとuser_passはnullで定義だけしておく。tryやwhileの中で定義されているものを
	// publicをつけてあげないとloginlogicで使えないのでつけておく
	public static String user_id = null;
	public static String user_pass = null;

	public static  void JDBC(String loginid) {
		//JDBCの接続で使う「url,id,pw」をそれぞれ中身を入れておく
		// ?useSSL = falseがあると動く？
		String url = "jdbc:mysql://localhost/login?useSSL = false";
		String id = "root";					//↑●書き換えるところ●データベース名
		String pw = "password";
		//「connection,Statement,ResultSet」各オブジェクトを変数定義しておく
		Connection cnct = null;
		Statement st = null;
		ResultSet rs = null;
		try {

			//JDBCドライバの登録
			Class.forName("com.mysql.jdbc.Driver");
			//MySQLへ接続（データベースまで）
			cnct = DriverManager.getConnection(url,id,pw);
			st = cnct.createStatement();
			//●書き換えるところ●SQL文の発行
			// 件数が増えてくると↓の方法だと時間がかかる場合があるので注意
			rs = st.executeQuery("SELECT * from user where USERID = '"+ loginid +"' ;");
			//●書き換えるところ●while文にてitemテーブルのレコードをnextメソッドで回していく
			while(rs.next()){
				//getXXXメソッドを使い、userテーブル内のUSERID,PASSWORDをそれぞれname,priceに格納
				user_id = rs.getString("USERID");
				user_pass = rs.getString("PASSWORD");
				//【TEST】//ちゃんと値が出ているかテスト出力する
				System.out.println(user_id );
				System.out.println(user_pass );
			}
			// 例外処理。指定された名前のクラスの定義が見つからなかった場合、printStackTraceでコンソールに表示される。
		} catch(ClassNotFoundException ex){
			ex.printStackTrace();
			// SQLのエラーがあったとき、printStackTraceでコンソールに表示される。
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				//JDBCの解除
				if (rs!=null) rs.close();
				if (st!=null) st.close();
				if (cnct!=null) cnct.close();
				// Exception
			} catch(Exception ex) {
			}
		}
	}

}
