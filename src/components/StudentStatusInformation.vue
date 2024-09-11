<template>
    <div class="student-status-information">
      <el-descriptions direction="vertical" :column="5" border >
        <el-descriptions-item :rowspan="4" :width="140" label="Photo" align="center">
            <el-image style="width: 100px; height: 100px" src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"/>
        </el-descriptions-item>
        <el-descriptions-item label="学号">{{ $store.state.stuId }}</el-descriptions-item>
        <el-descriptions-item label="姓名">{{ $store.state.stuName }}</el-descriptions-item>
        <el-descriptions-item label="院系" :span="2">{{ $store.state.stuFaculties }}</el-descriptions-item>
        <el-descriptions-item label="专业">{{ $store.state.stuMajor }}</el-descriptions-item>
        <el-descriptions-item label="年龄">{{ $store.state.stuAge }}</el-descriptions-item>
        <el-descriptions-item label="性别">{{ $store.state.stuGender }}</el-descriptions-item>
        <el-descriptions-item label="电话号">{{ $store.state.stu_phoneNumber }}</el-descriptions-item>
        <el-descriptions-item label="入学日期">{{ $store.state.stuEnrollmentTime }}</el-descriptions-item>
        <el-descriptions-item label="身份证编号">{{ $store.state.stuID_Number }}</el-descriptions-item>
        <el-descriptions-item label="家庭电话">{{ $store.state.stu_homePhone }}</el-descriptions-item>
        <el-descriptions-item label="邮编">{{ $store.state.stuZipCode }}</el-descriptions-item>
        <el-descriptions-item label="家庭现住址" :colspan="4">{{ $store.state.stuCurrent_home_address }}</el-descriptions-item>
      </el-descriptions>
    </div>
</template>
  
<script>
  export default {
    name: 'StudentStatusInformationPage',
    data() {
      return {
        
        }
    }
  }
</script>
  
<style>
  
  @import url('../css/global.css')
</style>