<template>
  <div class="home">
    <img alt="Vue logo" @click="getTestRemote" src="../assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'home',
  components: {
    HelloWorld
  },
  methods:{
    getTestRemote : function(){
      this.$http("/contl.do",{})
      .then(function(data){
        console.log(data);
      });

      this.$http.get("/contl.do",{params:{type:"get", value:"中文测试-GET"}})
      .then(res => {
        console.log(res.data.receive);
      });

      this.$http.post("/contl.do",{type:"post", value:"中文测试-POST"})
      .then(res => {
        console.log(res);
      });

    }
  }
}
</script>
