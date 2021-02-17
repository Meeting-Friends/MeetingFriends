<template>
	<div>
		<div id="1">
			<ModalClient />
		</div>
		<div id="2">
			<ModalNewRoom />
		</div>
		<div>채팅룸 리스트 <RoomList /></div>
		<button type="button" @click="logout">로그아웃</button>
	</div>
</template>

<script>
// @ is an alias to /src
import ModalClient from '@/components/clientinfo/ModalClient.vue';
import ModalNewRoom from '@/components/meetingrooms/ModalNewRoom.vue';
import RoomList from '@/components/meetingrooms/RoomList.vue';
import { LogoutUser } from '@/api/auth';

export default {
	name: 'WaittingRoom',
	components: {
		ModalClient,
		ModalNewRoom,
		RoomList,
	},
	methods: {
		async logout() {
			try {
				const userData = this.$session.get('userinfo');
				const response = await LogoutUser(userData); //로그아웃
				this.$session.remove('userinfo');
				this.$router.push(response.data);
			} catch (error) {
				console.log(error.response.data.message);
				this.logMessage = error.response.data.message;
			}
		},
	},
};
</script>
