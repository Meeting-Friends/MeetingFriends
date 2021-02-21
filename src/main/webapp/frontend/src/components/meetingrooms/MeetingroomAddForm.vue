<template>
	<div class="contents">
		<h1>Create room</h1>
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
					<label for="maxPeople">최대 인원 </label>
					<select id="maxPeople" name="maxPeople" v-model="maxPeople">
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
						<option value="방구석 콘서트">방구석 콘서트</option>
						<option value="공부">공부방</option>
						<option value="클럽하우스">클럽하우스</option>
						<option value="기타">기타방</option>
					</select>
				</div>
				<div>
					<label for="gender">성별 </label>
					<select id="gender" name="gender" v-model="gender">
						<option value="남자">남자</option>
						<option value="여자">여자</option>
						<option value="전체">전체</option>
					</select>
				</div>
				<button
					type="submit"
					class="btn"
					v-bind:disabled="!title || !maxPeople || !theme || !gender"
				>
					채팅방 만들기
				</button>
			</form>
		</div>
	</div>
</template>

<script>
import { createMeetingroom } from '@/api/meetingrooms';
import { sendInfoToMeetingroom } from '@/api/meetingrooms';

export default {
	name: 'NewRoom',
	data() {
		return {
			title: '',
			maxPeople: '',
			theme: '',
			gender: '',
			desturl: '',
			userdata: '',
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
				this.userData = this.$session.get('userinfo');
				this.desturl = await createMeetingroom({
					member: JSON.stringify(this.userData),
					room: JSON.stringify({
						title: this.title,
						maxPeople: this.maxPeople,
						theme: this.theme,
						gender: this.gender,
					}),
				});
			} catch (error) {
				alert('방을 만드는 중 문제가 발생했습니다.');
				console.log(error.response.data.message);
			} finally {
				if (this.desturl == 'waittingroom') {
					alert('찾으려는 방이 없거나 방 설정 성별과 본인의 성별이 다릅니다.');
				}
				sendInfoToMeetingroom(
					this.desturl.data,
					this.$session.get('userinfo').id,
				);
				this.initForm();
			}
		},
		initForm() {
			this.title = '';
			this.maxPeople = '';
			this.theme = '';
			this.gender = '';
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
