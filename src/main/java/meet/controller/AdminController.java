package meet.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import meet.model.domain.dto.AdminAllList;
import meet.model.domain.entity.Member;
import meet.service.MemberService;

@Controller(value="AdminController")
public class AdminController {
	@Autowired 
	AdminAllList adminAllList;

}
