<template>
    <div class="student-status-information">
      <el-descriptions direction="vertical" :column="4" :size="size" border >
        <el-descriptions-item label="学号">kooriookami</el-descriptions-item>
        <el-descriptions-item label="电话号">19506167976</el-descriptions-item>
        <el-descriptions-item label="院系" :span="2">青岛软件学院，计算机科学与技术学院</el-descriptions-item>
        <el-descriptions-item label="专业">
          <span>软件工程</span>
        </el-descriptions-item>

        <el-descriptions-item label="出生日期">
          <span>2000-01-01</span>
        </el-descriptions-item>
        <el-descriptions-item label="入学日期"> 2020-09-01 </el-descriptions-item>
        <el-descriptions-item label="家庭现住址"> 青岛市市南区 </el-descriptions-item>
        <el-descriptions-item label="家庭电话"> 19506167976 </el-descriptions-item>
        <el-descriptions-item label="身份证编号"> 42010219900101001X </el-descriptions-item>
        <el-descriptions-item label="民族"> 42010219900101001X </el-descriptions-item>
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