<template>
	<div>
		<div>
			<label for="section">분류 </label>
			<select id="section" name="section" v-model="section">
				<option value="신고">신고</option>
				<option value="기능">기능</option>
				<option value="건의">건의</option>
				<option value="기타">기타</option>
			</select>
		</div>
		<b-input v-model="subject" placeholder="제목을 입력해 주세요"></b-input>
		<b-form-textarea
			v-model="context"
			placeholder="내용을 입력해 주세요"
			rows="3"
			max-rows="6"
		></b-form-textarea>
		<b-button @click="updateMode ? updateContent() : uploadContent()"
			>저장</b-button
		>
		<b-button @click="cancle">취소</b-button>
	</div>
</template>
<script>
import { addqQuestion, modifyQuestion, findQuestion } from '@/api/qanda';

export default {
	name: 'Create',
	data() {
		return {
			category: '',
			title: '',
			context: '',
			userId: '',
			createdAt: '',
			updatedAt: '',
			updateObject: null,
			updateMode: this.$route.params.contentId > 0 ? true : false,
			resdata: '',
		};
	},
	async created() {
		if (this.$route.params.contentId > 0) {
			const ret = await findQuestion({
				contentId: Number(this.$route.params.contentId),
			});
			const { data } = ret;
			this.category = data.category;
			this.title = data.title;
			this.context = data.context;
		}
	},
	methods: {
		async uploadContent() {
			let items = this.resdata.Content.sort((a, b) => {
				return b.content_id - a.content_id;
			});
			const content_id = items[0].content_id + 1;
			console.log(content_id);
			// QandA 추가하기
			await addqQuestion({
				contentId: this.contentId,
				uId: this.userId,
				category: this.category,
				title: this.title,
				context: this.context,
			});
			this.$router.push({
				path: '/qanda/',
			});
		},
		async updateContent() {
			await modifyQuestion({
				contentId: Number(this.$route.params.contentId),
				title: this.subject,
				context: this.context,
			});
			this.$router.push({
				path: '/qanda/',
			});
		},
		cancle() {
			this.$router.push({
				path: '/qanda/',
			});
		},
	},
};
</script>
