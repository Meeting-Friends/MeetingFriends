// 학습 노트 조작과 관련된 CRUD API 함수 파일
import { qanda } from './index';

// QandA 리스트 조회 API
function fetchqandalist() {
	return qanda.get('/getallqnalist');
}

//Question 추가하는 API
function addQuestion(qandaData) {
	return qanda.post('/', qandaData);
}

//Question 수정하는 API
function modifyQuestion(qandaData) {
	return qanda.post('modifyqanda', qandaData);
}

//Question 찾는하는 API
function findQuestion(qandaData) {
	return qanda.get('findqanda', qandaData);
}

//Question 삭제하는 API
function deleteQuestion(userId) {
	return qanda.delete(userId);
}

//Answer 추가하는 API
function addAnswer(qandaData) {
	return qanda.post('/', qandaData);
}

//Answer 삭제하는 API
function deleteAnswer(userId) {
	return qanda.delete(userId);
}

//Answer 찾는 API
function findAnswer(qandaData) {
	return qanda.findAnswer('findAnswer', qandaData);
}
//Answer 수정하는 API
function updateAnswer(qandaData) {
	return qanda.post('updateanswer', qandaData);
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
