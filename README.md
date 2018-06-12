# BlogGakki
#### 一、项目介绍:

> 一个用于记录自己学习与生活的博客网站（自己喜欢称为备忘录） ，开发此项目的初衷是为了加深对 JAVA Web 开发各个姿势的了解，以及学习一些新的技术点，毕竟**实践是检验学习成果的方法**

##### V1 版本（已基本完成）：采用 SSM 框架实现的博客系统


* 开发工具：IDEA + Tomcat8.5

* 核心框架：Spring4、SpringMVC、Mybatis3

* 数据库：MySql（[数据库链接：db_blog](https://github.com/volewu/CMS/blob/master/db_cms.sql)）

* 项目管理：Maven3

* 其他框架：Shiro(安全) + EsayUI(后台管理) + Edtro-md(markdown 编辑器) + Druid(阿里巴巴数据库连接池) + BootStrap3 + Lucene（全文检索）

  ​

  **未实现的功能**



- [ ] 畅言的配置 
- [ ] 前台页面显示优化（现在的有点丑），为前台找个好点的主题
- [ ] 服务器上 nginx 的配置
- [ ] 更换网站 icon http://www.faviconer.com/icon/import
##### V2 版本（开发 ing）：尝试用 SpringBoot 开发





##### 二、姿势点：

```
把 GitHub 仓库的语言设置为自己想要的

创建 .gitattributes 文件，并在里面输入以下代码，win 下直接命令行： touch .gitattributes 生成
*.js linguist-language=Java
*.css linguist-language=Java
*.html linguist-language=Java
```

解决failed to push some refs to git?
由于远程仓库与本地仓库存在差异，需要两者进行合并

git pull --rebase origin master

#### jsoup 截取 html 中的相关元素
```html
String blogInfo = blog.getContent();
Document doc = Jsoup.parse(blogInfo);
Elements jpgs = doc.select("img[src$=.jpg]");
for (int i = 0; i < jpgs.size(); i++) {
    Element jpg = jpgs.get(i);
    imageList.add(jpg.toString());
    if (i == 2) {
        break;
    }
}
```
