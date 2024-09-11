<template>
    <div class="LearnComplete">
      <div class="LearnComplete-echarts-container">
        <div class="LearnComplete-all-score">
          <el-row>
            <el-col :span="6">
              <el-statistic :value="82">
                <template #title>
                  <div style="display: inline-flex; align-items: center">
                    总学分完成情况
                  </div>
                </template>
                <template #suffix>/100</template>
              </el-statistic>
            </el-col>

            <el-col :span="6">
              <el-statistic :value="82">
                <template #title>
                  <div style="display: inline-flex; align-items: center">
                    必选课完成情况
                  </div>
                </template>
                <template #suffix>/100</template>
              </el-statistic>
            </el-col>

            <el-col :span="6">
              <el-statistic :value="82">
                <template #title>
                  <div style="display: inline-flex; align-items: center">
                    选修课完成情况
                  </div>
                </template>
                <template #suffix>/100</template>
              </el-statistic>
            </el-col>

            <el-col :span="6">
              <el-statistic :value="82">
                <template #title>
                  <div style="display: inline-flex; align-items: center">
                    公选课完成情况
                  </div>
                </template>
                <template #suffix>/100</template>
              </el-statistic>
            </el-col>
          </el-row>
        </div>
      </div>
      <el-divider></el-divider>
      <div class="LearnComplete-main">
        <div class="LearnComplete-title">必选课</div>
        <div class="LearnComplete-table">
              <el-table :data="tableData" style="width: 100%" fit>
                <el-table-column prop="courseName" label="课程名称"></el-table-column>
                <el-table-column prop="courseCredit" label="学分"></el-table-column>
                <el-table-column prop="courseGrade" label="成绩"></el-table-column>
                <el-table-column prop="courseGrade" label="完成情况"></el-table-column>
              </el-table>
        </div>
        <div class="LearnComplete-title">选修课</div>
        <div class="LearnComplete-table">
              <el-table :data="tableData" style="width: 100%" fit>
                <el-table-column prop="courseName" label="课程名称"></el-table-column>
                <el-table-column prop="courseCredit" label="学分"></el-table-column>
                <el-table-column prop="courseGrade" label="成绩"></el-table-column>
                <el-table-column prop="courseGrade" label="完成情况"></el-table-column>
              </el-table>
        </div>
        <div class="LearnComplete-title">公选课</div>
        <div class="LearnComplete-table">
              <el-table :data="tableData" style="width: 100%" fit>
                <el-table-column prop="courseName" label="课程名称"></el-table-column>
                <el-table-column prop="courseCredit" label="学分"></el-table-column>
                <el-table-column prop="courseGrade" label="成绩"></el-table-column>
                <el-table-column prop="courseGrade" label="完成情况"></el-table-column>
              </el-table>
        </div>
      </div>
    </div>
</template>
  
<script>

  export default {
    name: 'LearnCompletePage',
    data() {
      return {
        tableData: [  
          {
            courseName: '大学物理',
            courseCredit: 3,
            courseGrade: '95',
            courseStatus: '已完成'
          },
          {
            courseName: '大学英语',
            courseCredit: 3,
            courseGrade: '85',
            courseStatus: '已完成'
          },
          {
            courseName: '大学语文',
            courseCredit: 3,
            courseGrade: '90',
            courseStatus: '已完成'
          },
          {
            courseName: '大学历史',
            courseCredit: 3,
            courseGrade: '80',
            courseStatus: '已完成'
          },
          {
            courseName: '大学地理',
            courseCredit: 3,
            courseGrade: '85',
            courseStatus: '已完成'
          },
          {
            courseName: '大学生物',
            courseCredit: 3,
            courseGrade: '85',
            courseStatus: '已完成'
          },
          {
            courseName: '大学政治',
            courseCredit: 3,
            courseGrade: '85',
            courseStatus: '已完成'
          }
        ]
      }
    }
  }
</script>
  
<style>
@import '../css/components/LearnComplete.css';
</style>
  