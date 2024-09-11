import axios from 'axios' 
// import router from './router/index'
// import { Message } from 'element-ui';
// import store from './store/index'

axios.interceptors.request.use(config => {
    //获取到token，并设置到请求头中
    let token = localStorage.getItem('lv-Token');
    if (token) {
        config.headers['lv-Token'] = token;
    }
    return config;
}, error => {
    Promise.reject(error);
});

export default axios;