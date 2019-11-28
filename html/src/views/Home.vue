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
      this.$http("/contl.do",{});
    }
  }
}
</script>
