<template>
  <div class="MenuForm">
    <div class="blocks-container1">
      <div class="block1">
          <img src="../assets/myInfo.png" alt="个人信息图">
          <div class="block1-text">
            <p>姓名：{{ $store.state.studentName }}</p>
            <p>学号：{{ $store.state.studentId }}</p>
          </div>
          <div class="block1-title">个人信息</div>
          <div class="img-code"><img src="../assets/app.png" alt="code"></div>
      </div>

      <router-link class="block2-link">
        <div class="block2">
            <img src="../assets/tp2.png" alt="选课中心">
            <div class="block2-title">选课中心</div>
        </div>
      </router-link>

      <div class="line3">
        <router-link class="block3-link">
          <div class="block3">
            <img src="../assets/tp3.png" alt="学期理论课表">
            <div class="block3-title">学期理论课表</div>
          </div>
        </router-link>

        <router-link class="block4-link">
          <div class="block4">
            <img src="../assets/tp4.png" alt="培养方案">
            <div class="block4-title">培养方案</div>
          </div>
        </router-link>
      </div>

      
        <div class="line4">
          <router-link class="block5-link">
            <div class="block5">
              <img src="../assets/tp5.png" alt="学习完成情况">
              <div class="block5-title">学习完成情况</div>
            </div>
          </router-link>

          <router-link class="block6-link">
            <div class="block6">
              <img src="../assets/tp6.png" alt="学生评价">
              <div class="block6-title">学生评价</div>
          </div>
          </router-link>
        </div>
      </div>

      <div class="blocks-container2">
        <router-link class="block7-link">
          <div class="block7">
            <img src="../assets/tp7.png" alt="课程成绩查询">
            <div class="block7-title">课程成绩查询</div>
          </div>
        </router-link>

        <router-link class="block8-link">
          <div class="block8">
            <img src="../assets/tp8.png" alt="课表查询">
            <div class="block8-title">课表查询</div>
          </div>
        </router-link>

        <router-link class="block9-link">
          <div class="block9">
            <img src="../assets/tp9.png" alt="补考报名">
            <div class="block9-title">补考报名</div>
          </div>
        </router-link>

        <router-link class="block10-link">
          <div class="block10">
            <img src="../assets/tp10.png" alt="考试成绩">
            <div class="block10-title">考试成绩</div>
          </div>
        </router-link>

        <router-link class="block11-link">
          <div class="block11">
            <img src="../assets/tp11.png" alt="学籍卡片">
            <div class="block11-title">学籍卡片</div>
          </div>
        </router-link>

        <router-link class="block12-link">
          <div class="block12">
            <img src="../assets/tp12.png" alt="缓考申请">
            <div class="block12-title">缓考申请</div>
          </div>
        </router-link>
      </div>
  </div>
    
</template>

<script>
  export default {
    name: 'MenuForm'
  }
</script>

<style scoped>
  @import '../css/components/MenuForm.css';
</style>