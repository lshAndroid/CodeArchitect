## Android架构搭建--项目代码架构
子模块都可以使用不同的结构
cotlin的子模块，mvp(mvvm)的子模块，hook功能的模块，不会让一个module显得很冗杂，而且可以多人使用自己独特的方案。
## 一、组件化开发的优点：
1.整项目编译时间冗长，一小子模块的编译快速，减少等待build时间，优化开发效率。

2.保持各个模块的独立性，各个模块单独开发不受影响，不会出现局部改动整个项目出问题 。

3.代码维护更加简单，可以迅速找到需要修改的模块代码。

4.多个成员之间的分工合作开发，高效率的分工

5.可以直接转换为插件化开发，商务上使软件使用范围更广
......

## 二、组件化开发原理：
1.各个模块独立成一个ModuleLibrary，宿主Module ,  公用库libcommon，核心是通过参数pro_isPlugn在各个模块的Gradle里面控制，
控制各个模块四单独运行还是作为Library运行。
```
if ("true".equals(pro_isPlugn)) {  
    apply plugin: 'com.android.application'
} else {
    apply plugin: 'com.android.library'
}
```
## 三、组件化的基本框架
1.每个组件可以单独运行，相互不受影响，核心是通过配置文件pro_isPlugn控制切换lib/module，以及AndroidManifest.xml切换使用

2.子模块的跳转方案一：普通跳转主模块会出错无法变意思；方案二：通过反射跳转（推荐）；方案三：通过阿里开源的aroute（要求限制过多，个人并不喜欢）

## 四、具体实现原理
#### 1.具体实现可以分为以下几步：

（1）解决模块独立运行还是作为Library运行问题（主要是Gralde配置），同时解决manifest合并问题。

（2）解决各模块Application合并问题，主要通过反射合并（核心点）

（3）解决各个模块之间的相互通信，主要采取阿里的开源框架ARouter

#### 2.解决模块独立运行还是作为Library运行问题

（1）各个模块的第三方引用库版本号统一放置project根目录gradle.properties，方便各个模块引用相同的参数
    根部gradle配置可变参数：
```
pro_compileSdkVersion = 28
pro_minSdkVersion = 14
pro_targetSdkVersion = 28
pro_versionCode = 3
pro_versionName = 1.0.8
pro_appcompatVersion =26.0.1
pro_constraint = 1.1.3
pro_junit = 4.12
pro_runner = 1.0.2
pro_espresso = 3.0.2
pro_boolean_minifyEnabled=false
pro_cotlin_version=1.2.71

butterknife_version=10.0.0
pro_timber=4.5.1

pro_isPlugn=false
```

（2）各个子模块gradle配置，通过参数pro_isPlugn切换子模块的lib/module并且无报错提示直接编译

空壳App配置：主要是通过参数pro_isPlugn确定需要引用的模块
```
dependencies {
    if ("true".equals(pro_isPlugn)) {   //组件化步骤
        //如果有什么要单独在没有子模块的情况下依赖的

    } else {
        //组件化子模块
        implementation project(':module_cotlin')
        implementation project(':module_mvp
