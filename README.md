# 快递查询小工具



针对《给程序员的 Android 入门》的配套代码



目前程序的目标是做个豆瓣电影客户端（包含热门电影、搜索等功能）。



## 接口定义



详细的接口定义参见 https://developers.douban.com/wiki/?title=movie_v2 ，这里只说明下需要用到的接口。



注意：豆瓣的接口只限定每分钟 40 次的访问，所以不要过多的访问以免被屏蔽。



#### 正在热映

https://developers.douban.com/wiki/?title=movie_v2#in_theaters



#### 搜索

https://developers.douban.com/wiki/?title=movie_v2#search



#### 电影详情

https://developers.douban.com/wiki/?title=movie_v2#subject



#### 短评

https://developers.douban.com/wiki/?title=movie_v2#comments



## 原型图



首页

![https://gracecode.b0.upaiyun.com/2016_05_19/1463628438.png](https://gracecode.b0.upaiyun.com/2016_05_19/1463628438.png)



搜索页

![https://gracecode.b0.upaiyun.com/2016_05_19/1463628455.png](https://gracecode.b0.upaiyun.com/2016_05_19/1463628455.png)

详情页

![https://gracecode.b0.upaiyun.com/2016_05_19/1463628462.png](https://gracecode.b0.upaiyun.com/2016_05_19/1463628462.png)



## 更新记录

### 2016 年 05 月 19 日

添加接口章节以及原型图（草案）



###  2016 年 05 月 09 日

项目初始化，添加 Hello, world!

