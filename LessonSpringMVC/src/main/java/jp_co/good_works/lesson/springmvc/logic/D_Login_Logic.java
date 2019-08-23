package jp_co.good_works.lesson.springmvc.logic;


import jp_co.good_works.lesson.springmvc.exception.D_Login_Exception;
import jp_co.good_works.lesson.springmvc.form.D_Login_Form;

import jp_co.good_works.lessoon.springmvc.dao.D_User_Dao;

public class D_Login_Logic {

	
	private D_Login_Info loginInfo = null; //LoginForm �Ƃ͕ʂɍ쐬
	
	D_Login_Form loginForm = new D_Login_Form();
	
	/*���O�C�������s����*/
	// String userId, String password�͓��͂��ꂽID��PASS
	public D_Login_Info D_login(String userId, String password)throws D_Login_Exception {
		D_User_Dao dao = new D_User_Dao();
		// UserDao��JDBC���\�b�h�𗘗p���邽��dao.JDBC();��p�ӂ���B
		// �����ł���userId�͏��String userId�Ɗ֌W���Ă���
		// JSP�œ��͂��ꂽ�l������
		dao.JDBC(userId);
		// 	�F�؃��W�b�N�͊ȈՓI�ł悢�B
		//     ��guest/ guestguest �̏ꍇ�͔F�� OK �Ƃ���B
		String x = dao.user_id;
		String y = dao.user_pass;
		// 	�F�� OK �̏ꍇ�A�ϐ� loginInfo ���C���X�^���X�����F�؏��
		// 	���i�[���ĕԋp����B
		// 	�F�� NG �̏ꍇ�A��O�𔭍s����B
		
		if((userId.equals(x))&&(password.equals(y))) {
			loginInfo = new D_Login_Info();
			loginInfo.setUserId(userId);
			loginInfo.setPassword(password);
			return loginInfo;
		}else {
			// �Ԉ����ID��PASS�������Ƃ��͂�����B
			// LoginException�Ƀ��[�U�[�`�̕��͂��Ƃ�
		throw new D_Login_Exception("���[�U�[ID�܂��̓p�X���[�h���Ⴂ�܂��B");
		}
		
	}
	/* ���O�C���ς݂��ǂ������m�F���� */
	public boolean isLive() {
		// loginInfo���C���X�^���X������Ă����true��ԋp����
		if(loginInfo!=null) {
			return true;
		}else{
			return false;
		}
	}
}
