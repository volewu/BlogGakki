package com.vole.util;

/**
 * 编写者： vole
 * Time： 2018/6/7.10:22
 * 内容：常量工具类
 */
public class ConstantUtil {

    /**
     * editormd 图片上传保存地址 // TODO: 2018/6/4 发布时，地址改为服务器地址
     */
//    public static final String UPLOAD_DIR = "E:\\JAVAIDE\\apache-tomcat-8.5.29\\webapps\\Blog\\static\\userImages\\";

    public static final String UPLOAD_DIR ="/home/tomcat/apache-tomcat-8.5.30/webapps/Blog/static/userImages";

    /**
     * 图片 url 地址
     */
    public static final String IMAGE_URL = "http://wuvole.com/static/userImages/";

    /**
     * lucene 索引的保存地址 // TODO: 2018/6/4 发布时，地址改为服务器地址
     */
//    public static String SAVE_LUCENE_DIR = "D://lucene";
    public static String SAVE_LUCENE_DIR = "/home/lucene";

    /**
     * 备忘录的名字
     */
    public static final String BLOG_NAME = "伍记备忘录";


    public static final String UPLOAD_SUCCESS = "上传成功！";
    public static final String UPLOAD_FAIL = "上传失败！";

    public static final String DELETE_EXIST = "博客类别下有博客，不能删除！";

    public static final String LOGIN_ERROR_INFO = "用户名或者密码错误！";

    public static final String ABOUT_ME = "关于在下";


    public static final String MSG_SUCCESS = "success";

    public static final String MSG_FAIL = "fail";

}
