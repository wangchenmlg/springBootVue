module.exports = {
  outputDir: '../web/src/main/resources/static',   //build输出目录
  assetsDir: 'assets', //静态资源目录（js, css, img）
  lintOnSave: false, //是否开启eslint
  devServer: {
    open: true, //自动弹窗
    host: "localhost",
    port: '8091',
    https: false,
    hotOnly: false,
    proxy: {
      '/api': {
        target: 'http://127.0.0.1:8090', //API服务器的地址
        changeOrigin: true,
        pathRewrite: {
          '^/api': '/test' //映射地址
        }
      }
    }
  }
}

