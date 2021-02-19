package meet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import meet.service.QnAService;

@SessionAttributes({"userinfo","roominfo"})
@RestController(value="LoginController")
public class QnAController {
	@Autowired
	QnAService qnaservice;

}
