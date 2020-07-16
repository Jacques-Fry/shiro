const path = require('path')
const CompressionPlugin = require("compression-webpack-plugin")
const webpack = require('webpack')

function resolve(dir) {
  return path.join(__dirname, dir)
}

module.exports = {
  lintOnSave: false,
  // publicPath: process.env.NODE_ENV === 'production' ? './' : '/',
  publicPath: '/gamelibrary',
  // 以下为alias配置
  chainWebpack: config => {
    // 静态映射
    config.resolve.alias
      .set('@', resolve('src'))
      .set('assets', resolve('src/assets'))
      .set('components', resolve('src/components'))
      .set('common', resolve('src/common'))
      .set('network', resolve('src/network'))
      .set('views', resolve('src/views'))

    // 解决ie11兼容ES6
    config.entry('main').add('babel-polyfill')
    // 开启图片压缩
    config.module.rule('images')
      .test(/\.(png|jpe?g|gif|svg)(\?.*)?$/)
      .use('image-webpack-loader')
      .loader('image-webpack-loader')
      .options({ bypassOnDebug: true })
    // 开启js、css压缩
    if (process.env.NODE_ENV === 'production') {
      config.plugin('compressionPlugin')
        .use(new CompressionPlugin({
          test: /\.js$|\.html$|.\css/, // 匹配文件名
          threshold: 10240, // 对超过10k的数据压缩
          deleteOriginalAssets: false // 不删除源文件
        }))
    }

    // 图表
    // config.module.rule('images').test(/\.js$/)
  },
  configureWebpack: {
    plugins: [
      new webpack.ProvidePlugin({
        $: "jquery", jQuery: "jquery",
        "windows.jQuery": "jquery",
        "window.jQuery": "jquery",
        Popper: ["popper.js", "default"]
      })]
  }
}