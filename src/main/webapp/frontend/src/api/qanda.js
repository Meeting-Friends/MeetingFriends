// 학습 노트 조작과 관련된 CRUD API 함수 파일
import { instance } from './index';

// QandA 리스트 조회 API
function fetchqandalist() {
	return instance.get('/getallqnalist');
}

//Question 추가하는 API
function addQuestion(data) {
	return instance.post('/insertqna', data);
}

//Question 수정하는 API
function modifyQuestion(data) {
	return instance.post('/modifyqna', data);
}

//Question 찾는하는 API
function findQuestion(data) {
	return instance.get(`/findqna/${data.contentId}`);
}

//Question 삭제하는 API
function deleteQuestion(data) {
	return instance.delete(`/deleteqna/${data.contentId}`);
}

//Answer 추가하는 API
function addAnswer(data) {
	return instance.post('/insertanswer', data);
}

//Answer 삭제하는 API
function deleteAnswer(data) {
	return instance.delete(data);
}

//Answer 찾는 API
function findAnswer(data) {
	return instance.findAnswer(`/findanswer/${data.commentId}`);
}
//Answer 수정하는 API
function updateAnswer(data) {
	return instance.post('updateanswer', data);
}

export {
	fetchqandalist,
	addQuestion,
	modifyQuestion,
	findQuestion,
	deleteQuestion,
	addAnswer,
	findAnswer,
	deleteAnswer,
	updateAnswer,
};
