package br.edu.ifal.sicovi.utils;

import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.FacesEvent;
import javax.servlet.http.HttpServletRequest;

public class FacesUtil {
	private final FacesContext facesContext;

	public FacesUtil(FacesContext facesContext) {
		this.facesContext = facesContext;
	}

	public void addErrorMessage(String message) {
		this.facesContext.addMessage(null, new FacesMessage(
				FacesMessage.SEVERITY_ERROR, message, null));
	}

	public void addInfoMessage(String message) {
		this.facesContext.addMessage(null, new FacesMessage(
				FacesMessage.SEVERITY_INFO, message, null));
	}

	public void addUniqueErrorMessage(String message) {
		if (!hasMessage(message)) {
			addErrorMessage(message);
		}
	}

	private boolean hasMessage(String message) {
		for (Iterator<FacesMessage> iter = this.facesContext.getMessages(); iter
				.hasNext();) {
			FacesMessage facesMessage = (FacesMessage) iter.next();
			if (facesMessage.getSummary() != null
					&& facesMessage.getSummary().equals(message)) {
				return true;
			}
		}
		return false;
	}

	public void cleanSubmittedValues(UIComponent component) {
		if (component instanceof EditableValueHolder) {
			EditableValueHolder evh = (EditableValueHolder) component;
			evh.setSubmittedValue(null);
			evh.setValue(null);
			evh.setLocalValueSet(false);
			evh.setValid(true);
		}
		if (component.getChildCount() > 0) {
			for (UIComponent child : component.getChildren()) {
				cleanSubmittedValues(child);
			}
		}
	}

	public String getParametter(String name) {

		HttpServletRequest request = (HttpServletRequest) this.facesContext
				.getExternalContext().getRequest();
		return request.getParameter(name);
	}

	public Object getAttribute(FacesEvent event, String name) {
		Object atributo = event.getComponent().getAttributes().get(name);
		return atributo;
	}

	public static Flash flashScope() {
		return (FacesContext.getCurrentInstance().getExternalContext()
				.getFlash());
	}
}
