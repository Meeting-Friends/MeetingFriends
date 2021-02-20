package meet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import meet.model.domain.entity.Comments;
import meet.model.domain.entity.Content;
import meet.service.CommentService;
import meet.service.ContentService;

@SessionAttributes({"userinfo","roominfo"})
@RestController(value="QnAController")
public class QnAController {
	@Autowired
	ContentService contentService;
	@Autowired
	CommentService commentService;

	@GetMapping("/getallqnalist")
	public String getAllQnAList() throws JsonProcessingException {	
		ObjectMapper mapper = new ObjectMapper();		
		return mapper.writeValueAsString(contentService.getContentList());		
	}
	
	@GetMapping("/findqna/{id}")
	public String getQnA(@PathVariable String id, Model model) throws JsonProcessingException {	
		ObjectMapper mapper = new ObjectMapper();		
		return mapper.writeValueAsString(contentService.getContent(id));		
	}
	
	@PostMapping("/insertqna")
	public String insertQnA(@RequestBody Content content, Model model) {
		if(contentService.insertContent(content)) {
			return "insertQnA success!";
		}else {
			return "insertQnA fail!";
		}
	}

	@PostMapping("/modifyqna")
	public String updateQnA(@RequestBody Content content, Model model) throws JsonProcessingException {		
		if(contentService.updateContent(content)) {
			return "modifyQnA success";
		}else {
			return "modifyQnA fail";
		}
	}
	
	@DeleteMapping("/deleteqna/{id}")
	public String deleteQnA(@PathVariable String id, Model model) throws JsonProcessingException {		
		if(contentService.deleteContent(id)) {
			return "modifyQnA success";
		}else {
			return "modifyQnA fail";
		}
	}
	
	
	@GetMapping("/findanswer/{id}")
	public String getComment(@PathVariable String id, Model model) throws JsonProcessingException {	
		ObjectMapper mapper = new ObjectMapper();		
		return mapper.writeValueAsString(contentService.getContent(id));		
	}
	
	@PostMapping("/insertanswer")
	public String insertAnswer(@RequestBody Comments comment, Model model) {
		if(commentService.insertComment(comment)) {
			return "insertAnswer success!";
		}else {
			return "insertAnswer fail!";
		}
	}

	@PostMapping("/modifyanswer")
	public String updateAnswer(@RequestBody Comments comment, Model model) throws JsonProcessingException {		
		if(commentService.updateComment(comment)) {
			return "updateAnswer success";
		}else {
			return "updateAnswer fail";
		}
	}
	
	@DeleteMapping("/deleteanswer/{id}")
	public String deleteAnswer(@PathVariable String id, Model model) throws JsonProcessingException {		
		if(commentService.deleteComment(id)) {
			return "deleteAnswer success";
		}else {
			return "deleteAnswer fail";
		}
	}
}
