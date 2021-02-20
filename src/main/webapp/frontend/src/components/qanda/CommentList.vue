<template>
	<div>
		<div :key="item.comment_id" v-for="item in comments">
			<CommentListItem :commentObj="item" />
		</div>
		<!-- admin 만 comment할 수 있는 기능 -->
		<div v-if="user.classification == 'admin'">
			<CommentCreate :contentId="contentId" :reloadComment="reloadComment" />
		</div>
	</div>
</template>
<script>
import CommentListItem from './CommentListItem';
import CommentCreate from './CommentCreate';
import { findAnswer } from '@/api/qanda';

export default {
	name: 'CommentList',
	props: {
		contentId: Number, //자식Commentlist가 부모에게서 contentId 전달 받음
	},
	components: {
		CommentListItem,
		CommentCreate,
	},
	async created() {
		const ret = await findAnswer({ content_id: this.contentId });
		this.components = ret.data;
	},
	data() {
		return {
			comments: [],
		};
	},
	methods: {
		async reloadComment() {
			const ret = await findAnswer({ content_id: this.contentId });
			this.components = ret.data;
		},
	},
};
</script>
