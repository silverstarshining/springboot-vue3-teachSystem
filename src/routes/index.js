import { createRouter,createWebHistory} from 'vue-router'
import store from '../store/index.js'

import IndexPage from '../pages/index.vue'
import studentInfoPage from '../pages/studentInfoPage.vue'
import HomePage from '../pages/Home.vue'
import LoginPage from '../pages/Login.vue'
import StudentStatusInformationPage from '../components/StudentStatusInformation.vue'
import CourseScore from '../components/CourseScore.vue'
import GradedExamsPage from '@/components/GradedExams.vue'
import LearnCompletePage from '@/components/LearnComplete.vue'
import ExecutePlanPage from '@/components/ExecutePlan.vue'
import CourseListPage from '@/components/CourseList.vue'
import CourseSelectionCenterPage from '@/components/CourseSelectionCenter.vue'

const router = createRouter({
    mode:'hash',
    history: createWebHistory(),
    routes:[
        {path:'/', redirect:'/login'},
        {path:'/login',component: LoginPage},
        {path:'/index',component: IndexPage , meta: { requiresAuth: true }},
        {path:'/studentInfoPage',component: studentInfoPage, meta: { requiresAuth: true }},
        {path:'/Desk',redirect:'/index', meta: { requiresAuth: true }},
        {path:'/Home',component: HomePage,meta: { requiresAuth: true }, children:[
            {path: '',meta: { requiresAuth: true }},
            {path:'Grades/StudentStatusInformation', component:StudentStatusInformationPage,meta: { requiresAuth: true }},
            {path:'Grades/courseScore', component:CourseScore ,meta: { requiresAuth: true }},
            {path:'Grades/GradedExams',component:GradedExamsPage,meta: { requiresAuth: true }},
            {path:'Grades/LearnComplete',component:LearnCompletePage,meta: { requiresAuth: true }},
            {path:'CultivationManagement/ExecutePlan',component:ExecutePlanPage,meta: { requiresAuth: true }},
            {path:'CultivationManagement/CourseList',component:CourseListPage,meta: { requiresAuth: true }},
            {path:'CultivationManagement/CourseSelectionCenter',component:CourseSelectionCenterPage,meta: { requiresAuth: true }},
            {path:'Evaluation'}
        ]}
    ]
})

//守卫路由，防止未登陆异常跳转
router.beforeEach((to, from, next) => {
    if (to.meta.requiresAuth && !store.state.isLogin) {
      next('/login');
    } else {
      next();
    }
});

export default router;