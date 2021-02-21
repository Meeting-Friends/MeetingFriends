<template>
	<div>
		<div class="jb-box">
			<video muted autoplay loop>
				<source src="../video/BACKGROUND.mp4" type="video/mp4" />
				<strong>Your browser does not support the video tag.</strong>
			</video>
			<div class="jb-text">
				<SignupForm></SignupForm>
			</div>
		</div>
	</div>
</template>

<script>
import SignupForm from '@/components/SignupForm.vue';

export default {
	components: {
		SignupForm,
	},
};
</script>

<style></style>
