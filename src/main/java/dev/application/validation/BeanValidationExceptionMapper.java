package dev.application.validation;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
@ApplicationScoped
public class BeanValidationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {

        ValidationError validationError = new ValidationError("400", "Erro de Validação");

        for (ConstraintViolation<?> violation : exception.getConstraintViolations()) {
            String fullField = violation.getPropertyPath().toString();
            String parts[] = fullField.split("\\.");
            String field = parts[parts.length -1];
            String message = violation.getMessage();
            validationError.addFieldError(field, message);
        }

        return Response.status(Response.Status.BAD_REQUEST).entity(validationError).build();

    }
}