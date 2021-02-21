<template>
	<div>
		<div class="jb-box">
			<video muted autoplay loop>
				<source src="../video/BACKGROUND.mp4" type="video/mp4" />
				<strong>Your browser does not support the video tag.</strong>
			</video>
			<div class="jb-text">
				<SigninForm></SigninForm>
			</div>
		</div>
	</div>
</template>

<script>
import SigninForm from '@/components/SigninForm.vue';

export default {
	components: {
		SigninForm,
	},
};
</script>

<style></style>
