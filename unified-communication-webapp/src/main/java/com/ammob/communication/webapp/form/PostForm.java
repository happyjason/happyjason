package com.ammob.communication.webapp.form;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.converters.IntegerConverter;

import com.ammob.communication.hr.model.Post;

public class PostForm extends Post {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5227424048389236226L;

	private String recipients;
	private String recipientsEmail;
	private String appointment;
	private String appointmentDate;
	private String appointmentTime;

	/**
	 * appointment time
	 * @return
	 */
	public String getAppointment() {
		if(appointment == null || appointment =="")
			return appointmentDate + " " + appointmentTime;
		return appointment;
	}

	public void setAppointment(String appointment) {
		this.appointment = appointment;
	}

	/**
	 * mail recipients name
	 * @return
	 */
	public String getRecipients() {
		return recipients;
	}
	
	public void setRecipients(String recipients) {
		this.recipients = recipients;
	}
	
	/**
	 * email address
	 * @return
	 */
	public String getRecipientsEmail() {
		return recipientsEmail;
	}
	
	public void setRecipientsEmail(String recipientsEmail) {
		this.recipientsEmail = recipientsEmail;
	}
	
	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	
	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	/**
	 * 
	 * @param providerPost
	 * @return
	 */
	public static PostForm fromProviderPost(Post providerPost) {
		PostForm form = new PostForm();
		try {
			BeanUtilsBean beanUtils = BeanUtilsBean.getInstance();
			beanUtils.getConvertUtils().register(new IntegerConverter(null), Integer.class);
			beanUtils.copyProperties(form, providerPost);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return form;
	}
	
	/**
	 * 
	 * @param providerPostForm
	 * @return
	 */
	public static Post fromConsumerPostForm(PostForm providerPostForm) {
		Post form = new Post();
		try {
			BeanUtilsBean beanUtils = BeanUtilsBean.getInstance();
			beanUtils.getConvertUtils().register(new IntegerConverter(null), Integer.class);
			beanUtils.copyProperties(form, providerPostForm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return form;
	}
}
