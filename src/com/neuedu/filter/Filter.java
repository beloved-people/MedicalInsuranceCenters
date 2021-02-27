package com.neuedu.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter(
	filterName = "Filter",
	value="/*",
	initParams= {@WebInitParam(name="CharacterEncoding",value="utf-8")})
public class Filter implements javax.servlet.Filter {
	private String charset;

    public Filter() {
    }


	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		((HttpServletResponse)response).setContentType("text/html;charset="+this.charset);
		((HttpServletRequest)request).setCharacterEncoding(this.charset);
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
		this.charset = fConfig.getInitParameter("CharacterEncoding");
	}

}
