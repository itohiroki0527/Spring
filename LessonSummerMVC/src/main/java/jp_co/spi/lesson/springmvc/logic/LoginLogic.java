package jp_co.spi.lesson.springmvc.logic;

import javax.security.auth.login.LoginException;

import jp_co.spi.lesson.springmvc.form.LoginForm;
import jp_co.spi.lessoon.springmvc.dao.UserDao;

public class LoginLogic {

	
	private LoginInfo loginInfo = null; //LoginForm �Ƃ͕ʂɍ쐬
	
	LoginForm loginForm = new LoginForm();
	
	/*���O�C�������s����*/
	// String userId, String password�͓��͂��ꂽID��PASS
	public LoginInfo login(String userId, String password)throws LoginException {
		UserDao dao = new UserDao();
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
			loginInfo = new LoginInfo();
			loginInfo.setUserId(userId);
			loginInfo.setPassword(password);
			return loginInfo;
		}else {
			// �Ԉ����ID��PASS�������Ƃ��͂�����B
			// LoginException�Ƀ��[�U�[�`�̕��͂��Ƃ�
		throw new LoginException("���[�U�[ID�܂��̓p�X���[�h���Ⴂ�܂��B");
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
