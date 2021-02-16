<template>
	<div id="roomlist">
		<table border="1">
			<tr>
				<th>채팅룸 번호</th>
				<th>채팅룸 제목</th>
				<th>참여인원</th>
				<th>테마</th>
				<th>최소나이</th>
				<th>최대나이</th>
				<th>성별</th>
				<th>입장</th>
			</tr>
			<tr v-for="value in model" v-bind:key="value.title">
				<td>{{ value.title }}</td>
				<td>{{ value.maxpeople }}</td>
				<td>{{ value.theme }}/{{ value.maxNum }}</td>
				<td>{{ value.minage }}</td>
				<td>{{ value.maxage }}</td>
				<td>{{ value.gender }}</td>
				<td><button @click="enterRoom">입장</button></td>
			</tr>
		</table>
	</div>
</template>

<script>
let model = {};
import { fetchMeetingRooms } from '@/api/meetingrooms';
import { enterMeetingroom } from '@/api/meetingrooms';
export default {
	name: 'RoomList',
	data: function() {
		return { model };
	},
	methods: {
		//서버에 채팅방 정보 요청
		async getAllRooms() {
			try {
				const { response } = await fetchMeetingRooms();
				console.log(response.data);
				model = response.data;
				//	this.logMessage = `${model.title} 채팅방이 생성되었습니다.`;
			} catch (error) {
				console.log(error);
				this.logMessage = error.model.data;
			}
		},
		//채팅방 입장
		async enterRoom() {
			try {
				const MeetingroomData = {
					title: this.title,
					maxpeople: this.maxpeople,
					theme: this.theme,
					minage: this.minage,
					maxage: this.maxage,
					gender: this.gender,
				};
				const { roomInfo } = await enterMeetingroom(MeetingroomData); //room list 생성
				this.$router.push('/main'); // room 입장 url ??
				this.logMessage = `${roomInfo.title} 채팅방이 생성되었습니다.`;
			} catch (error) {
				console.log(error);
				this.logMessage = error.response.data;
			}
		},
		//화면 실행 시 getAllRooms 함수 실행
		beforeMount() {
			this.getAllRooms();
		},
	},
};
</script>
