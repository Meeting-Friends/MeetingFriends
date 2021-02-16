<template>
	<div class="contents">
		<div class="form-wrapper form-wrapper-sm">
			<form @submit.prevent="submitForm" class="form">
				<div>
					<label for="id">아이디 : </label>
					<input v-model="id" id="id" type="text" />
				</div>
				<div>
					<label for="pw">비밀번호 : </label>
					<input v-model="pw" id="pw" type="text" />
				</div>
				<div>
					<label for="name">이름 : </label>
					<input v-model="name" id="name" type="text" />
				</div>
				<div>
					<label for="nickname">닉네임 : </label>
					<input v-model="nickname" id="nickname" type="text" />
				</div>
				<div>
					<label for="phonenumber">핸드폰 번호 : </label>
					<input v-model="phonenumber" id="phonenumber" type="text" />
				</div>
				<div>
					<label for="birth">생년월일 : </label>
					<input v-model="birth" id="birth" type="text" />
				</div>
				<div>
					<label for="gender">남성</label>
					<input
						v-model="male"
						id="male"
						type="radio"
						name="gender"
						value="male"
					/>
					<label for="gender">여성</label>
					<input
						v-model="gender"
						id="female"
						type="radio"
						name="gender"
						value="female"
					/>
					<label for="gender">기타</label>
					<input
						v-model="gender"
						id="none"
						type="radio"
						name="gender"
						value="none"
					/>
				</div>
				<button
					v-bind:disabled="
						!isIdValid ||
							!pw ||
							!name ||
							!nickname ||
							!phonenumber ||
							!birth ||
							!gender
					"
					type="submit"
				>
					회원 가입
				</button>
			</form>
			<p class="log">{{ logMessage }}</p>
		</div>
	</div>
</template>

<script>
import { signupUser } from '@/api/auth';
import { validateEmail } from '@/utils/validation';

export default {
	data() {
		return {
			//form values
			id: '',
			pw: '',
			name: '',
			nickname: '',
			phonenumber: '',
			birth: '',
			gender: '',
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
				console.log('폼 제출');
				const userData = {
					id: this.id,
					pw: this.pw,
					name: this.name,
					nickname: this.nickname,
					phonenumber: this.phonenumber,
					birth: this.birth,
					gender: this.gender,
				};
				console.log(
					'userData' +
						userData.id +
						' ' +
						userData.pw +
						' ' +
						userData.name +
						' ' +
						userData.nickname +
						' ' +
						userData.phonenumber +
						' ' +
						userData.birth +
						' ' +
						userData.gender,
				);
				const data = await signupUser(userData);
				console.log(data.data);

				if (data.data == 'Signin') {
					this.logMessage = '회원가입성공';
					alert('회원가입성공!!');
				} else {
					//this.logMessage = '회원가입실패';
					alert('회원가입실패');
				}
				this.$router.push('../' + data.data);
			} catch (error) {
				// 에러 핸들링할 코드
				console.log(error.response.data);
				this.logMessage = '회원가입실패';
			} finally {
				this.initForm();
			}
		},
		initForm() {
			this.username = '';
			this.password = '';
			this.name = '';
			this.nickname = '';
			this.phonenumber = '';
			this.birth = '';
			this.gender = '';
		},
	},
};
</script>

<style></style>
