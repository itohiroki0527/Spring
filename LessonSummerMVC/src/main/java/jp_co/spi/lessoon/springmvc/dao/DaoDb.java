package jp_co.spi.lessoon.springmvc.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//DB取得用

import jp_co.spi.lesson.springmvc.form.aikotobaForm;

public class DaoDb {
	//パスとIDは定数で固定
	private static final String URL	= "jdbc:mysql://localhost/login?useSSL = false";
	private static final String USER = "root";
	private static final String PASS = "password";
//	public static  String SQL	="";

	//SQl文は引数で渡してあげる
	//一覧用メソッド
	public List<DtoDbBean> findAll(String name, String address, String tel, String sendname, String aikotoba, String message) {
		// DtoDbBeanのインスタンスの生成（List）
		List<DtoDbBean> productList = new ArrayList<DtoDbBean>();
		try{/**/
			Class.forName("com.mysql.jdbc.Driver");
			//SQLつないでる
			Connection conn =
				DriverManager.getConnection(URL, USER, PASS);
			System.out.println("DB接続");
			//insert文。?はカラムの数。?にnameやaddressを一旦格納している？
			String SQL = "insert into infomation values (?,?,?,?,?,?);";
			//先ほど作成したinsert文の中に?があるため、PreparedStatementを付けてあげる
				PreparedStatement ps = conn.prepareStatement(SQL);//{
				//ps.setStringで追加。番号,"nameとか"
				ps.setString(1,name );
				ps.setString(2,address );
				ps.setString(3,tel );
				ps.setString(4,sendname );
				ps.setString(5,message );
				ps.setString(6,aikotoba );
				//psにsetしたものをexecuteUpdateした。
				ps.executeUpdate();
			
				//各レコードの情報を取り出してはいれまくってる
		/*		while (rs.next()) {
					//Dtoインスタンス化
					System.out.println("DBに値を登録する");
					DtoDbBean sd = new DtoDbBean();
					
				sd.setName(rs.getString("name"));
					sd.setAddress(rs.getString("address"));
					sd.setTel(rs.getInt("tel"));
					sd.setFromname(rs.getString("fromname"));
					sd.setLastmessage(rs.getString("lastmessage"));
					sd.setPass(rs.getString("pass"));

//					sd.setName(rs.getString("pro_name"));
//					sd.setPrice(rs.getInt("pro_price"));
//					sd.setId(rs.getInt("pro_cd"));
					
					productList.add(sd);
					System.out.println("DBに入力された値が登録された");*/
				
			

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return productList;
	}

	public static  List<aikotobaForm> JDBC(String DBaikotoba) {
		
		//JDBCの接続で使う「url,id,pw」をそれぞれ中身を入れておく
		// ?useSSL = falseがあると動く？
		String url = "jdbc:mysql://localhost/login?useSSL = false";
		String id = "root";					//↑●書き換えるところ●データベース名
		String pw = "password";
		//「connection,Statement,ResultSet」各オブジェクトを変数定義しておく
		Connection cnct = null;
		Statement st = null;
		ResultSet rs = null;
		//リスト作成
		 List<aikotobaForm> aikotobaList = new ArrayList <aikotobaForm>();
		try {

			//JDBCドライバの登録
			Class.forName("com.mysql.jdbc.Driver");
			//MySQLへ接続（データベースまで）
			cnct = DriverManager.getConnection(url,id,pw);
			st = cnct.createStatement();
			//●書き換えるところ●SQL文の発行
			// 件数が増えてくると↓の方法だと時間がかかる場合があるので注意
			rs = st.executeQuery("SELECT * from information where pass = '"+ DBaikotoba +"' ;");

			//●書き換えるところ●while文にてitemテーブルのレコードをnextメソッドで回していく
			while(rs.next()){
				//getXXXメソッドを使い、userテーブル内のUSERID,PASSWORDをそれぞれname,priceに格納
			//インスタンス化
				aikotobaForm af =new aikotobaForm();
				//DBの値をあいことばフォームにsetしている
				af.setDbName(rs.getString("name"));
				af.setDbAdress(rs.getString("address"));
				af.setDbTel(rs.getString("tel"));
				
				af.setDbSendName(rs.getString("fromname"));
				af.setDbMessage(rs.getString("lastmessage"));
				af.setDbAikotoba(rs.getString("pass"));
				
				//追加
				aikotobaList.add(af);
				//【TEST】//ちゃんと値が出ているかテスト出力する
			//	System.out.println(aikotoba );
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
		return aikotobaList;
	}
	//詳細用メソッド
	
	
	/*
	public List<DtoDbBean> item(String SQL) {
		List<DtoDbBean> productList = new ArrayList<>();

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =
				DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement ps = conn.prepareStatement(SQL);//{

			try(ResultSet rs = ps.executeQuery()){
				while (rs.next()) {
				//rs.next();
					DtoDbBean sd = new DtoDbBean();
					sd.setId(rs.getInt("name"));
					sd.setName(rs.getString("address"));
					sd.setPrice(rs.getInt("tel"));
					sd.setMsg(rs.getString("fromname"));
					sd.setImg(rs.getString("pro_img"));
					sd.setStock(rs.getInt("stock_no"));
					productList.add(sd);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return productList;
	}


	//カート確認用メソッド  /*↓カート内の商品idをSQLで渡して商品名と単価を表示、数量は在庫と別の為別の指定を入れる
	public List<DtoDbBean> cart(String SQL) {
		List<DtoDbBean> productList = new ArrayList<>();

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =
				DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement ps = conn.prepareStatement(SQL);//{

			try(ResultSet rs = ps.executeQuery()){
				while (rs.next()) {
				//rs.next();
					DtoDbBean sd = new DtoDbBean();
					sd.setId(rs.getInt("pro_cd"));
					sd.setName(rs.getString("pro_name"));
					sd.setPrice(rs.getInt("pro_price"));
					productList.add(sd);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return productList;
	}

*/
	
}
