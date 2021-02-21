<template>
	<div id="roomlist" class="roomlist" cellspacing="1">
		<table border="1">
			<thead>
				<tr>
					<th>채팅룸 번호</th>
					<th>채팅룸 제목</th>
					<th>참여인원</th>
					<th>테마</th>
					<th>성별</th>
					<th>입장</th>
				</tr>
			</thead>
			<tbody>
				<tr v-for="value in model" v-bind:key="value.title">
					<td>{{ value.rid }}</td>
					<td>{{ value.title }}</td>
					<td>{{ value.maxpeople }}</td>
					<td>{{ value.theme }}/{{ value.maxNum }}</td>
					<td>{{ value.gender }}</td>
					<td><button @click="enterRoom(value)">입장</button></td>
				</tr>
			</tbody>
		</table>
	</div>
</template>

<script>
import { fetchMeetingRooms } from '@/api/meetingrooms';
import { enterMeetingroom } from '@/api/meetingrooms';
import { sendInfoToMeetingroom } from '@/api/meetingrooms';
let model = {};

export default {
	name: 'RoomList',
	data: function() {
		return { model };
	},
	methods: {
		//서버에 채팅방 정보 요청
		async getAllRooms() {
			try {
				const response = await fetchMeetingRooms();
				this.model = response.data;
			} catch (error) {
				console.log(error);
				alert('방 정보를 가져오는 중 문제가 발생했습니다.');
			}
		},
		//채팅방 입장
		async enterRoom(value) {
			try {
				const userData = this.$session.get('userinfo');

				const MeetingroomData = {
					member: JSON.stringify(userData),
					room: JSON.stringify(value),
				};
				const desturl = await enterMeetingroom(MeetingroomData); //room list 생성
				await sendInfoToMeetingroom(desturl.data, userData.id);
			} catch (error) {
				console.log(error);
				alert('입장하는 중 문제가 발생했습니다.');
			}
		},
	},
	//화면 실행 시 getAllRooms 함수 실행
	beforeMount() {
		this.getAllRooms();
	},
};
</script>
