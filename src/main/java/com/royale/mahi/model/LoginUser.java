package com.royale.mahi.model;

import org.springframework.security.core.authority.AuthorityUtils;

public class LoginUser extends org.springframework.security.core.userdetails.User {

	private static final long serialVersionUID = 1L;

	public LoginUser(String userId, String password) {
		super(userId, password, AuthorityUtils.createAuthorityList("ROLE_USER"));
	}
}
