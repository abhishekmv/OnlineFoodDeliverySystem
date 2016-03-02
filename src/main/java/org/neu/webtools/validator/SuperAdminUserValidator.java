package org.neu.webtools.validator;




import org.neu.webtools.model.Person;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class SuperAdminUserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Person.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Person per = (Person)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "validate.name", "Your Name Is Incorrenct");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "validate.password", "Your password Is Incorrenct");
		
	}

}
