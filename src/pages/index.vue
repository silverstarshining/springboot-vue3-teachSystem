<template>
  <div class="index">
    <div class="header">
      <HeadList></HeadList>
    </div>
    <div class="main">
      <MenuForm></MenuForm>
    </div>
  </div> 
</template>
  
<script>
import MenuForm from '../components/MenuForm.vue';
import HeadList from '../components/HeadList.vue';

export default {
  name: 'IndexPage',
  components:{
    HeadList,
    MenuForm
  },
  methods: {
    // 加载学生信息,包括姓名，学号，头像
    loadStudentInfo() {
      this.$store.commit('getStudentInfo');
    }
  }
}
</script>
  
<style>
  @import '../css/global.css';
  @import '../css/pages/index.css';
</style>