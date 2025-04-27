package com.example.userauthapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/css/**", "/js/**", "/index.html", "/", "/favicon.ico").permitAll() // 静的リソースを許可
						.requestMatchers("/api/auth/**").permitAll() // APIも必要に応じて許可
						.anyRequest().authenticated())
				.csrf(csrf -> csrf.disable()) // フォームでのテスト時はCSRF無効化（本番では注意）
				.formLogin(login -> login.disable()) // フォームログインを無効にする（必要なら有効に）
				.httpBasic(httpBasic -> httpBasic.disable()); // Basic認証も無効にする（必要なら有効に）

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
