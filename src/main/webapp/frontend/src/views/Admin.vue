<template>
	<div>
		<div id="head">
			<button @click="show = false" class="btnupdate">방정보 보기</button>
			<button @click="show = true" class="btnupdate">회원정보 보기</button>
		</div>
		<div id="1" v-if="show">
			<userAdmin />
		</div>
		<div id="2" v-else>
			<roomAdmin />
		</div>
	</div>
</template>

<script>
import userAdmin from '@/components/admin/userAdmin.vue';
import roomAdmin from '@/components/admin/roomAdmin.vue';
import { getUserFromCookie } from '@/utils/cookies';

export default {
	name: 'Admin',
	data() {
		return {
			show: true,
			isHidden: false,
		};
	},
	components: {
		userAdmin,
		roomAdmin,
	},
	methods: {
		toggleShow() {
			this.show = !this.show;
		},
	},
	beforeCreate() {
		if (getUserFromCookie() !== '3333@3333.com') {
			alert('관리자만 접근가능합니다.');
			this.$router.push('/signin');
		}
	},
};
</script>
