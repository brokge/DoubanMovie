# 豆瓣电影

针对《给程序员的 Android 入门》的配套代码。


目前程序的目标是做个豆瓣电影客户端（包含热门电影、将要上映、排行榜等功能）。


## 效果图

![效果图](https://github.com/brokge/example-douban-movie/blob/master/capture/device.gif?raw=true)


## 接口定义


详细的接口定义参见 https://developers.douban.com/wiki/?title=movie_v2 ，这里只说明下需要用到的接口。


> 注意：豆瓣的接口只限定每分钟 40 次的访问，所以不要过多的访问以免被屏蔽。



#### 正在热映

[正在热映](https://developers.douban.com/wiki/?title=movie_v2#in_theaters)

### 即将上映

[即将上映](https://developers.douban.com/wiki/?title=movie_v2#coming_soon)

#### top250

[top250](https://developers.douban.com/wiki/?title=movie_v2#top250)


### 北美票房榜

[北美票房榜](https://developers.douban.com/wiki/?title=movie_v2#us-box)


#### 电影详情

[电影详情](https://developers.douban.com/wiki/?title=movie_v2#subject)

