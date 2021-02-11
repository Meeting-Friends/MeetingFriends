package meet.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;;

@ControllerAdvice
public class ExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler(MemberNotFoundException.class)
	public String handleCustomException(MemberNotFoundException exception, Model model) {
		model.addAttribute("exception", exception);
		return "/errors/boardError";
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public String handleException(Exception exception, Model model) {
		model.addAttribute("exception", exception);
		return "/errors/globalError";
	}
}
