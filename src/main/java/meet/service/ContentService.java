package meet.service;

import java.util.List;

import meet.model.domain.entity.Content;

public interface ContentService {
	
	List<Content> getContentList();	//전체 Content들 리스트 가져오기
	
	Content getContent(String id);
	
	boolean insertContent(Content content);

	boolean updateContent(Content content);

	boolean deleteContent(String id);
}
