<template>
	<div id="QandAlist">
		<b-table
			striped
			hover
			:items="items"
			:fields="fields"
			@row-clicked="rowClick"
		></b-table>
		<b-button @click="writeContent">질문작성</b-button>
	</div>
</template>

<script>
import { fetchqandalist } from '@/api/qanda';

export default {
	name: 'QandAList',
	async create() {
		const ret = await fetchqandalist();
		this.items = ret.data;
	},
	data() {
		return {
			//필드정보 확인
			fields: [
				{
					key: 'content_id',
					label: '번호',
				},
				{
					key: 'title',
					label: '제목',
				},
				{
					key: 'created_at',
					label: '작성일',
				},
				{
					key: 'user_name',
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
