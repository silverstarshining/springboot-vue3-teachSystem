<template>
    <div class="courseList-container">
        <div class="week-select">
            <el-select v-model="week" placeholder="选择星期" style="width: 240px; margin:10px;">
                <el-option
                    v-for="date in options"
                    :key="date.value"
                    :label="date.label"
                    :value="date.value"
                />
            </el-select>
        </div>
        <div class="time-table">
            <el-table :data="timetable" style="width: 100%; height: 100%" :span-method="objectSpanMethod"
                        :header-cell-style="{background:'#d9e5fd', color:'black', fontWeight: 1000}"
                        :cell-style="tableCellStyle"
            >
                <el-table-column prop="sjd" label="时间段" width="80" align="center">
                </el-table-column>
                <el-table-column prop="jc" label="节次" width="80" align="center">
                </el-table-column>
                <el-table-column prop="mon" label="星期一"  align="center">
                    <template v-slot:default="scope">
                        <h4>{{ scope.row.mon.title }}</h4>
                        <div v-html="scope.row.mon.content"></div>
                    </template>
                </el-table-column>
                <el-table-column prop="tue" label="星期二" align="center">
                    <template v-slot:default="scope">
                        <h4>{{ scope.row.tue.title }}</h4>
                        <div v-html="scope.row.tue.content"></div>
                    </template>
                </el-table-column>
                <el-table-column prop="wed" label="星期三" align="center">
                    <template v-slot:default="scope">
                        <h4>{{ scope.row.wed.title }}</h4>
                        <div v-html="scope.row.wed.content"></div>
                    </template>
                </el-table-column>
                <el-table-column prop="thu" label="星期四" align="center">
                    <template v-slot:default="scope">
                        <h4>{{ scope.row.thu.title }}</h4>
                        <div v-html="scope.row.thu.content"></div>
                    </template>
                </el-table-column>
                <el-table-column prop="fri" label="星期五" align="center">
                    <template v-slot:default="scope">
                        <h4>{{ scope.row.fri.title }}</h4>
                        <div v-html="scope.row.fri.content"></div>
                    </template>
                </el-table-column>
                <el-table-column prop="sat" label="星期六" align="center">
                    <template v-slot:default="scope">
                        <h4>{{ scope.row.sat.title }}</h4>
                        <div v-html="scope.row.sat.content"></div>
                    </template>
                </el-table-column>
                <el-table-column prop="sun" label="星期日" align="center">
                    <template v-slot:default="scope">
                        <h4>{{ scope.row.sun.title }}</h4>
                        <div v-html="scope.row.sun.content"></div>
                    </template>
                </el-table-column>
            </el-table>
        </div>
    </div>
</template>
  
<script>
    export default {
        name: 'CourseListPage',
        data(){
            return {
                week: '',
                options: [],
                morningLength:5,
                afternoonLength:4,
                Length:14,
                timetable:[],
                events: [],
                hoverOrderArr: [],
                weeks: ['mon', 'tue', 'wed', 'thu', 'fri', 'sat', 'sun']
            }
        },
        created(){
            this.initTimetable();
        },
        mounted(){
            this.mergeData(),
            this.generateOptions()
        },
        watch: {
            events: {
                handler () {
                    this.mergeData()
                },
                deep: true
            },
            week: {
                handler (newVal) {
                    this.getCourseData(newVal)
                }
            }
        },
        methods: {
            //初始化固定表列信息
            initTimetable(){
                this.timetable = [];
                for(let i=0;i<this.Length;i++){
                    let obj = {
                        sjd:'',
                        jc:i+1,
                        mon:{},
                        tue:{},
                        wed:{},
                        thu:{},
                        fri:{},
                        sat:{},
                        sun:{}
                    }
                    if(i<this.morningLength){
                        obj.sjd = "上午";
                    }else if(i<this.morningLength+this.afternoonLength){
                        obj.sjd = "下午";
                    }else{
                        obj.sjd = "晚上";
                    }
                    this.timetable.push(obj);
                }
            },
            //表格单元格样式
            tableCellStyle (row) {
                if (row.row[row.column.property].title !== undefined) {
                    return {'background-color':'rgb(24 144 255 / 80%)', 'color': '#fff', 'border-radius':'10px'};
                }
            },
            mergeData () {
                // 合并数据
                if (this.events.length > 0) {
                    for (let i = 0; i < this.events.length; i++) {
                        // 获取星期几
                        let week = this.weeks[this.events[i].xq - 1];
                        this.timetable[this.events[i].start - 1][week] = this.events[i];
                    }
                }
            },
            objectSpanMethod ({row, rowIndex, columnIndex}) {
                if (columnIndex === 0) {
                    if (rowIndex < this.morningLength) {
                        if(rowIndex === 0){
                            return {
                                rowspan: this.morningLength,
                                colspan: 1
                            };
                        }else{
                            return {
                                rowspan: 0,
                                colspan: 0
                            };
                        }
                    }else if (rowIndex < this.morningLength + this.afternoonLength) {
                        if(rowIndex === this.morningLength){
                            return {
                                rowspan: this.afternoonLength,
                                colspan: 1
                            };
                        }else{
                            return {
                                rowspan: 0,
                                colspan: 0
                            };
                        }
                    }else{
                        if(rowIndex === this.morningLength+this.afternoonLength){
                            return {
                                rowspan: this.Length-this.morningLength-this.afternoonLength,
                                colspan: 1
                            };
                        }else{
                            return {
                                rowspan: 0,
                                colspan: 0
                            };
                        }
                    }
                }
                if (columnIndex === 2) {
                    if (row.mon.title !== undefined) {
                        return {
                            rowspan: row.mon.end - row.mon.start + 1,
                            colspan: 1
                        };
                    } else {
                        return {
                            rowspan: 1,
                            colspan: 1
                        };
                    }
                }
                if (columnIndex === 3) {
                    if (row.tue.title !== undefined) {
                        return {
                            rowspan: row.tue.end - row.tue.start + 1,
                            colspan: 1
                        };
                    } else {
                        return {
                            rowspan: 1,
                            colspan: 1
                        };
                    }
                }
                if (columnIndex === 4) {
                    if (row.wed.title !== undefined) {
                        return {
                            rowspan: row.wed.end - row.wed.start + 1,
                            colspan: 1
                        };
                    } else {
                        return {
                            rowspan: 1,
                            colspan: 1
                        };
                    }
                }
                if (columnIndex === 5) {
                    if (row.thu.title !== undefined) {
                        return {
                            rowspan: row.thu.end - row.thu.start + 1,
                            colspan: 1
                        };
                    } else {
                        return {
                            rowspan: 1,
                            colspan: 1
                        };
                    }
                }
                if (columnIndex === 6) {
                    if (row.fri.title !== undefined) {
                        return {
                            rowspan: row.fri.end - row.fri.start + 1,
                            colspan: 1
                        };
                    } else {
                        return {
                            rowspan: 1,
                            colspan: 1
                        };
                    }
                }
                if (columnIndex === 7) {
                    if (row.sat.title !== undefined) {
                        return {
                            rowspan: row.sat.end - row.sat.start + 1,
                            colspan: 1
                        };
                    } else {
                        return {
                            rowspan: 1,
                            colspan: 1
                        };
                    }
                }
                if (columnIndex === 8) {
                    if (row.sun.title !== undefined) {
                        return {
                            rowspan: row.sun.end - row.sun.start + 1,
                            colspan: 1
                        };
                    } else {
                        return {
                            rowspan: 1,
                            colspan: 1
                        };
                    }
                }
            },
            getCourseData(){
                this.events = [{
                        id: 1,
                        xq: 1,
                        start: 1,
                        end: 3,
                        title: '课程1',
                    },
                    {
                        id: 2,
                        xq: 2,
                        start: 3,
                        end: 5,
                        title: '课程2',
                    }];
            },
            generateOptions(){
                var startYear = new Date(this.$store.state.enrollmentTime[0]).getFullYear();
                var endYear = new Date().getFullYear();
                var term = ['秋季','春季','夏季'];
                var week = [18,18,9];
                var options = [];
                console.log(startYear,endYear,term,week);
                for(let i=startYear;i<=endYear;i++){
                    for(let j=0;j<3;j++){
                        for(let k=0;k<week[j];k++){
                            options.push({
                                value: i+'-'+(i+1)+'-'+(j+1) +' '+ term[j] + ' ' + '第' +(k+1) + '周',
                                label: i+'-'+(i+1)+'-'+(j+1) +' '+ term[j] + ' ' + '第' +(k+1) + '周'
                            });
                        }
                    }
                }
                this.options = options;
                this.week = options[options.length-1].value;
            }

        }
    }
</script>
  
<style>
@import "../css/components/CourseList.css";
</style>