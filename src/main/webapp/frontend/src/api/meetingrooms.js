// 학습 노트 조작과 관련된 CRUD API 함수 파일
import { meetingrooms } from './index';

// 채팅룸 리스트 데이터 조회 API
function fetchMeetingRooms() {
	return meetingrooms.get('/getroomlist');
}

//채팅룸 데이터 생성하는 API
function createMeetingroom(MeetingroomData) {
	meetingrooms.post('/createroom', MeetingroomData);
}

//채팅룸 데이터 삭제하는 API
function deleteMeetingroom(meetingroomId) {
	return meetingrooms.delete(meetingroomId);
}

export { fetchMeetingRooms, createMeetingroom, deleteMeetingroom };
