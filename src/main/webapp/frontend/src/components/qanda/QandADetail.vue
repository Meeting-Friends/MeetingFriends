<template>
	<div>
		<b-card>
			<div class="content-detail-content-info">
				<div class="content-detail-content-info-left">
					<div class="content-detail-content-info-left-number">
						{{ contentId }}
					</div>
					<div class="content-detail-content-info-left-subject">
						{{ title }}
					</div>
				</div>
				<div class="content-detail-content-info-right">
					<div class="content-detail-content-info-right-user">
						글쓴이: {{ user }}
					</div>
					<div class="content-detail-content-info-right-created">
						등록일: {{ created }}
					</div>
				</div>
			</div>
			<div class="content-detail-content">
				{{ context }}
			</div>
			<div class="content-detail-button">
				<b-button variant="primary" @click="updateData">수정</b-button>
				<b-button variant="success" @click="deleteData">삭제</b-button>
			</div>
			<!-- 댓글기능구현 자식인 CommentList로 contentId 전달-->
			<div class="content-detail-comment">
				<CommentList :contentId="contentId" />
			</div>
		</b-card>
	</div>
</template>

<script>
import CommentList from './CommentList';
import { deleteQuestion, findQuestion } from '@/api/qanda';

export default {
	name: 'QandADetail',
	components: {
		CommentList,
	},
	async created() {
		const ret = await findQuestion({
			content_id: Number(this.$route.params.contentId),
		});
		const { data } = ret;
		this.title = data.title;
		this.context = data.context;
		this.user = data.user_name;
		this.created = data.created;
	},
	data() {
		const contentId = Number(this.$route.params.contentId);
		return {
			contentId: contentId,
			title: '',
			context: '',
			user: '',
			created: '',
		};
	},
	methods: {
		async deleteData() {
			await deleteQuestion(this.contentId);
			this.$router.push({
				path: `/qanda`,
			});
		},
		async updateData() {
			this.$router.push({
				path: `/qanda/create/${this.contentId}`,
			});
		},
	},
};
</script>
<style scoped>
.content-detail-content-info {
	border: 1px solid black;
	display: flex;
	justify-content: space-between;
}
.content-detail-content-info-left {
	width: 720px;
	display: flex;
	flex-direction: row;
	justify-content: space-between;
	align-items: center;
	padding: 1rem;
}
.content-detail-content-info-right {
	width: 300px;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	padding: 1rem;
}
.content-detail-content {
	border: 1px solid black;
	margin-top: 1rem;
	padding-top: 1rem;
	min-height: 720px;
}
.content-detail-button {
	border: 1px solid black;
	margin-top: 1rem;
	padding: 2rem;
}
.content-detail-comment {
	border: 1px solid black;
	margin-top: 1rem;
	padding: 2rem;
}
</style>
