import { createApp } from 'vue'
import Vuex from 'vuex'

const Vue = createApp({})

Vue.use(Vuex)

export default new Vuex.Store({
    //数据，相当于data
    state: {
      stuName:'',
      stuId:'',
      stuGender:'',
      stuMajor:'',
      stuAge:0,
      enrollmentTime:'',
      Academic:4,
      stuHeadshot:require('@/assets/test/headshot1.jpg'),
      isLogin:false
    },
    getters: {
      
    },
    //里面定义方法，操作state方法
    mutations: {
      //设置学生名
      setStuName(state, name){
        state.stuName = name;
      },
      setStuId(state, id){
        state.stutId = id;
      },
      setStuGender(state, gender){
        state.stutGender = gender;
      },
      setStuMajor(state, major){
        state.stuMajor = major;
      },
      setStuAge(state, age){
        state.stuAge = age;
      },
      setEnrollmentTime(state, time){
        state.enrollmentTime = time;
      },
      setAcademic(state, academic){
        state.Academic = academic;
      },
      setStuHeadshot(state, headshot){
        state.stuHeadshot = headshot;
      },
      setIsLogin(state, isLogin){
        state.isLogin = isLogin;
      }
    },
    // 操作异步操作mutation
    actions: {
      
    },
    modules: {
      
    },
})