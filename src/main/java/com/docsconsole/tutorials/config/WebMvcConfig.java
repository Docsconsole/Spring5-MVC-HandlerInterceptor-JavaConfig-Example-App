package com.docsconsole.tutorials.config;

import com.docsconsole.tutorials.interceptor.UserRequestInterceptor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.docsconsole.tutorials.interceptor.AdminRequestInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.docsconsole.tutorials" })
public class WebMvcConfig implements WebMvcConfigurer {

	@Bean
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("messages");
		return source;
	}

	@Bean
	AdminRequestInterceptor gdminRequestInterceptor() {
		return new AdminRequestInterceptor();
	}

	@Bean
    UserRequestInterceptor userRequestInterceptor() {
		return new UserRequestInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(gdminRequestInterceptor()).addPathPatterns("/getAdminHome");
		registry.addInterceptor(userRequestInterceptor()).addPathPatterns("/getUserHome");
	}

}