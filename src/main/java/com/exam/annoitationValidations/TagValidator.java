package com.exam.annoitationValidations;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class TagValidator implements ConstraintValidator<TagName, String> {

    private int size;

    @Override
    public void initialize(TagName tagName) {

    }

    @Override
    public boolean isValid(String tag, ConstraintValidatorContext constraintValidatorContext) {



        Pattern pattern = Pattern.compile("\\+\\d{1,3}\\/\\d{8,10}");
        Matcher matcher = pattern.matcher(tag);
        if(!matcher.find()){
            return false;
        }

        return true;
    }
}
