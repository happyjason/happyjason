/**
 * 
 */
package com.ammob.communication.webapp.form;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.converters.IntegerConverter;

import com.ammob.communication.core.model.User;

/**
 * @author Mob
 *
 */
public class UserForm extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6886693342105874571L;

	private String confirmPassword;

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	/**
	 * 
	 * @param providerUser
	 * @return
	 */
	public static UserForm fromProviderUser(User providerUser) {
		UserForm form = new UserForm();
		try {
			BeanUtilsBean beanUtils = BeanUtilsBean.getInstance();
			beanUtils.getConvertUtils().register(new IntegerConverter(null), Integer.class);
			beanUtils.copyProperties(form, providerUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return form;
	}
}
