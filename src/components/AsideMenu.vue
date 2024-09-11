<template>
    <div class="AsideMenu-container">
        <div class="menu">
            <el-menu default-active="2" :style="{height: '100%'}"  class="el-menu-vertical-demo" :unique-opened="true" @select="handleLink" >
                
                <el-sub-menu index="Grades">
                    <template #title>
                        <span>学籍成绩</span>
                    </template>
                    <el-menu-item index="StudentStatusInformation">学籍信息</el-menu-item>
                    <el-menu-item index="courseScore">课程成绩</el-menu-item>
                    <el-menu-item index="GradedExams">等级考试</el-menu-item>
                    <el-menu-item index="LearnComplete">学习完成</el-menu-item>
                </el-sub-menu>

                <el-sub-menu index="CultivationManagement">
                    <template #title>
                        <span>培养管理</span>
                    </template>
                    <el-menu-item index="ExecutePlan">执行计划</el-menu-item>
                    <el-menu-item index="CourseList">学期理论课表</el-menu-item>
                    <el-menu-item index="CourseSelectionCenter">学生选课中心</el-menu-item>
                    <el-menu-item index="2-4">学生选课信息</el-menu-item>
                </el-sub-menu>

                <el-sub-menu index="menu-list3">
                    <template #title>
                        <span>考试报名</span>
                    </template>
                    <el-menu-item index="3-1">考试报名</el-menu-item>
                </el-sub-menu>

                <el-sub-menu index="menu-list4">
                    <template #title>
                        <span>教学评价</span>
                    </template>
                    <el-menu-item index="4-1">教学评价</el-menu-item>
                </el-sub-menu>
                
            </el-menu>
        </div>
    </div>
</template>
  
<script>

  export default {
    name: 'AsideMenu',
    data(){
        return {
           
        }
    },
    methods:{
        handleLink(key,keyPath){
            var path = '/Home/' + keyPath.join('/');
            console.log(path);
            this.$router.push(path);
        }
    }
  }
</script>
  
<style scoped>

     @import '../css/components/AsideMenu.css'
  
</style>