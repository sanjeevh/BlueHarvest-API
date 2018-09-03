package com.blueharvest.api.util;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.blueharvest.api.APIException;

public class ModelValidator {

	static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

	public static boolean validate( Object modelObject)
	{
		Validator validator = factory.getValidator();
		
		Set<ConstraintViolation<Object>> allViolations = validator.validate(modelObject);
		
		if(allViolations != null && !allViolations.isEmpty())
			{
			StringBuffer errorMessages = new StringBuffer();
			
			for (ConstraintViolation violation : allViolations) {

				errorMessages.append(violation.getMessage() + "\n");
				
				}
			throw new APIException(errorMessages.toString());
			}
		
		return true;
		
	}

}
