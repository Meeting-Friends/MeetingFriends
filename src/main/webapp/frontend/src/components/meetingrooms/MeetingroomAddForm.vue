<template>
	<div class="contents">
		<h1 class="page-header">Create room</h1>
		<div class="form-wrapper">
			<form class="form" @submit.prevent="submitForm">
				<div>
					<label for="title">제목 </label>
					<input id="title" type="text" v-model="title" />
					<p v-if="!isTitleValid" class="validation-text warning">
						Title must be less than 20
					</p>
				</div>
				<div>
					<label for="maxpeople">최대 인원 </label>
					<select id="maxpeople" name="maxpeople" v-model="mexpeople">
						<option value="2">2명</option>
						<option value="3">3명</option>
						<option value="4">4명</option>
						<option value="5">5명</option>
						<option value="6">6명</option>
						<option value="7">7명</option>
						<option value="8">8명</option>
					</select>
				</div>
				<div>
					<label for="theme">테마 </label>
					<select id="theme" name="theme" v-model="theme">
						<option value="수다">수다방</option>
						<option value="먹방">먹방</option>
						<option value="운동">운동방</option>
						<option value="게임">게임방</option>
						<option value="기타">기타방</option>
					</select>
				</div>
				<div>
					<label for="minage">최소연령 </label>
					<input id="minage" type="text" v-model="minage" />
				</div>
				<div>
					<label for="maxage">최대연령 </label>
					<input id="maxage" type="text" v-model="maxage" />
				</div>
				<div>
					<label for="gender">성별 </label>
					<select id="gender" name="gender" v-model="gender">
						<option value="남자">남자</option>
						<option value="여자">여자</option>
					</select>
				</div>
				<button type="submit" class="btn">채팅방 만들기</button>
			</form>
			<p class="log">
				{{ logMessage }}
			</p>
		</div>
	</div>
</template>

<script>
import { createMeetingroom } from '@/api/meetingrooms';

export default {
	name: 'NewRoom',
	data() {
		return {
			title: '',
			maxpeople: '',
			theme: '',
			minage: '',
			maxage: '',
			gender: '',
			logMessage: '',
		};
	},
	computed: {
		isTitleValid() {
			return this.title.length <= 20;
		},
	},
	methods: {
		async submitForm() {
			try {
				const userData = this.$session.get('userinfo');

				await createMeetingroom({
					member: JSON.stringify(userData),
					room: JSON.stringify({
						title: this.title,
						maxpeople: this.maxpeople,
						theme: this.theme,
						minage: this.minage,
						maxage: this.maxage,
						gender: this.gender,
					}),
				});
				//this.$router.push(response.data);
			} catch (error) {
				console.log(error.response.data.message);
				this.logMessage = error.response.data.message;
			} finally {
				this.initForm();
			}
		},
	},
};
</script>

<style scoped>
.form-wrapper .form {
	width: 100%;
}
.btn {
	color: white;
}
</style>
