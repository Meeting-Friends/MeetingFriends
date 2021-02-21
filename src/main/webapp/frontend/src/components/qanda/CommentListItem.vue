<template>
	<div>
		<div class="comment-list-item">
			<div class="comment-list-item-name">
				<div>{{ name }}</div>
				<div>{{ commentObj.created_at }}</div>
			</div>
			<div class="comment-list-item-context">{{ commentObj.context }}</div>
			<div class="comment-list-item-button">
				<b-button variant="info" @click="modifyAnswer">수정</b-button>
				<b-button variant="info" @click="deleteAnswer">삭제</b-button>
			</div>
		</div>
	</div>
</template>
<script>
import { modifyAnswer, deleteAnswer } from '@/api/qanda';

export default {
	name: 'CommentListItem',
	props: {
		commentObj: Object,
	},
	components: {},
	data() {
		// return {
		// 	name: data.User.filter(
		// 		item => item.user_id === this.commentObj.user_id,
		// 	)[0].name,
		// };
	},
	methods: {
		async modifyAnswer() {
			await modifyAnswer({
				commentId: Number(this.$route.aparms.commentId),
				comment: this.comment,
			});
			this.$router.push({
				path: '/qanda/detail',
			});
		},
		async deleteAnswer() {
			await deleteAnswer({
				commentId: Number(this.$route.aparms.commentId),
			});
			this.$router.push({
				path: '/qanda/detail',
			});
		},
	},
};
</script>
<style scoped>
.comment-list-item {
	display: flex;
	justify-content: space-between;
	padding-bottom: 1em;
}
.comment-list-item-name {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	border: 0.5px solid black;
	padding: 1em;
}
.comment-list-item-context {
	display: flex;
	justify-content: center;
	align-items: center;
	width: 50em;
	border: 0.5px solid black;
}
.comment-list-item-button {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	border: 0.5px solid black;
	padding: 1em;
}
.btn {
	margin-bottom: 1em;
}
.comment-list-item-subcomment-list {
	display: flex;
	justify-content: space-between;
	padding-bottom: 1em;
	margin-left: 10em;
}
</style>
