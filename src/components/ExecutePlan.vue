<template>
<div class="ExecutePlan-container">
    <div class="ExecutePlan-container-header">
        <h1>执行计划</h1>
    </div>
    <div class="ExecutePlan-container-body">
        <el-table :data="ExecutePlanData" style="width: 100%" :header-cell-style="{ background: '#f4f6f8', color: '#000000' ,fontSize: '12px' }">
            <el-table-column prop="id" label="序号" width="50" header-align="center" align="center"/>
            <el-table-column prop="term" label="开课学期" width="100" header-align="center" align="center"/>
            <el-table-column prop="address" label="课程编号" width="80" header-align="center" align="center"/>
            <el-table-column prop="term" label="课程名称" width="150" header-align="center" align="center"/>
            <el-table-column prop="term" label="成绩" width="50" header-align="center" align="center"/>
            <el-table-column prop="term" label="成绩标识" width="100" header-align="center" align="center"/>
            <el-table-column prop="term" label="学分" width="50" header-align="center" align="center" />
            <el-table-column prop="term" label="总学时" width="60" header-align="center" align="center"/>
            <el-table-column prop="term" label="课程绩点" width="90" header-align="center" align="center"/>
            <el-table-column prop="term" label="补重学期" width="100" header-align="center" align="center"/>
            <el-table-column prop="term" label="考核方式" width="100" header-align="center" align="center"/>
            <el-table-column prop="term" label="考试性质" width="100" header-align="center" align="center"/>
            <el-table-column prop="term" label="课程属性" width="100" header-align="center" align="center"/>
            <el-table-column prop="term" label="课程性质" width="100" header-align="center" align="center"/>
            <el-table-column prop="term" label="选通课类别" header-align="center" align="center"/>
        </el-table>
    </div>
</div>
</template>
  
<script>
export default {
    name: 'ExecutePlanPage',
    data(){
        return {
            ExecutePlanData: []
        }
    }
}
</script>
  
<style>
@import "../css/components/ExecutePlan.css";
</style>