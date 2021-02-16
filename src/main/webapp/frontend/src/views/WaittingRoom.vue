<template>
	<div>
		<div id="1">
			<Modalclient />
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
import Modalclient from '@/components/clientinfo/Modalclient.vue';
import ModalNewRoom from '@/components/meetingrooms/ModalNewRoom.vue';
import RoomList from '@/components/meetingrooms/RoomList.vue';
import { LogoutUser } from '@/api/auth';

export default {
	name: 'WaittingRoom',
	components: {
		Modalclient,
		ModalNewRoom,
		RoomList,
	},
	methods: {
		async logout() {
			try {
				const { userData } = await this.$session.get('userinfo');
				const response = await LogoutUser({ userData }); //로그아웃
				console.log(response.data);
				this.$router.push(response.data);
			} catch (error) {
				console.log(error.response.data.message);
				this.logMessage = error.response.data.message;
			}
		},
	},
};
</script>
