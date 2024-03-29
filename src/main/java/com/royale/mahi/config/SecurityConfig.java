package com.royale.mahi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 許可の設定
		http.authorizeRequests().antMatchers("/").permitAll() // 全ユーザアクセス許可
			.anyRequest().authenticated() // その他は要認証
			.and().formLogin();
		
		// ログインの設定
		http.formLogin().loginProcessingUrl("/login") // 認証処理のパス
			.loginPage("/") // ログインフォームのパス
			.defaultSuccessUrl("/top") // 認証成功時の遷移先
			.usernameParameter("user_id") // ユーザIDのname属性値
			.passwordParameter("password") // パスワードのname属性値
			.and();
		
		// ログアウトの設定
		http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout**")) // ログアウト処理のパス
			.logoutSuccessUrl("/");
	}
	
	@Configuration
	protected static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {
		
		@Autowired
		UserDetailsService userDetailsService;
		
		@Override
		public void init(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService)
				.passwordEncoder(new BCryptPasswordEncoder());
		}
	}
}
