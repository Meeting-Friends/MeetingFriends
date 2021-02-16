<template>
	<div class="contents">
		<div class="form-wrapper form-wrapper-sm">
			<form @submit.prevent="submitForm" class="form">
				<div>
					<label for="id">아이디 : </label>
					<input id="id" type="text" v-model="id" />
					<p class="validation-text">
						<span class="warning" v-if="!isIdValid && id">
							Please enter an email address
						</span>
					</p>
				</div>
				<div>
					<label for="pw">비밀번호 : </label>
					<input id="pw" type="text" v-model="pw" />
				</div>
				<button v-bind:disabled="!isIdValid || !pw" type="submit" clas="btn">
					로그인
				</button>
			</form>
			<p class="log">{{ logMessage }}</p>
		</div>
	</div>
</template>

<script>
import { validateEmail } from '@/utils/validation';
import { signinUser } from '@/api/auth';

export default {
	data() {
		return {
			//form values
			id: '',
			pw: '',
			//log
			logMessage: '',
		};
	},
	computed: {
		isIdValid() {
			return validateEmail(this.id); //id가 이메일 형식이 맞는지 체크
		},
	},
	methods: {
		async submitForm() {
			try {
				// 비즈니스 로직
				const userData = {
					id: this.id,
					pw: this.pw,
				};
				const data = await signinUser(userData);
				console.log(data);
				// this.$store.commit('setToken', data.token);
				// this.$store.commit('setId', data.user.id);
				this.$router.push('../' + data.data);
			} catch (error) {
				// 에러 핸들링할 코드
				console.log(error.response.data);
				this.logMessage = error.response.data;
				this.$router.push('../Signin');
			} finally {
				this.initForm();
			}
		},
		initForm() {
			this.username = '';
			this.password = '';
		},
	},
};
</script>

<style>
.btn {
	color: white;
}
</style>
