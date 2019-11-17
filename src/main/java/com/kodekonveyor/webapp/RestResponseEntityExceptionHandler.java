package com.kodekonveyor.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@InterfaceClass
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private LoggerService loggerService;

	@Value("${com.kodekonveyor.tidyup.loginUrl}")
	public String loginUrl;

	@ExceptionHandler({ NotLoggedInException.class, ValidationException.class })
	protected ResponseEntity<Object> handleNotLoggedInException(final NotLoggedInException exception,
			final WebRequest request) {
		final String bodyOfResponse = exception.getMessage();

		loggerService.call("not logged in");
		final HttpHeaders headers = new HttpHeaders();
		headers.add("Location", loginUrl);
		return handleExceptionInternal(exception, bodyOfResponse, headers, HttpStatus.FOUND, request);
	}

}
