// 로그인, 회원 가입, 회원 탈퇴
import { instance } from './index';

// 회원가입 API
function signupUser(data) {
	return instance.post('/signup', data);
}

// 약관동의 API
function memberAgreeUser(data) {
	return instance.post('MemberAgree', data);
}

// 로그인 API
function signinUser(data) {
	return instance.post('/signin', data);
}

// 전체회원정보 get API
function fetchUsers() {
	return instance.get('/getMemberList');
}

// 내정보 get API
function getMyInfo(data) {
	return instance.get(`/getmyinfo/${data}`);
}

//회원 정보 수정
function updateUser(userData) {
	return instance.post('/updatemyinfo', userData);
}

//로그아웃
function LogoutUser(userData) {
	return instance.post('/logout', userData);
}

export {
	signupUser,
	signinUser,
	memberAgreeUser,
	fetchUsers,
	LogoutUser,
	getMyInfo,
	updateUser,
};
