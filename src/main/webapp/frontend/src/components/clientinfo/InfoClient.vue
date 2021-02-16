<template>
	<div>
		<table border="1">
			<tr>
				<th>회원 아이디</th>
				<th>이름</th>
				<th>닉네임</th>
				<!-- <th>신고누적횟수</th> -->
				<th>회원상태</th>
			</tr>
			<tr>
				<td>{{ data.id }}</td>
				<td>{{ data.name }}</td>
				<td>{{ data.nickname }}</td>
				<td>{{ data.classification }}</td>
			</tr>
		</table>
	</div>
</template>

<script>
export default {
	data() {
		return {
			data: [],
		};
	},
	name: 'InfoClient',
	methods: {
		clientSession() {
			//const data = sessionStorage.getItem('userinfo');
			this.data = this.$session.get('userinfo');
			this.logMessage = `${this.data.username}님이 접속중입니다.`;
		},
	},
	// 화면 시작 시 clientSession 함수 실행
	beforeMount() {
		this.clientSession();
	},
};
</script>
