<template>
	<div>
		<div id="head">
			<button @click="show = false">방정보 보기</button>
			<button @click="show = true">회원정보 보기</button>
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
};
</script>
