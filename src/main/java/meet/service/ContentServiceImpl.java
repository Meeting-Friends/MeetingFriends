package meet.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meet.dao.ContentRepository;
import meet.model.domain.entity.Content;

@Service
public class ContentServiceImpl implements ContentService{
	@Autowired
	private ContentRepository contentrepository;

	//Content리스트들을 반환하는 메소드
	public List<Content> getContentList(){
		return (List<Content>) contentrepository.findAll();
	}

	public Content getContent(String id){	
		try {
			return contentrepository.findById(id).get();			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//Content테이블에 저장하기 위한 메소드
	public boolean insertContent(Content content) {
		try{
			SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
			Date time = new Date();
			content.setCreatedAt(format.format(time));			
			contentrepository.save(content);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	//db의 Content테이블을 수정하기 위한 메소드
	public boolean updateContent(Content content){	
		try {
			Content findContent = contentrepository.findById(content.getContentId()).get();

			findContent.setTitle(content.getTitle());
			findContent.setContext(content.getContext());
			SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
			Date time = new Date();
			findContent.setCreatedAt(format.format(time));					
			contentrepository.save(findContent);			
			return true;
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//db의 Content테이블을 삭제하기 위한 메소드
	public boolean deleteContent(String id) {
		try {
			contentrepository.deleteById(id);
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
