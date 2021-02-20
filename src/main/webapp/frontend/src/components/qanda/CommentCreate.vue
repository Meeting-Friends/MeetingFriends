<template>
	<b-input-group :prepend="name" class="mt-3">
		<b-form-textarea
			id="textarea"
			v-model="context"
			:placeholder="'코멘트를 달아주세요~!'"
			rows="3"
			max-rows="6"
		></b-form-textarea>
		<b-input-group-append>
			<b-button variant="info" @click="createComment()">작성하기</b-button>
		</b-input-group-append>
	</b-input-group>
</template>
<script>
import { addAnswer } from '@/api/qanda';

export default {
	name: 'CommentCreate',
	props: {
		contentId: Number,
		reloadComment: Function,
	},
	data() {
		return {
			//admin이름으로 작성
			name: 'admin',
			context: '',
		};
	},
	async created() {
		const { userinfo } = await this.$session.get('userinfo');
		console.log(userinfo);
	},
	methods: {
		async createComment() {
			await addAnswer({
				uId: this.userinfo.id,
				commentId: this.contentId,
				context: this.context,
			});
			this.reloadComment();
			this.context = '';
		},
	},
};
</script>
<style scoped>
.comment-create {
	display: flex;
	margin-bottom: 1em;
}
</style>
