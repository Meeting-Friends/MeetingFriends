<template>
	<div class="contents">
		<div class="form-wrapper form-wrapper-sm">
			<form @submit.prevent="submitForm" class="form">
				<div>
					<label for="memberagree">memberagree</label>
					동의하려면 체크하세요.
					<input
						v-model="memberagree"
						id="memberagree"
						type="checkbox"
						name="memberagree"
						value="memberagree"
					/>
				</div>
				<button v-bind:disabled="!memberagree" type="submit" @click="signup()">
					확인
				</button>
			</form>
			<p class="log">{{ logMessage }}</p>
		</div>
	</div>
</template>

<script>
import { MemberAgreeUser } from '@/api/auth';

export default {
	data() {
		return {
			memberagree: '',
			logMessage: '',
		};
	},
	methods: {
		async submitForm() {
			try {
				//비즈니스 로직
				console.log('약관 폼 제출');
				const userData = {
					memberagree: this.memberagree,
				};
				console.log('userData' + userData.memberagree);
				const { data } = await MemberAgreeUser(userData);
				this.logMessage = `${data.memberagree}님이 약관을 동의하였습니다.`;
			} catch (error) {
				// 에러 핸들링할 코드
				console.log(error.response.data);
				this.logMessage = error.response.data;
			} finally {
				this.initForm();
			}
		},
		signup() {
			console.log('check!');
			this.$router.push('../Signup');
		},
		initForm() {
			this.memberagree = '';
		},
	},
};
</script>

<style></style>
