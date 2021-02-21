<template>
	<div id="QandAlist">
		<div class="qtableplace">
			<b-table
				striped
				hover
				:items="items"
				:fields="fields"
				@row-clicked="rowClick"
			></b-table>
		</div>
		<div class="qnainsertbtn">
			<b-button @click="writeContent">질문작성</b-button>
		</div>
	</div>
</template>

<script>
import { fetchqandalist } from '@/api/qanda';

export default {
	name: 'QandAList',
	async created() {
		const ret = await fetchqandalist();
		this.items = ret.data;
	},
	data() {
		return {
			//필드정보 확인
			fields: [
				{
					key: 'contentId',
					label: '번호',
				},
				{
					key: 'title',
					label: '제목',
				},
				{
					key: 'createdAt',
					label: '작성일',
				},
				{
					key: 'uId',
					label: '작성자',
				},
			],
			//데이터 받아오기
			items: [],
		};
	},
	methods: {
		rowClick(item, index, e) {
			this.$router.push({
				path: `/qanda/detail/${item.content_id}`,
			});
			console.log(index);
			console.log(e);
		},
		writeContent() {
			this.$router.push({
				path: '/qanda/create',
			});
		},
	},
	components: {},
};
</script>
