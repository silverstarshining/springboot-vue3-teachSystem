
import { createApp } from 'vue'
import Vuex from 'vuex'

const Vue = createApp({})

Vue.use(Vuex)

export default new Vuex.Store({
    //数据，相当于data
    state: {
      stuName:'',//学生名
      stuId:'',//学号
      stuGender:'',//性别
      stuMajor:'',//专业
      stuAge:0,//年龄
      stuEnrollmentTime:new Date(),//入学时间
      stuAcademic:4,//学制
      stuCurrent_home_address:'',//家庭地址
      stuFaculties:'',//院系
      stuID_Number:'',//身份证号
      stuZipCode:'',//邮编
      stu_phoneNumber:'',//手机号
      stu_homePhone:'',//家庭电话
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
        state.stuId = id;
      },
      setStuGender(state, gender){
        state.stuGender = gender;
      },
      setStuMajor(state, major){
        state.stuMajor = major;
      },
      setStuAge(state, age){
        state.stuAge = age;
      },
      setStuEnrollmentTime(state, time){
        state.stuEnrollmentTime = time;
      },
      setStuAcademic(state, academic){
        state.stuAcademic = academic;
      },
      setStuCurrent_home_address(state,stuCurrent_home_address){
        state.stuCurrent_home_address = stuCurrent_home_address;
      },
      setStuFaculties(state, faculties){
        state.stuFaculties = faculties;
      },
      setStuID_Number(state, ID_Number){
        state.stuID_Number = ID_Number;
      },
      setStuZipCode(state, ZipCode){
        state.stuZipCode = ZipCode;
      },
      setStu_phoneNumber(state, phoneNumber){
        state.stu_phoneNumber = phoneNumber;
      },
      setStu_homePhone(state, homePhone){
        state.stu_homePhone = homePhone;
      },
      setStuHeadshot(state, headshot){
        state.stuHeadshot = headshot;
      },
      setIsLogin(state, isLogin){
        state.isLogin = isLogin;
      },
    },
    // 操作异步操作mutation
    actions: {
      
    },
    modules: {
      
    },
})