package controller.filter;

//import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;


public class LangFilter implements Filter {


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		//Logger log = Logger.getLogger(this.getClass());
		HttpServletRequest req = (HttpServletRequest) request;
		String locale = Optional.ofNullable(request.getParameter("locale")).orElse("en");
        System.out.println(locale);
		//log.info("locale= " + locale);
		req.getSession().setAttribute("lang",
				locale);

		chain.doFilter(request,response);
	}

	@Override
	public void destroy() {

	}
}

