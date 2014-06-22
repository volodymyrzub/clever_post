package com.cleverpost.admin.web.bean.base;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.RememberMeServices;

import com.mobile.cleverpost.rest.persistence.dao.DAOManager;
import com.mobile.cleverpost.rest.persistence.dao.security.entities.User;
import com.mobile.cleverpost.rest.persistence.dao.security.entities.UserRole;

/**
 * The Class LoginBean.
 */
@ManagedBean(name = "loginMntBean")
@SessionScoped
public class LoginBean implements PhaseListener, Serializable {
	static {

		try {
			if (DAOManager.load(User.class).size() == 0) {
				User admin = new User("admin", "admin", true, new Date(),
						new Date());
				UserRole adminRole = new UserRole("admin", "ROLE_ADMIN",
						new Date(), new Date());

				User user = new User("user", "user", true, new Date(),
						new Date());
				UserRole userRole = new UserRole("user", "ROLE_USER",
						new Date(), new Date());
				try {
					DAOManager.save(admin);
					DAOManager.save(adminRole);

					DAOManager.save(user);
					DAOManager.save(userRole);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/** The user name. */
	private String userName = null;

	/** The password. */
	private String password = null;

	/** The remember me. */
	private Boolean rememberMe = null;

	/** The authentication manager. */
	@ManagedProperty(value = "#{authenticationManager}")
	private AuthenticationManager authenticationManager = null;

	/** The remember me services. */
	@ManagedProperty(value = "#{rememberMeServices}")
	private RememberMeServices rememberMeServices = null;

	@ManagedProperty(value = "#{userDetailsService}")
	private UserDetailsService userDetailsService = null;

	/**
	 * Login.
	 * 
	 * @return the string
	 * @throws IOException
	 * @throws ServletException
	 */
	public String login() {
		try {
			Authentication result = null;
			Authentication request = new UsernamePasswordAuthenticationToken(
					this.getUserName(), this.getPassword());
			result = authenticationManager.authenticate(request);
			SecurityContextHolder.getContext().setAuthentication(result);
		} catch (BadCredentialsException e) {
			ExternalContext context = FacesContext.getCurrentInstance()
					.getExternalContext();

			RequestDispatcher dispatcher = ((ServletRequest) context
					.getRequest())
					.getRequestDispatcher("/j_spring_security_check");

			try {
				dispatcher.forward((ServletRequest) context.getRequest(),
						(ServletResponse) context.getResponse());
			} catch (ServletException e1) {
				// TODO Auto-generated catch block
				// e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				// e1.printStackTrace();
			}

			FacesContext.getCurrentInstance().responseComplete();
			return null;
		}
		// catch (Exception e) {
		// throw e;
		// }

		return "Secured";
	}

	@Override
	public void beforePhase(final PhaseEvent arg0) {
		Exception e = (Exception) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap()
				.get(WebAttributes.AUTHENTICATION_EXCEPTION);

		if (e instanceof BadCredentialsException) {
			FacesContext.getCurrentInstance().getExternalContext()
					.getSessionMap()
					.put(WebAttributes.AUTHENTICATION_EXCEPTION, null);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Invalid username or password", null));
		}
	}

	@Override
	public void afterPhase(final PhaseEvent arg0) {
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}

	/**
	 * Cancel.
	 * 
	 * @return the string
	 */
	public String cancel() {
		return null;
	}

	/**
	 * Logout.
	 * 
	 * @return the string
	 */
	public String logout() {
		SecurityContextHolder.clearContext();
		/**
		 * Delete Cookies
		 */
		HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext
				.getCurrentInstance().getExternalContext().getResponse();
		Cookie cookie = new Cookie("SPRING_SECURITY_REMEMBER_ME_COOKIE", null);
		cookie.setMaxAge(0);
		cookie.setPath(httpServletRequest.getContextPath().length() > 0 ? httpServletRequest
				.getContextPath() : "/");
		httpServletResponse.addCookie(cookie);
		return "loggedout";
	}

	/**
	 * Gets the user name.
	 * 
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 * 
	 * @param userName
	 *            the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the password.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 * 
	 * @param password
	 *            the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the remember me.
	 * 
	 * @return the remember me
	 */
	public Boolean getRememberMe() {
		return rememberMe;
	}

	/**
	 * Sets the remember me.
	 * 
	 * @param rememberMe
	 *            the new remember me
	 */
	public void setRememberMe(Boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	/**
	 * Gets the authentication manager.
	 * 
	 * @return the authentication manager
	 */
	public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}

	/**
	 * Sets the authentication manager.
	 * 
	 * @param authenticationManager
	 *            the new authentication manager
	 */
	public void setAuthenticationManager(
			AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	/**
	 * Gets the remember me services.
	 * 
	 * @return the remember me services
	 */
	public RememberMeServices getRememberMeServices() {
		return rememberMeServices;
	}

	/**
	 * Sets the remember me services.
	 * 
	 * @param rememberMeServices
	 *            the new remember me services
	 */
	public void setRememberMeServices(RememberMeServices rememberMeServices) {
		this.rememberMeServices = rememberMeServices;
	}

	public UserDetailsService getUserDetailsService() {
		return userDetailsService;
	}

	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
}