package jp_co.spi.lessoon.springmvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {
	// user_id��user_pass��null�Œ�`�������Ă����Btry��while�̒��Œ�`����Ă�����̂�
	// public�����Ă����Ȃ���loginlogic�Ŏg���Ȃ��̂ł��Ă���
	public static String user_id = null;
	public static String user_pass = null;

	public static  void JDBC(String loginid) {
		//JDBC�̐ڑ��Ŏg���uurl,id,pw�v�����ꂼ�ꒆ�g�����Ă���
		// ?useSSL = false������Ɠ����H
		String url = "jdbc:mysql://localhost/login?useSSL = false";
		String id = "root";					//��������������Ƃ��끜�f�[�^�x�[�X��
		String pw = "password";
		//�uconnection,Statement,ResultSet�v�e�I�u�W�F�N�g��ϐ���`���Ă���
		Connection cnct = null;
		Statement st = null;
		ResultSet rs = null;
		try {

			//JDBC�h���C�o�̓o�^
			Class.forName("com.mysql.jdbc.Driver");
			//MySQL�֐ڑ��i�f�[�^�x�[�X�܂Łj
			cnct = DriverManager.getConnection(url,id,pw);
			st = cnct.createStatement();
			//������������Ƃ��끜SQL���̔��s
			// �����������Ă���Ɓ��̕��@���Ǝ��Ԃ�������ꍇ������̂Œ���
			rs = st.executeQuery("SELECT * from user where USERID = '"+ loginid +"' ;");
			//������������Ƃ��끜while���ɂ�item�e�[�u���̃��R�[�h��next���\�b�h�ŉ񂵂Ă���
			while(rs.next()){
				//getXXX���\�b�h���g���Auser�e�[�u������USERID,PASSWORD�����ꂼ��name,price�Ɋi�[
				user_id = rs.getString("USERID");
				user_pass = rs.getString("PASSWORD");
				//�yTEST�z//�����ƒl���o�Ă��邩�e�X�g�o�͂���
				System.out.println(user_id );
				System.out.println(user_pass );
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
	}

}
