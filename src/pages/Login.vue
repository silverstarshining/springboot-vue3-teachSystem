<template>
    <div class="LoginPage">
        <div class="Login-container">
            <h1>中国石油大学（华东）教务系统</h1>
            <div class="Login-form-container">
                <form @submit.prevent="login">
                    <div class="form-group">
                        <div class="username-container">
                            <label for="username">用户名：</label>
                            <input type="text" id="username" v-model="this.loginForm.username">
                        </div>
                        <div class="password-container">
                            <label for="password">密码：</label>
                            <input type="password" id="password" v-model="this.loginForm.password">
                        </div>
                        <button type="submit" class="login-btn">登录</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</template>
  
<script>
  import { mapMutations } from 'vuex';
  export default {
    name: 'LoginPage',
    data() {
        return {
            loginForm:{
                username: '',
                password: ''
            },
        }  
    },
    mounted() {
        this.autoLogin();
    },
    methods: {
        ...mapMutations([
          'setStuName','setStuId','setStuGender','setStuMajor','setStuAge','setEnrollmentTime','setAcademic','setStuHeadshot','setIsLogin'
        ]),
        //加载信息
        getStuInfo() {
          // this.getStuHeadShot();
          this.setIsLogin(true);
        },
        //加载头像
        getStuHeadShot(username) {
          this.$http.post('/user/getStuHeadShot',username,{responseType: 'blob'})
         .then(res => {
            console.log(res.data);
            // this.setStuHeadshot(window.URL.createObjectURL(res.data));
         })
         .catch(err => {
            console.log(err);
          });
        },
        //登录
        login() {
            if(this.loginForm.username === '' || this.loginForm.password === ''){
                this.$message.error('用户名或密码不能为空');
                return;
            }
            this.$http.post('/user/login',this.loginForm)
           .then(res => {
                if(res.data.code === '200'){
                  //鉴权
                  console.log(res.data.data.token);
                  localStorage.setItem('lv-Token',res.data.data.token);
                  this.$message.success('登录成功');
                  this.getStuInfo();
                  this.$router.push('/index');
                }else{
                  this.$message.error('用户名或密码错误');
                }
           })
           .catch(err => {
                this.$message.error('出现异常，登录失败');
                console.log(err);
            });
        },


        /*自动鉴权登录*/
        autoLogin() {
            let token = localStorage.getItem("lv-Token");
            console.log(token);
            if(token){
              this.$http.post('/user/autoLogin',token)
              .then(res => {
                  if(res.data.code === '200'){
                    console.log("自动登录成功");
                    this.$message.success('登录成功');
                    this.getStuInfo();
                    this.$router.push('/index');
                  }else{
                    console.log("自动登录失败");
                    console.log(res.data.msg);
                  }
                })
              .catch(err => {
                  console.log("自动登录失败");
                  console.log(err);
              });
            }
        }
    }
  }
</script>
  
<style>
  
  .LoginPage {
    background-image: url('../assets/7CF5DB066059F2BA12980F6367D_16D8ED08_184E5.jpg');
    background-size: cover;
    height: 100vh;
    width: 100vw;
    display: flex;
    
  }

  .Login-container{
    display: flex;
    height: 100%;
    width: 100%;
    justify-content: space-around;
  }
  

  /* 登录表单 */
  .Login-form-container{
    display: flex;
    float: right;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    width: 400px;
    height: 500px;
    background-color: rgba(255,255,255,0.7);
    border-radius: 20px;
    box-shadow: 0px 12px 24px -1px rgba(0, 0, 0,0.18);
    transition: 0.5s;
    margin-top:5%;
  }

  .Login-form-container:hover{
        box-shadow: 0px 12px 24px -1px rgba(0, 0, 0,0.3);
        transform: scale(1.05);
    }

  .Login-container h1{
    display: flex;
    font-family:"华文楷体";  /*设置字体*/
    font-size: 36px;
    font-weight: bold;
    color: #333333;
    margin-top: 50px;
    margin-bottom: 30px;
    writing-mode:vertical-rl;  /*设置以垂直方式从右向左显示*/
    text-orientation: upright;  /*设置文本方向*/
  }

  .Login-form-container form{
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    width: 100%;
    height: 100%;
  }

  .Login-form-container label{
    font-family:"微软雅黑";  /*设置字体*/
    font-size: 16px;
    color: #333333;
    
  }

  .form-group{
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    width: 100%;
    height: 100%;
    margin-top: 50px;
  }

  .username-container{
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
    width: 100%;
    height: 50px;
    margin-bottom: 20px;
  }

  .password-container{
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
    width: 100%;
    height: 50px;
    margin-bottom: 20px;
  }

  .form-group input{
    background-color: transparent;
    border: 0;
    border-bottom: 2px #86abd7 solid;
    display: block;
    width: 70%;
    padding: 15px 0;
    font-size: 18px;
    color: #333333;
    caret-color: #333333;
  }

  .form-group input:focus{
     outline: none;
  }



  .login-btn{
    width: 250px;
    height: 30px;
    border-radius: 10px;
    background-color: #333333;
    color: #FFFFFF;
    font-size: 16px;
    cursor: pointer;
    transition: 0.5s;
    margin-top:50px;
  }

  .login-btn:hover{
    background-color: #666666;
  }




</style>
