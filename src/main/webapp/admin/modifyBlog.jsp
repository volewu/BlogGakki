<%--
  编写者： vole 
  Time： 2018/6/1.13:37
  内容：
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改备忘录</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/editor-md/css/editormd.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/editor-md/js/editormd.js"></script>
    <script type="text/javascript">
        function submitData(){
            var title=$("#title").val();
            var blogTypeId=$("#blogTypeId").combobox("getValue");
            var content = $("#content").val();
            var keyWord=$("#keyWord").val();

            if(title==null || title==''){
                alert("请输入标题！");
            }else if(blogTypeId==null || blogTypeId==''){
                alert("请选择博客类别！");
            }else if(content==null || content==''){
                alert("请填写内容！");
            }else{
                $.post("${pageContext.request.contextPath}/admin/blog/save.do",{'id':'${param.id}','title':title,'blogType.id':blogTypeId,
                    'content':content,'summary':content.substr(0,155),'keyWord':keyWord},function(result){
                    if(result.success){
                        alert("博客修改成功！");
                        window.parent.refreshTab();
                    }else{
                        alert("博客修改失败！");
                    }
                },"json");
            }
        }

    </script>
</head>
<body style="margin: 10px">
<div id="p" class="easyui-panel" title="修改博客" style="padding: 10px">
    <table cellspacing="20px" style="width:100%;">
        <tr>
            <td width="80px">博客标题：</td>
            <td>
                <input type="text" id="title" name="title" style="width: 400px"/>
            </td>
        </tr>
        <tr>
            <td>所属类别：</td>
            <td>
                <select class="easyui-combobox" style="width: 154px" id="blogTypeId"
                        name="blogType.id" editable="false" panelHeight="auto">
                    <option value="">请选择博客类别...</option>
                    <c:forEach var="blogType" items="${blogTypeCountList }">
                        <option value="${blogType.id }">${blogType.typeName }</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td valign="top">博客内容：</td>
            <td>
                <div id="my-editormd" style="width:100%;height:500px;">
                    <textarea class="editormd-markdown-textarea" name="content" id="content"
                              style="display:none;"></textarea>
                    <!-- 第二个隐藏文本域，用来构造生成的HTML代码，方便表单POST提交，这里的name可以任意取，后台接受时以这个name键为准 -->
                    <textarea class="editormd-html-textarea" name="html"></textarea>
                </div>
            </td>
        </tr>
        <tr>
            <td>关键字：</td>
            <td>
                <input type="text" id="keyWord" name="keyWord" style="width: 400px"/>&nbsp;(多个关键字中间用空格隔开)
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <a href="javascript:submitData()" class="easyui-linkbutton"
                   data-options="iconCls:'icon-submit'">修改博客</a>
            </td>
        </tr>
    </table>
</div>
<script type="text/javascript">
    var testEditor;
    $(function () {
        testEditor = editormd("my-editormd", {
            width: "100%",
            height: 800,
            syncScrolling: "single",
            path: "../static/editor-md/lib/",
            //这个配置在simple.html中并没有，但是为了能够提交表单，使用这个配置可以让构造出来的HTML代码直接在第二个隐藏的textarea域中，方便post提交表单。
            saveHTMLToTextarea: true,

            imageUpload: true,
            imageFormats: ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
            imageUploadURL: "${pageContext.request.contextPath}/admin/blog/uploadimg.do",//注意你后端的上传图片服务地址
            onload: function () {
                this.width("100%");
                this.height(480);
            }
        });

    });

    $.post("${pageContext.request.contextPath}/admin/blog/findById.do",{id:${param.id}},function (result) {
        console.log(result.content);
        $("#title").val(result.title);
        $("#keyWord").val(result.keyWord);
        $("#blogTypeId").combobox("setValue",result.blogType.id);
        $("#content").val(result.content);
    },"json");
</script>
</body>

</html>  
