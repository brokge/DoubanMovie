package com.udaye.movie.entity;

import java.util.List;

/**
 * 演员信息
 * <p>
 * Created on 16/7/3.
 */
public class CelebrityBean {

    /**
     * mobile_url : https://movie.douban.com/celebrity/1054395/mobile
     * aka_en : ["Elijah Jordan Wood (本名)","Elwood, Lij and Monkey (昵称)"]
     * name : 伊利亚·伍德
     * works : [{"roles":["演员"],"subject":{"rating":{"max":10,"average":9.3,"stars":"50","min":0},"genres":["动画","惊悚","冒险"],"title":"花园墙外 第一季","casts":[],"collect_count":3373,"original_title":"Over the Garden Wall","subtype":"tv","directors":[{"alt":"https://movie.douban.com/celebrity/1352267/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/c4A2hFhLBxUcel_avatar_uploaded1444453249.48.jpg","large":"http://img3.doubanio.com/img/celebrity/large/c4A2hFhLBxUcel_avatar_uploaded1444453249.48.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/c4A2hFhLBxUcel_avatar_uploaded1444453249.48.jpg"},"name":"帕特里克·麦克海尔","id":"1352267"}],"year":"2014","images":{"small":"http://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2212480699.jpg","large":"http://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2212480699.jpg","medium":"http://img3.doubanio.com/view/movie_poster_cover/spst/public/p2212480699.jpg"},"alt":"https://movie.douban.com/subject/25941842/","id":"25941842"}},{"roles":["演员"],"subject":{"rating":{"max":10,"average":9.2,"stars":"50","min":0},"genres":["喜剧","短片","歌舞"],"title":"SMAPxSMAP","casts":[{"alt":null,"avatars":null,"name":"木村拓哉","id":null},{"alt":null,"avatars":null,"name":"中居正广","id":null},{"alt":null,"avatars":null,"name":"香取慎吾","id":null}],"collect_count":1851,"original_title":"SMAPxSMAP","subtype":"tv","directors":[],"year":"1996","images":{"small":"http://img3.douban.com/spic/s1634671.jpg","large":"http://img3.douban.com/lpic/s1634671.jpg","medium":"http://img3.douban.com/mpic/s1634671.jpg"},"alt":"https://movie.douban.com/subject/1763308/","id":"1763308"}},{"roles":["演员"],"subject":{"rating":{"max":10,"average":9.1,"stars":"45","min":0},"genres":["剧情","动作","奇幻"],"title":"指环王3：王者无敌","casts":[{"alt":"https://movie.douban.com/celebrity/1054520/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/3438.jpg","large":"http://img3.doubanio.com/img/celebrity/large/3438.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/3438.jpg"},"name":"维果·莫腾森","id":"1054520"},{"alt":"https://movie.douban.com/celebrity/1054395/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/51597.jpg","large":"http://img3.doubanio.com/img/celebrity/large/51597.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/51597.jpg"},"name":"伊利亚·伍德","id":"1054395"},{"alt":"https://movie.douban.com/celebrity/1031818/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/11727.jpg","large":"http://img3.doubanio.com/img/celebrity/large/11727.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/11727.jpg"},"name":"西恩·奥斯汀","id":"1031818"}],"collect_count":330711,"original_title":"The Lord of the Rings: The Return of the King","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1040524/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/40835.jpg","large":"http://img3.douban.com/img/celebrity/large/40835.jpg","medium":"http://img3.douban.com/img/celebrity/medium/40835.jpg"},"name":"彼得·杰克逊","id":"1040524"}],"year":"2003","images":{"small":"http://img3.douban.com/view/movie_poster_cover/ipst/public/p1910825503.jpg","large":"http://img3.douban.com/view/movie_poster_cover/lpst/public/p1910825503.jpg","medium":"http://img3.douban.com/view/movie_poster_cover/spst/public/p1910825503.jpg"},"alt":"https://movie.douban.com/subject/1291552/","id":"1291552"}},{"roles":["演员"],"subject":{"rating":{"max":10,"average":9,"stars":"45","min":0},"genres":["喜剧","爱情"],"title":"欢乐一家亲 第一季","casts":[{"alt":"https://movie.douban.com/celebrity/1031847/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/1396501988.66.jpg","large":"http://img3.doubanio.com/img/celebrity/large/1396501988.66.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/1396501988.66.jpg"},"name":"凯尔希·格兰莫","id":"1031847"},{"alt":"https://movie.douban.com/celebrity/1000062/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/38076.jpg","large":"http://img3.doubanio.com/img/celebrity/large/38076.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/38076.jpg"},"name":"简·丽芙丝","id":"1000062"},{"alt":"https://movie.douban.com/celebrity/1000151/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/21378.jpg","large":"http://img3.doubanio.com/img/celebrity/large/21378.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/21378.jpg"},"name":"大卫·海德·皮尔斯","id":"1000151"}],"collect_count":903,"original_title":"Frasier","subtype":"tv","directors":[{"alt":"https://movie.douban.com/celebrity/1000586/","avatars":{"small":"http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img3.douban.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"David Angell","id":"1000586"},{"alt":null,"avatars":null,"name":"Peter Casey","id":null},{"alt":null,"avatars":null,"name":"David Lee","id":null}],"year":"1993","images":{"small":"http://img3.douban.com/view/movie_poster_cover/ipst/public/p2212098341.jpg","large":"http://img3.douban.com/view/movie_poster_cover/lpst/public/p2212098341.jpg","medium":"http://img3.douban.com/view/movie_poster_cover/spst/public/p2212098341.jpg"},"alt":"https://movie.douban.com/subject/1438242/","id":"1438242"}},{"roles":["演员"],"subject":{"rating":{"max":10,"average":8.9,"stars":"45","min":0},"genres":["剧情","动作","奇幻"],"title":"指环王1：魔戒再现","casts":[{"alt":"https://movie.douban.com/celebrity/1054395/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/51597.jpg","large":"http://img3.doubanio.com/img/celebrity/large/51597.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/51597.jpg"},"name":"伊利亚·伍德","id":"1054395"},{"alt":"https://movie.douban.com/celebrity/1031818/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/11727.jpg","large":"http://img3.doubanio.com/img/celebrity/large/11727.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/11727.jpg"},"name":"西恩·奥斯汀","id":"1031818"},{"alt":"https://movie.douban.com/celebrity/1054410/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/1453792363.04.jpg","large":"http://img3.douban.com/img/celebrity/large/1453792363.04.jpg","medium":"http://img3.douban.com/img/celebrity/medium/1453792363.04.jpg"},"name":"伊恩·麦克莱恩","id":"1054410"}],"collect_count":351915,"original_title":"The Lord of the Rings: The Fellowship of the Ring","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1040524/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/40835.jpg","large":"http://img3.douban.com/img/celebrity/large/40835.jpg","medium":"http://img3.douban.com/img/celebrity/medium/40835.jpg"},"name":"彼得·杰克逊","id":"1040524"}],"year":"2001","images":{"small":"http://img3.douban.com/view/movie_poster_cover/ipst/public/p1354436051.jpg","large":"http://img3.douban.com/view/movie_poster_cover/lpst/public/p1354436051.jpg","medium":"http://img3.douban.com/view/movie_poster_cover/spst/public/p1354436051.jpg"},"alt":"https://movie.douban.com/subject/1291571/","id":"1291571"}}]
     * gender : 男
     * avatars : {"small":"http://img3.doubanio.com/img/celebrity/small/51597.jpg","large":"http://img3.doubanio.com/img/celebrity/large/51597.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/51597.jpg"}
     * id : 1054395
     * aka : ["伊莱贾·伍德"]
     * name_en : Elijah Wood
     * born_place : 美国,爱荷华州,锡达拉皮兹
     * alt : https://movie.douban.com/celebrity/1054395/
     */

    private String mobile_url;
    private String name;
    private String gender;
    /**
     * small : http://img3.doubanio.com/img/celebrity/small/51597.jpg
     * large : http://img3.doubanio.com/img/celebrity/large/51597.jpg
     * medium : http://img3.doubanio.com/img/celebrity/medium/51597.jpg
     */

    private AvatarsBean avatars;
    private String id;
    private String name_en;
    private String born_place;
    private String alt;
    private List<String> aka_en;
    /**
     * roles : ["演员"]
     * subject : {"rating":{"max":10,"average":9.3,"stars":"50","min":0},"genres":["动画","惊悚","冒险"],"title":"花园墙外 第一季","casts":[],"collect_count":3373,"original_title":"Over the Garden Wall","subtype":"tv","directors":[{"alt":"https://movie.douban.com/celebrity/1352267/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/c4A2hFhLBxUcel_avatar_uploaded1444453249.48.jpg","large":"http://img3.doubanio.com/img/celebrity/large/c4A2hFhLBxUcel_avatar_uploaded1444453249.48.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/c4A2hFhLBxUcel_avatar_uploaded1444453249.48.jpg"},"name":"帕特里克·麦克海尔","id":"1352267"}],"year":"2014","images":{"small":"http://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2212480699.jpg","large":"http://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2212480699.jpg","medium":"http://img3.doubanio.com/view/movie_poster_cover/spst/public/p2212480699.jpg"},"alt":"https://movie.douban.com/subject/25941842/","id":"25941842"}
     */

    private List<WorksBean> works;
    private List<String> aka;

    public String getMobile_url() {
        return mobile_url;
    }

    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public AvatarsBean getAvatars() {
        return avatars;
    }

    public void setAvatars(AvatarsBean avatars) {
        this.avatars = avatars;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getBorn_place() {
        return born_place;
    }

    public void setBorn_place(String born_place) {
        this.born_place = born_place;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public List<String> getAka_en() {
        return aka_en;
    }

    public void setAka_en(List<String> aka_en) {
        this.aka_en = aka_en;
    }

    public List<WorksBean> getWorks() {
        return works;
    }

    public void setWorks(List<WorksBean> works) {
        this.works = works;
    }

    public List<String> getAka() {
        return aka;
    }

    public void setAka(List<String> aka) {
        this.aka = aka;
    }

    public static class AvatarsBean {
        private String small;
        private String large;
        private String medium;

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }
    }

    public static class WorksBean {
        /**
         * rating : {"max":10,"average":9.3,"stars":"50","min":0}
         * genres : ["动画","惊悚","冒险"]
         * title : 花园墙外 第一季
         * casts : []
         * collect_count : 3373
         * original_title : Over the Garden Wall
         * subtype : tv
         * directors : [{"alt":"https://movie.douban.com/celebrity/1352267/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/c4A2hFhLBxUcel_avatar_uploaded1444453249.48.jpg","large":"http://img3.doubanio.com/img/celebrity/large/c4A2hFhLBxUcel_avatar_uploaded1444453249.48.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/c4A2hFhLBxUcel_avatar_uploaded1444453249.48.jpg"},"name":"帕特里克·麦克海尔","id":"1352267"}]
         * year : 2014
         * images : {"small":"http://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2212480699.jpg","large":"http://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2212480699.jpg","medium":"http://img3.doubanio.com/view/movie_poster_cover/spst/public/p2212480699.jpg"}
         * alt : https://movie.douban.com/subject/25941842/
         * id : 25941842
         */

        private SubjectBean subject;
        private List<String> roles;

        public SubjectBean getSubject() {
            return subject;
        }

        public void setSubject(SubjectBean subject) {
            this.subject = subject;
        }

        public List<String> getRoles() {
            return roles;
        }

        public void setRoles(List<String> roles) {
            this.roles = roles;
        }

        public static class SubjectBean {
            /**
             * max : 10
             * average : 9.3
             * stars : 50
             * min : 0
             */

            private RatingBean rating;
            private String title;
            private int collect_count;
            private String original_title;
            private String subtype;
            private String year;
            /**
             * small : http://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2212480699.jpg
             * large : http://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2212480699.jpg
             * medium : http://img3.doubanio.com/view/movie_poster_cover/spst/public/p2212480699.jpg
             */

            private ImagesBean images;
            private String alt;
            private String id;
            private List<String> genres;
            private List<?> casts;
            /**
             * alt : https://movie.douban.com/celebrity/1352267/
             * avatars : {"small":"http://img3.doubanio.com/img/celebrity/small/c4A2hFhLBxUcel_avatar_uploaded1444453249.48.jpg","large":"http://img3.doubanio.com/img/celebrity/large/c4A2hFhLBxUcel_avatar_uploaded1444453249.48.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/c4A2hFhLBxUcel_avatar_uploaded1444453249.48.jpg"}
             * name : 帕特里克·麦克海尔
             * id : 1352267
             */

            private List<DirectorsBean> directors;

            public RatingBean getRating() {
                return rating;
            }

            public void setRating(RatingBean rating) {
                this.rating = rating;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getCollect_count() {
                return collect_count;
            }

            public void setCollect_count(int collect_count) {
                this.collect_count = collect_count;
            }

            public String getOriginal_title() {
                return original_title;
            }

            public void setOriginal_title(String original_title) {
                this.original_title = original_title;
            }

            public String getSubtype() {
                return subtype;
            }

            public void setSubtype(String subtype) {
                this.subtype = subtype;
            }

            public String getYear() {
                return year;
            }

            public void setYear(String year) {
                this.year = year;
            }

            public ImagesBean getImages() {
                return images;
            }

            public void setImages(ImagesBean images) {
                this.images = images;
            }

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public List<String> getGenres() {
                return genres;
            }

            public void setGenres(List<String> genres) {
                this.genres = genres;
            }

            public List<?> getCasts() {
                return casts;
            }

            public void setCasts(List<?> casts) {
                this.casts = casts;
            }

            public List<DirectorsBean> getDirectors() {
                return directors;
            }

            public void setDirectors(List<DirectorsBean> directors) {
                this.directors = directors;
            }

            public static class RatingBean {
                private int max;
                private double average;
                private String stars;
                private int min;

                public int getMax() {
                    return max;
                }

                public void setMax(int max) {
                    this.max = max;
                }

                public double getAverage() {
                    return average;
                }

                public void setAverage(double average) {
                    this.average = average;
                }

                public String getStars() {
                    return stars;
                }

                public void setStars(String stars) {
                    this.stars = stars;
                }

                public int getMin() {
                    return min;
                }

                public void setMin(int min) {
                    this.min = min;
                }
            }

            public static class ImagesBean {
                private String small;
                private String large;
                private String medium;

                public String getSmall() {
                    return small;
                }

                public void setSmall(String small) {
                    this.small = small;
                }

                public String getLarge() {
                    return large;
                }

                public void setLarge(String large) {
                    this.large = large;
                }

                public String getMedium() {
                    return medium;
                }

                public void setMedium(String medium) {
                    this.medium = medium;
                }
            }

            public static class DirectorsBean {
                private String alt;
                /**
                 * small : http://img3.doubanio.com/img/celebrity/small/c4A2hFhLBxUcel_avatar_uploaded1444453249.48.jpg
                 * large : http://img3.doubanio.com/img/celebrity/large/c4A2hFhLBxUcel_avatar_uploaded1444453249.48.jpg
                 * medium : http://img3.doubanio.com/img/celebrity/medium/c4A2hFhLBxUcel_avatar_uploaded1444453249.48.jpg
                 */

                private AvatarsBean avatars;
                private String name;
                private String id;

                public String getAlt() {
                    return alt;
                }

                public void setAlt(String alt) {
                    this.alt = alt;
                }

                public AvatarsBean getAvatars() {
                    return avatars;
                }

                public void setAvatars(AvatarsBean avatars) {
                    this.avatars = avatars;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public static class AvatarsBean {
                    private String small;
                    private String large;
                    private String medium;

                    public String getSmall() {
                        return small;
                    }

                    public void setSmall(String small) {
                        this.small = small;
                    }

                    public String getLarge() {
                        return large;
                    }

                    public void setLarge(String large) {
                        this.large = large;
                    }

                    public String getMedium() {
                        return medium;
                    }

                    public void setMedium(String medium) {
                        this.medium = medium;
                    }
                }
            }
        }
    }
}
