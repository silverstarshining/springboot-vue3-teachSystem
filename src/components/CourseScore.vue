<template>
    <div class="courseScore">
        <div class="courseScore-head">
            <el-select v-model=time clearable placeholder="请选择开课学期" style="width: 240px">
                <el-option v-for="item in terms" :key="item.value" :label="item.label" :value="item.value"/>
            </el-select>
        </div>
        <div class="courseScore-main">
            <el-table :data="tableData" 
            style="width: 100%" 
            :border="true" 
            :default-sort="{ prop: 'score', order: 'descending' }" 
            :fit="true"
            :cell-style="{ textAlign: 'center' }"
            :header-cell-style="{ background: '#f4f6f8', color: '#000000' ,textAlign: 'center' }">
                <el-table-column prop="term" label="开课学期" header-align="center" align="center" />
                <el-table-column prop="id" label="课程号" header-align="center" align="center"/>
                <el-table-column prop="name" label="课程名称" header-align="center" align="center" />
                <el-table-column prop="score" label="成绩" header-align="center" align="center" />
                <el-table-column prop="credit" label="学分" header-align="center" align="center" />
                <el-table-column prop="total-hours" label="总学时" header-align="center" align="center" />
                <el-table-column prop="term" label="考核方式" width="100" header-align="center" align="center"/>
                <el-table-column prop="term" label="考试性质" width="100" header-align="center" align="center"/>
                <el-table-column prop="term" label="课程属性" width="100" header-align="center" align="center"/>
                <el-table-column prop="term" label="课程性质" width="100" header-align="center" align="center"/>
                <el-table-column prop="term" label="选通课类别" header-align="center" align="center"/>
            </el-table>
            <div class="courseScore-pagination">
                <el-pagination :current-page="searchPage.currentPage" :page-count="searchPage.pageSize" background layout="prev, pager, next" @current-change="getData"   />
            </div>
        </div>
    </div>
</template>
  
<script>


  export default {
    name: 'CourseScore',
    data() {
        return {
            terms:[],
            tableData:[],
            scores:[],
            searchPage:{
                currentPage:1,
                pageSize:13
            },
            time:''
        }
    },

    mounted() {
        this.getTerms();
        this.getScores();
    },

    methods:{
        getTerms(){
            var date = new Date();
            var year = date.getFullYear();
            while(year!=2000){
                this.terms.push({
                    value:year+'-'+(year+1)+'-'+1,
                    label:year+'-'+(year+1)+'-'+1
                });
                this.terms.push({
                    value:year+'-'+(year+1)+'-'+2,
                    label:year+'-'+(year+1)+'-'+2
                });
                this.terms.push({
                    value:year+'-'+(year+1)+'-'+3,
                    label:year+'-'+(year+1)+'-'+3
                });
                year--;
            }
        },

        getData(val = 1){
            this.searchPage.currentPage = val;
            this.addTableData();
            this.pageQuery(this.searchPage.currentPage,this.searchPage.pageSize);
        },

        addTableData(){
            this.tableData = [];
            for(var i=0;i<this.scores.length;i++){
                this.tableData.push({
                    'term':this.scores[i]['term'],
                    'id':this.scores[i]['id'],
                    'name':this.scores[i]['name'],
                   'score':this.scores[i]['score'],
                    'credit':this.scores[i]['credit'],
                    'total-hours':this.scores[i]['total-hours']
                });
            }
        },

        pageQuery(currentPage,pageSize){
            
            let start = (currentPage - 1) * pageSize;
            let end = start + pageSize;
            let data = this.tableData.slice(start, end);
            console.log(this.tableData);
            console.log(currentPage,pageSize)
            console.log(data);
            this.tableData = data;
        },

        getScores(){
            this.scores=[];
            if(this.time==='学期'){
                for(var i=0;i<100;i++){
                    this.scores.push({
                        'term':this.time,
                        'id':i,
                        'name':'高等数学',
                        'score':59,
                        'credit':3,
                        'total-hours':10
                    });
                }
            }else{
                for(i=0;i<100;i++){
                    this.scores.push({
                        'term':this.time,
                        'id':i,
                        'name':'高等数学',
                        'score':59,
                        'credit':3,
                        'total-hours':10
                    });
                }
            }
            this.getData();
        }
    },

    watch:{
        time(){
            this.getScores();
        }
    }
  }
</script>
  
<style>
@import '../css/components/courseScore.css'
  
</style>