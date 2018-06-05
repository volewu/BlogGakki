package com.vole.util;

/**
 * 编写者： vole
 * Time： 2018/6/5.10:14
 * 内容：
 */
public class Test {

    public static void main(String[] args){
        int totalNum = 15;
        int pageSize = 10;
        long totalPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize + 1;
        System.out.println(totalNum % pageSize == 0);
        System.out.println(totalNum % pageSize );
        System.out.println(totalNum / pageSize);
        System.out.println(totalNum / pageSize + 1);
        System.out.println(totalPage);
    }
}
