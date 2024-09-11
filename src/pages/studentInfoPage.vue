<template>
  <div class="studentInfoPage-common-layout">
    <div class="container">
        <div class="Header"><HeadList></HeadList></div>
        <div class="main"><stuInfoMain></stuInfoMain></div>
    </div>
  </div>
</template>
    
<script>
  import HeadList from '../components/HeadList.vue';
  import stuInfoMain from '../components/stuInfoMain.vue'
  
  export default {
    name: 'studentInfoPage',
    components:{
      HeadList,
      stuInfoMain
    }
  }
</script>

<style scoped>

.studentInfoPage-common-layout{
  background-color: #FAFCFF;
}

.studentInfoPage-common-layout .Header{
    height:6%;
    width:100%;
    background-color:#EEEEEE;
    text-align:center;
    line-height:6%;
}

.studentInfoPage-common-layout .main{
    margin-top:6%;
    height:100%;
    width:80%;
    padding: 0%;
    margin-left:auto;
    margin-right:auto;
    text-align:center;
}

</style>
