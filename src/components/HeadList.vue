<template>
  <div class="HeadList">
    <div class="head-container">
        <div class="school-logo">
          <img src="../assets/index-logo.gif" alt="logo" class="logo">
        </div>  
        <div class="student-info">
          <router-link to="/studentInfoPage" class="headshot-link">
            <div class="headshot">
              <img :src='$store.state.stuHeadshot'>
            </div>
          </router-link>
          <div class="stuInfo">
            <span>{{ $store.state.stuName }}({{ $store.state.stuId }})</span>
          </div>
        </div>
    </div>

    <div class="menu-container">
      <router-link to="/index" class="menu-icon">
        <i class="iconfont icon-home"></i>
      </router-link>
      <router-link class = "menu-item" to="/Desk">我的桌面</router-link>
      <router-link class = "menu-item" to="/Home/Grades/StudentStatusInformation">学籍管理</router-link>
      <router-link class = "menu-item" to="/Home/CoursePlan">培养管理</router-link>
      <router-link class = "menu-item" to="/Home/Exam">考试报名</router-link>
      <router-link class = "menu-item" to="/Home/Evaluation">教学评价</router-link>
    </div>
  </div>
</template>
  
<script>

export default {
  name: 'HeadList',

  data: function(){
    return {

    }
  },

  methods: {
  }
}
</script>
  
<style>
  @import '../css/global.css';
  @import '../css/components/HeadList.css';
</style>