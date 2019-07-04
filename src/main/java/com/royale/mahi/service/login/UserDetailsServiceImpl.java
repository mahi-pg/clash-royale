package com.royale.mahi.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.royale.mahi.dao.UserDao;
import com.royale.mahi.model.LoginUser;
import com.royale.mahi.model.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		User user = null;
		
		try {
			// 入力されたユーザIDから認証を行うユーザ情報を取得する
			user = userDao.getUserByPrimary(userId);
		} catch(Exception e) {
			// DBから取得時に例外が発生した場合
			throw new AuthenticationServiceException("ユーザ取得失敗", e);
		}
		
		// ユーザが取得できなかった場合エラーとする
		if(user == null) {
			throw new UsernameNotFoundException("ユーザが見つかりません。ユーザID[" + userId + "]");
		}
		
		// ユーザが取得出来たらSpring Securityで認証できる形で戻す
		return new LoginUser(user.getUserId(), user.getPassword());
	}
}
