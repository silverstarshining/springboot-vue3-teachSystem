<template>
    <div class="stuInfoMain-common-layout">
        <div class="Main">
              <div class="info-container">
                <h2 class="button-title">个人信息</h2>
                <div class="headshot-container" @click="centerDialogVisible = true">
                  <img :src="this.$store.state.studentHeadshot" alt="学生头像" class="headshot">
                </div>
                <div class="headshot-dialog">
                  <el-dialog v-model="centerDialogVisible" title="修改头像"  center="true">
                    <div class="headshot-dialog-edit">

                      <div class="headshot-upload">
                        <div class="avatar-uploader">

                          <div class="headshot-cut-container"   v-if="user_upload_image_url"  ref="avatarUploaderIconDom" @mousedown="handleMouseDown($event)" @mousemove="handleMouseMove($event)" @mouseup="handleMouseUp($event)"  @mousewheel.prevent="rollImg">
                            <img id="mask-img" :src="user_upload_image_url" class="avatar" ref="maskImg"/>
                            <div class="clear-img-container" ref="clearImgContainer">
                              <img id="clear-img" :src="user_upload_image_url" class="avatar" ref="clearImg"/>
                            </div>
                          </div>
                          <div v-else class="avatar-uploader-icon">
                            <el-icon><Plus /></el-icon>
                          </div>
                        </div>
                      </div>

                      <div class="headshot-show">
                            <img id="show-img" :src="user_upload_image_url" ref="showImg"/>
                      </div>
                      
                    </div>
                    <template #footer>
                      <div class="dialog-footer">
                        <el-button type="primary" @click="cancel">取 消</el-button>
                        <el-button type="primary"><label class="input-file-button" for="upload"></label>上 传</el-button>&nbsp;
                        <input type="file" @change="upload" accept="image/*" id="upload"> 
                        <el-button type="success" @click="save">保 存</el-button>
                      </div>
                    </template>
                  </el-dialog>
                </div>
                <div class="changeinfoFrom">
                  <button @click="handleClick" class="change-info-btn">
                    <i :class="['iconfont', isShowChangeInfo ? 'icon-up-line-free' : 'icon-down-line-free']"></i>
                  </button>
                  <div class="info_input_container" ref="info_input_container">
                    <input type="text" disabled :placeholder=$store.state.studentId />
                    <input type="text" :placeholder=$store.state.studentName :model='this.changeInfoForm.name' />
                    <input type="password" placeholder='请输入想要修改的密码' :model='this.changeInfoForm.password' />
                    <input type="password" placeholder='请再次输入密码' :model='this.repeatPassword' />
                  </div>
                </div>
              </div>
              <div class="echarts-container">
                <div class="Radar-and-Line-echarts-container">
                    <div  class="Radar-echarts-container">
                      <div class="Radar-echarts" ref="Radar-echarts-dom">
                      </div>
                  </div>
                  <div class="Line-echarts-container">
                    <div class="Line-echarts" ref="Line-echarts-dom">

                    </div>
                  </div>
                </div>
                <div  class="HorizontalBar-echarts-container">
                  <div class="HorizontalBar-echarts" ref="HorizontalBar-echarts-dom" >

                  </div>
                </div>
              </div>
        </div>
    </div>
    
</template>
      
<script>
import { getRadarChart,getHorizontalBarChart,getLineChart} from '../echarts';

    
    export default {
      name: 'stuInfoMain',
      data: function(){
        return {
          radarChartInstance: null,
          horizontalBarChartInstance: null,
          lineChartInstance: null,
          changeInfoForm:{
            name:'',
            psssword:''
          },
          repeatPassword:'',
          isShowChangeInfo:false,
          centerDialogVisible: false,
          user_upload_image:null,
          user_upload_image_url:null,
          handleMouse:false,
          scale:1,

        }
      },

      mounted() {
        this.initRadarChart();
        var container = this.$refs['info_input_container'];
        container.classList.add('info_input_container_anamation');
      },

      methods: {
        /* 初始化雷达图和水平柱状图 */
        initRadarChart(){
          var option_radar = getRadarChart();
          var option_horizontalBar = getHorizontalBarChart();
          this.horizontalBarChartInstance = this.$echarts.init(this.$refs['HorizontalBar-echarts-dom']);
          this.horizontalBarChartInstance.setOption(option_horizontalBar);
          this.radarChartInstance = this.$echarts.init(this.$refs['Radar-echarts-dom']);
          this.radarChartInstance.setOption(option_radar);
          this.lineChartInstance = this.$echarts.init(this.$refs['Line-echarts-dom']);
          this.lineChartInstance.setOption(getLineChart());
        },
        /* 展开修改个人信息界面的按钮功能 */
        handleClick(){
          this.isShowChangeInfo = !this.isShowChangeInfo;
          var container = this.$refs['info_input_container'];
          if(this.isShowChangeInfo){
            container.style.animation = 'info_input_container_open_animation 1s forwards';
            container.style.height = '300px';
          }
          else{   
            container.style.animation = '';
            container.style.animation = 'info_input_container_close_animation 1s forwards';
          }
        },

        /*根据图像长宽自动改变容器长宽*/
        changeImgBox(width,height,box){
          if (!box || !(box instanceof HTMLElement)) {
            console.error('无效的容器元素');
            return;
          }
          var imageRatio = width / height;
          if(width > height){
            box.style.width = box.width+'px';
            box.style.height = (box.width / imageRatio)+'px';
          }else{
            box.style.height = box.height+'px';
            box.style.width = (box.height * imageRatio)+'px';
          }
          
        },

        /*鼠标按下将方框移到当前点坐标，并开始移动*/
        handleMouseDown(e){
          this.handleMouse = true;
          e.preventDefault();
          var a = this.scale*100;
          if(this.scale>1){
            a = this.scale*(100+(this.scale-1)*100);
          }
          console.log(a);
          var x = Math.min(-e.clientX+675,0); x = Math.max(x,-a);
          var y = Math.min(-e.clientY+300,0); y = Math.max(y,-a);
          var x1 = -x;
          var y1 = -y;
          var clearImgContainer = this.$refs['clearImgContainer'];
          var clearImg = document.getElementById('clear-img');
          var showImg = this.$refs['showImg'];
          clearImgContainer.style.left = x1 + 'px';
          clearImgContainer.style.top = y1 + 'px';
          clearImg.style.transform = 'translate(' + x + 'px,' + y + 'px)';
          showImg.style.transform = 'translate(' + x + 'px,' + y + 'px)';
          
        },

        /*鼠标松开停止移动*/
        handleMouseUp(e){
          e.preventDefault();
          this.handleMouse = false;
        },

        /*移动鼠标改变选中位置*/
        handleMouseMove(e){
          e.preventDefault();
          if(!this.handleMouse){
            return;
          }
          
          var a = this.scale*100;
          if(this.scale>1){
            a = this.scale*(100+(this.scale-1)*100);
          }
          console.log(a);
          var x = Math.min(-e.clientX+675,0); x = Math.max(x,-a);
          var y = Math.min(-e.clientY+300,0); y = Math.max(y,-a);
          var x1 = -x;
          var y1 = -y;
          var clearImgContainer = this.$refs['clearImgContainer'];
          var clearImg = document.getElementById('clear-img');
          var showImg = this.$refs['showImg'];
          clearImgContainer.style.left = x1 + 'px';
          clearImgContainer.style.top = y1 + 'px';
          clearImg.style.transform = 'translate(' + x + 'px,' + y + 'px)';
          showImg.style.transform = 'translate(' + x + 'px,' + y + 'px)';
          
        },

        /*鼠标滚轮滚动图片*/
        rollImg(e){
          e.preventDefault();
          var maskImg = this.$refs['maskImg'];
          var clearImg = this.$refs['clearImg'];
          var showImg = this.$refs['showImg'];
          if(e.wheelDelta>0){
            this.scale+=0.05
          }else{
            this.scale-=0.05
          }
          maskImg.style.width = this.scale*250 + 'px';
          maskImg.style.height = this.scale*250 + 'px';
          clearImg.style.width = this.scale*250 + 'px';
          clearImg.style.height = this.scale*250 + 'px';
          showImg.style.width = this.scale*250 + 'px';
          showImg.style.height = this.scale*250 + 'px';
          
        },

        /*上传头像*/
        upload(event){
          var file = event.target.files[0];
          if (!file && !file.type.startsWith('image/jpg') && !file.type.startsWith('image/jpeg') && !file.type.startsWith('image/png')) {
            this.$message.error('请上传jpg/jpeg/png格式的图片!');
            return;
          }
          var reader = new FileReader();
          reader.readAsDataURL(file);
          reader.onload = (e) => {
            this.user_upload_image = e.target.result;
            this.user_upload_image_url = e.target.result;
          }
          var img = new Image();
          img.src = this.user_upload_image_url;
          img.onload = () => {
            this.changeImgBox(img.width,img.height,this.$refs['avatarUploaderIconDom']);
          }
        },

        /*取消头像上传*/
        cancel(){
          this.user_upload_image = null;
          this.user_upload_image_url = null;
          this.centerDialogVisible = false;
        },

        /* 保存头像*/
        save(){
          this.$message.success('保存成功!');
          
          this.user_upload_image = null;
          this.user_upload_image_url = null;
          this.centerDialogVisible = false;
        },

        

        
        
      }
    }
</script>
  
<style scoped>
  @import '../css/components/stuInfoMain.css';
</style>

<style scoped>
.avatar-uploader{
  background-color: black;
}

.avatar-uploader .avatar {
  width: 250px;
  height: 250px;
  display: block;
}
</style>

<style>

.avatar-uploader-icon {
  display: flex;
  width: 250px;
  height: 250px;
  align-items: center;
  justify-content: center;
}

.avatar-uploader-icon .el-icon{
  text-align: center;
  font-size: 28px;
  color: #8c939d;
}
</style>