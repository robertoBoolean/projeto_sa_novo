package br.com.senai.ManagedBean;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "validaImputString")
public class ValidadaImputString implements Validator {

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object imputSring) throws ValidatorException {
        String string = (String) imputSring;
        if (string.length() < 3) {
            FacesMessage msg = new FacesMessage("imputSring", "Campo deve conter pelo menos 3 caracteres");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);            
        }
    }
}
