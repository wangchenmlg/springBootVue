import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios'

//将axios挂载在Vue扩展上,在其他地方使用只需使用 this.$http来代替axios;
Vue.prototype.$http=axios
//配置baseUrl
if (process.env.NODE_ENV == 'development') {    
  axios.defaults.baseURL = '/api';
} else if (process.env.NODE_ENV == 'debug') {    
  axios.defaults.baseURL = '/api';
} else if (process.env.NODE_ENV == 'production') {    
  axios.defaults.baseURL = '/test';
}

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
