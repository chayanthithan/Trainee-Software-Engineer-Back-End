package com.example.srilanka_cricket_service.api.advice;

import com.example.srilanka_cricket_service.api.dto.ErrorResponseDto;
import com.example.srilanka_cricket_service.constants.ApplicationConstants;
import com.example.srilanka_cricket_service.exception.ServiceException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;

@ControllerAdvice  //it is used to handle exception which is comes from controller
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @ExceptionHandler(SecurityException.class)
    public ResponseEntity<?> handleSecurityException(SecurityException ex, WebRequest request) {
        ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
                .message(ApplicationConstants.UNAUTHORIZED)
                .errorCode(HttpStatus.FORBIDDEN.value())
                .build();
        return new ResponseEntity<>(errorResponseDto, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<Object> handleException(Exception ex) {
        log.error("Internal server error: ", ex);
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ApplicationConstants.INTERNAL_SERVER,
                List.of(ApplicationConstants.INTERNAL_SERVER));
        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {ServiceException.class})
    protected ResponseEntity<Object> handleServiceException(ServiceException ex) {
        log.error("Internal service error: ", ex);
        ApiError apiError = new ApiError(ex.getHttpStatus().value(),
                ex.getHeaderMessage(),
                List.of(ex.getMessage()));
        return new ResponseEntity<>(apiError, ex.getHttpStatus());
    }

    @ExceptionHandler(value = {FeignException.class})
    protected ResponseEntity<Object> handleFeignException(FeignException ex) {
        log.error("Feign client execution error: ", ex);
        ApiError apiError = translate(ex);
        return new ResponseEntity<>(apiError, HttpStatus.valueOf(apiError.getStatus()));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex) {
        List<String> errorMessages = ex.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .toList();

        ValidationError apiError = new ValidationError(HttpStatus.BAD_REQUEST.value(), ApplicationConstants.BAD_REQUEST, errorMessages.get(1));
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    private ApiError translate(FeignException ex) {
        try {
            int i = ex.getMessage().indexOf(ApplicationConstants.STATUS);
            String substring = ex.getMessage().substring(i, ex.getMessage().length() - 1);
            return objectMapper.readValue(substring, ApiError.class);
        } catch (Exception e) {
            return new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    ApplicationConstants.INTERNAL_SERVER,
                    List.of(ApplicationConstants.INTERNAL_SERVER));
        }
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatusCode status,
                                                                  WebRequest request) {
        log.error("Bad request: ", ex);
        List<String> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> String.format(fieldError.getDefaultMessage()))
                .toList();
        ValidationError apiError = new ValidationError(HttpStatus.BAD_REQUEST.value(), ApplicationConstants.BAD_REQUEST, errors.get(0));
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    private static class ApiError {
        private int status;
        private String message;
        private List<String> errors;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    private static class ValidationError {
        private int status;
        private String message;
        private String error;
    }

//    @ExceptionHandler(MaxUploadSizeExceededException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    public ResponseDto handleMaxUploadSizeExceededException(MaxUploadSizeExceededException ex) {
//        ResponseDto responseMessageDto = new ResponseDto();
//        responseMessageDto.setMessage(ApplicationConstants.MAXIMUM_FILE_SIZE);
//        return responseMessageDto;
//    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiError> handleIllegalArgumentException(IllegalArgumentException ex) {
        String errorMessage = ex.getMessage();
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST.value(),
                ApplicationConstants.BAD_REQUEST,
                List.of(errorMessage));
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(AccessDeniedException.class)
//    public ResponseEntity<ErrorResponseDto> handleAccessDeniedException(AccessDeniedException ex) {
//        log.error("Unauthorized access: {}", ex.getMessage());
//
//        ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
//                .message(ApplicationConstants.NOT_GRANTED)
//                .errorCode(HttpStatus.UNAUTHORIZED.value())
//                .build();
//
//        return new ResponseEntity<>(errorResponseDto, HttpStatus.UNAUTHORIZED);
//    }

    private List<String> getStepwiseValidationErrors(Set<ConstraintViolation<?>> violations) {
        Map<String, List<String>> errorsByField = new HashMap<>();

        for (ConstraintViolation<?> violation : violations) {
            String fieldName = violation.getPropertyPath().toString();
            errorsByField.computeIfAbsent(fieldName, k -> new ArrayList<>()).add(violation.getMessage());
        }

        Set<String> stepwiseErrors = new LinkedHashSet<>();

        for (Map.Entry<String, List<String>> entry : errorsByField.entrySet()) {
            List<String> fieldErrors = entry.getValue();
            String blankError = fieldErrors.stream()
                    .filter(error -> error.contains(ApplicationConstants.CANNOT_BE_BLANK))
                    .findFirst()
                    .orElse(null);
            if (blankError != null) {
                stepwiseErrors.add(blankError);
            }
        }

        if (stepwiseErrors.isEmpty()) {
            errorsByField.values()
                    .stream()
                    .flatMap(List::stream)
                    .forEach(stepwiseErrors::add);
        }

        return new ArrayList<>(stepwiseErrors);
    }

    private List<String> getStepwiseFieldErrors(List<FieldError> fieldErrors) {
        Map<String, List<String>> errorsByField = new HashMap<>();

        for (FieldError error : fieldErrors) {
            errorsByField.computeIfAbsent(error.getField(), k -> new ArrayList<>()).add(error.getDefaultMessage());
        }

        Set<String> stepwiseErrors = new LinkedHashSet<>();

        for (Map.Entry<String, List<String>> entry : errorsByField.entrySet()) {
            List<String> errors = entry.getValue();
            String blankError = errors.stream()
                    .filter(error -> error.contains(ApplicationConstants.CANNOT_BE_BLANK))
                    .findFirst()
                    .orElse(null);
            if (blankError != null) {
                stepwiseErrors.add(blankError);
            }
        }

        if (stepwiseErrors.isEmpty()) {
            errorsByField.values()
                    .stream()
                    .flatMap(List::stream)
                    .forEach(stepwiseErrors::add);
        }

        return new ArrayList<>(stepwiseErrors);
    }
}

