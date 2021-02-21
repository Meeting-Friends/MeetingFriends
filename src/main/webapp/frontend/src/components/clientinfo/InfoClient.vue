<template>
	<div id="app">
		<div id="clientlist" v-if="show">
			<table border="1" class="tbmodal">
				<tr>
					<th>회원 아이디</th>
					<th>이름</th>
					<th>닉네임</th>
					<th>회원상태</th>
					<th>수정</th>
				</tr>
				<tr>
					<td id="col1">{{ data.id }}</td>
					<td id="col2">{{ data.name }}</td>
					<td id="col3">{{ data.nickname }}</td>
					<td id="col4">{{ data.classification }}</td>
					<td><button @click="toggleShow">update</button></td>
				</tr>
			</table>
		</div>
		<div id="modify" v-else>
			<form class="form" @submit.prevent="submitForm">
				<div>
					<label for="password">비밀번호 </label>
					<input id="password" type="password" v-model="password" />
				</div>
				<div>
					<label for="nickname">닉네임 </label>
					<input id="nickname" type="text" v-model="nickname" />
				</div>
				<div>
					<label for="phonenumber">휴대폰 번호 </label>
					<input id="phonenumber" type="text" v-model="phonenumber" />
				</div>
				<button type="submit">수정</button>
			</form>
		</div>
	</div>
</template>

<script>
import { getMyInfo } from '@/api/auth.js';
import { updateUser } from '@/api/auth';

export default {
	data() {
		return {
			data: [],
			nickname: '',
			password: '',
			show: true,
			phonenumber: '',
			id: '',
		};
	},
	name: 'InfoClient',
	methods: {
		toggleShow() {
			this.show = !this.show;
		},
		clientSession() {
			getMyInfo(this.$session.get('userinfo').id)
				.then(res => {
					this.data = res.data;
				})
				.catch(err => {
					console.log(err);
				});
		},
		async submitForm() {
			await updateUser({
				id: this.$session.get('userinfo').id,
				nickname: this.nickname,
				phonenumber: this.phonenumber,
				pw: this.password,
			})
				.then(response => {
					if (response.data == 'success') {
						alert('회원정보 수정 완료');
						this.clientSession();
					} else {
						alert('회원정보 수정 실패');
					}
					this.show = true;
				})
				.catch(error => {
					console.log(error.response.data.message);
					this.logMessage = error.response.data.message;
				});
		},
	},
	// 화면 시작 시 clientSession 함수 실행
	beforeMount() {
		this.clientSession();
	},
};
</script>
