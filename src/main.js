import { createApp,h } from 'vue'
import App from './App.vue'
import ElementPlus from 'element-plus'
import router from './routes/index.js'
import 'element-plus/dist/index.css'
import store from '@/store'
import axios from './interceptors'
import * as echarts from 'echarts'
import './css/magic/magic.css'

//element-plus 的中文化
import zhCN from "element-plus/dist/locale/zh-cn.mjs" //引入中文
//element-plus 的icon
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
//引入css 公共样式
import './css/global.css'

//axios 全局配置
axios.defaults.baseURL = 'http://localhost:80'
axios.defaults.headers.post['Content-Type'] = 'application/json'

//启动app
const app = createApp({
    render: () => h(App)
});

//全局注册axios
app.config.globalProperties.$http = axios

//全局注册echarts
app.config.globalProperties.$echarts = echarts

// 全局注册el-icon
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component);
}

app.use(router);
app.use(store);
app.use(ElementPlus, {locale:zhCN});
app.mount('#app');
