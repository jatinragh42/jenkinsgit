//package com.rays.validation;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//
//public class ValidAlphabeticValidator implements ConstraintValidator<ValidAlphabetic, String> {
//
//	@Override
//	public void initialize(ValidAlphabetic constraintAnnotation) {
//	}
//
//	@Override
//	public boolean isValid(String value, ConstraintValidatorContext context) {
//		if (value == null || value.isEmpty()) {
//			return true; // Handle @NotEmpty separately
//		}
//		return value.chars().allMatch(Character::isLetter);
//	}
//}
