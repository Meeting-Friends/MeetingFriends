import Vue from 'vue';
import VueRouter from 'vue-router';
import store from '@/store/index';

Vue.use(VueRouter);

const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes: [
		{
			path: '/',
			redirect: '/signin',
		},
		{
			path: '/signin',
			component: () => import('@/views/Signin.vue'),
		},
		{
			path: '/signup',
			component: () => import('@/views/Signup.vue'),
		},
		{
			path: '/admin',
			component: () => import('@/views/Admin.vue'),
		},
		{
			path: '/waittingroom',
			component: () => import('@/views/WaittingRoom.vue'),
		},
		{
			path: '/qanda',
			name: 'QandA',
			component: () => import('@/components/qanda/QandA.vue'),
		},

		{
			path: '/qanda/detail/:contentId',
			name: 'QandADetail',
			component: () => import('@/components/qanda/QandADetail.vue'),
		},
		{
			path: '/qanda/create/:contentId?',
			name: 'Create',
			component: () => import('@/components/qanda/Create.vue'),
		},
		{
			path: '*',
			component: () => import('@/views/NotFoundPage.vue'),
		},
	],
});

router.beforeEach((to, from, next) => {
	if (!store.getters.isSignin) {
		console.log('인증이 필요합니다');
		next('/signin');
		return;
	}
	next();
});

export default router;
