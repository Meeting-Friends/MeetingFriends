<template>
	<!-- Button trigger modal -->
	<div id="modal-NewRoom">
		<button
			type="button"
			class="btn btn-primary btn-lg"
			data-toggle="modal"
			data-target="#modelId1"
		>
			채팅룸 만들기
		</button>

		<!-- Modal -->
		<div
			class="modal fade"
			id="modelId1"
			tabindex="-1"
			role="dialog"
			aria-labelledby="modelTitleId"
			aria-hidden="true"
		>
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">채팅룸 만들기</h5>
						<button
							type="button"
							class="close"
							data-dismiss="modal"
							aria-label="Close"
						>
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<NewRoom />
					</div>
					<div class="modal-footer" />
				</div>
			</div>
		</div>
	</div>
</template>

<script>
import NewRoom from './MeetingroomAddForm.vue';

export default {
	name: 'ModalNewRoom',
	components: {
		NewRoom,
	},
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
	margin: 40px 0 0;
}
ul {
	list-style-type: none;
	padding: 0;
}
li {
	display: inline-block;
	margin: 0 10px;
}
a {
	color: #42b983;
}
</style>
