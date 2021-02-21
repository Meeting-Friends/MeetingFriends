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
			// name: 'Signin',
			component: () => import('@/views/Signin.vue'),
		},
		{
			path: '/signup',
			// name: 'Signup',
			component: () => import('@/views/Signup.vue'),
		},
		{
			path: '/waittingroom',
			component: () => import('@/views/WaittingRoom.vue'),
			//	meta: { auth: true },
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
	if (to.meta.auth && !store.getters.isSignin) {
		console.log('인증이 필요합니다');
		next('/signin');
		return;
	}
	next();
});

export default router;
