package jp_co.spi.lessoon.springmvc.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//DB�擾�p

import jp_co.spi.lesson.springmvc.form.aikotobaForm;

public class DaoDb {
	//�p�X��ID�͒萔�ŌŒ�
	private static final String URL	= "jdbc:mysql://localhost/login?useSSL = false";
	private static final String USER = "root";
	private static final String PASS = "password";
//	public static  String SQL	="";

	//SQl���͈����œn���Ă�����
	//�ꗗ�p���\�b�h
	public List<DtoDbBean> findAll(String name, String address, String tel, String sendname, String aikotoba, String message) {
		// DtoDbBean�̃C���X�^���X�̐����iList�j
		List<DtoDbBean> productList = new ArrayList<DtoDbBean>();
		try{/**/
			Class.forName("com.mysql.jdbc.Driver");
			//SQL�Ȃ��ł�
			Connection conn =
				DriverManager.getConnection(URL, USER, PASS);
			System.out.println("DB�ڑ�");
			//insert���B?�̓J�����̐��B?��name��address����U�i�[���Ă���H
			String SQL = "insert into infomation values (?,?,?,?,?,?);";
			//��قǍ쐬����insert���̒���?�����邽�߁APreparedStatement��t���Ă�����
				PreparedStatement ps = conn.prepareStatement(SQL);//{
				//ps.setString�Œǉ��B�ԍ�,"name�Ƃ�"
				ps.setString(1,name );
				ps.setString(2,address );
				ps.setString(3,tel );
				ps.setString(4,sendname );
				ps.setString(5,message );
				ps.setString(6,aikotoba );
				//ps��set�������̂�executeUpdate�����B
				ps.executeUpdate();
			
				//�e���R�[�h�̏������o���Ă͂���܂����Ă�
		/*		while (rs.next()) {
					//Dto�C���X�^���X��
					System.out.println("DB�ɒl��o�^����");
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
					System.out.println("DB�ɓ��͂��ꂽ�l���o�^���ꂽ");*/
				
			

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return productList;
	}

	public static  List<aikotobaForm> JDBC(String DBaikotoba) {
		
		//JDBC�̐ڑ��Ŏg���uurl,id,pw�v�����ꂼ�ꒆ�g�����Ă���
		// ?useSSL = false������Ɠ����H
		String url = "jdbc:mysql://localhost/login?useSSL = false";
		String id = "root";					//��������������Ƃ��끜�f�[�^�x�[�X��
		String pw = "password";
		//�uconnection,Statement,ResultSet�v�e�I�u�W�F�N�g��ϐ���`���Ă���
		Connection cnct = null;
		Statement st = null;
		ResultSet rs = null;
		//���X�g�쐬
		 List<aikotobaForm> aikotobaList = new ArrayList <aikotobaForm>();
		try {

			//JDBC�h���C�o�̓o�^
			Class.forName("com.mysql.jdbc.Driver");
			//MySQL�֐ڑ��i�f�[�^�x�[�X�܂Łj
			cnct = DriverManager.getConnection(url,id,pw);
			st = cnct.createStatement();
			//������������Ƃ��끜SQL���̔��s
			// �����������Ă���Ɓ��̕��@���Ǝ��Ԃ�������ꍇ������̂Œ���
			rs = st.executeQuery("SELECT * from information where pass = '"+ DBaikotoba +"' ;");

			//������������Ƃ��끜while���ɂ�item�e�[�u���̃��R�[�h��next���\�b�h�ŉ񂵂Ă���
			while(rs.next()){
				//getXXX���\�b�h���g���Auser�e�[�u������USERID,PASSWORD�����ꂼ��name,price�Ɋi�[
			//�C���X�^���X��
				aikotobaForm af =new aikotobaForm();
				//DB�̒l���������Ƃ΃t�H�[����set���Ă���
				af.setDbName(rs.getString("name"));
				af.setDbAdress(rs.getString("address"));
				af.setDbTel(rs.getString("tel"));
				
				af.setDbSendName(rs.getString("fromname"));
				af.setDbMessage(rs.getString("lastmessage"));
				af.setDbAikotoba(rs.getString("pass"));
				
				//�ǉ�
				aikotobaList.add(af);
				//�yTEST�z//�����ƒl���o�Ă��邩�e�X�g�o�͂���
			//	System.out.println(aikotoba );
			}
			// ��O�����B�w�肳�ꂽ���O�̃N���X�̒�`��������Ȃ������ꍇ�AprintStackTrace�ŃR���\�[���ɕ\�������B
		} catch(ClassNotFoundException ex){
			ex.printStackTrace();
			// SQL�̃G���[���������Ƃ��AprintStackTrace�ŃR���\�[���ɕ\�������B
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				//JDBC�̉���
				if (rs!=null) rs.close();
				if (st!=null) st.close();
				if (cnct!=null) cnct.close();
				// Exception
			} catch(Exception ex) {
			}
		}
		return aikotobaList;
	}
	//�ڍחp���\�b�h
	
	
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


	//�J�[�g�m�F�p���\�b�h  /*���J�[�g���̏��iid��SQL�œn���ď��i���ƒP����\���A���ʂ͍݌ɂƕʂ̈וʂ̎w�������
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
