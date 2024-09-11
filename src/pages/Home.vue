<template>
    <div class="Home-layout">
        <div class="Header"><HeadList></HeadList></div>
        <div class="Main-container">
          <div class="Aside-Menu"><AsideMenu></AsideMenu></div>
          <div class="Main"><router-view></router-view></div>
        </div>
        
    </div>
</template>
      
<script>
  import HeadList from "@/components/HeadList"
  import AsideMenu from "@/components/AsideMenu.vue";

  export default {
    name: 'HomePage',
    components:{
      HeadList,
      AsideMenu
    }
  }
</script>
  
<style scoped>
.Home-layout {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  overflow: hidden;
  height:100vh;
  width:100%;
}

  
.Header {
  height:6%;
  width:100%;
  background-color:#EEEEEE;
  text-align:center;
  line-height:6%;
}

.Main-container {
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: center;
  height:94%;
  width:100%;
  /* margin-top:6%; */
}

.Aside-Menu {
  height:95%;
  width:20%;
  text-align:center;
  margin-top:10%;
}

.Main {
  height:100%;
  width:80%;
  text-align:center;
  margin-top:13%;
  background-color: white;
}
  
</style>