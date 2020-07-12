package com.technocorp.testebancomysqldocker.exception;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class ValidationErrorDetails extends ErrorDetails {
    private final String field;
    private final String fieldMessage;

}
