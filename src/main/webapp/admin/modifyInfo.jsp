<%--
  编写者： vole 
  Time： 2018/6/6.15:46
  内容：
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改个人信息页面</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/editor-md/css/editormd.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/editor-md/js/editormd.js"></script>
    <script type="text/javascript">

        function submitData() {
            $('#form1').form("submit",{
                url:"${pageContext.request.contextPath}/admin/blogger/save.do",
                onSubmit:function () {
                    var nickName = $("#nickName").val();
                    var slogan = $("#slogan").val();
                    var profile = $("#profile").val();
                    if (!$(this).form("validate")) {
                        return false;
                    }
                    if (profile == null || profile == '') {
                        alert("请输入个性简介！");
                        return false;
                    }
                    if (nickName == null || nickName == '') {
                        alert("请输入昵称！");
                        return false;
                    }
                    if (slogan == null || slogan == '') {
                        alert("请输入个性签名！");
                        return false;
                    }
                    return true;
                },
                success:function (result) {
                    var result = eval('(' + result + ')');
                    if (result.success) {
                        $.messager.alert("系统提示", "修改成功");
                    } else {
                        $.messager.alert("系统提示", "修改失败！");
                        return;
                    }
                }
            });
        }


    </script>
</head>
<body style="margin: 10px">
<div id="p" class="easyui-panel" title="修改个人信息" style="padding: 10px">
    <form id="form1"  method="post" enctype="multipart/form-data">
        <table cellspacing="20px" style="width:100%;">
            <tr>
                <td width="80px">用户名：</td>
                <td>
                    <input type="hidden" id="id" name="id" value="${currentUser.id }"/>
                    <input type="text" id="userName" name="userName" style="width: 200px;"
                           value="${currentUser.userName }" readonly="readonly"/>
                </td>
            </tr>
            <tr>
                <td>昵称：</td>
                <td><input type="text" id="nickName" name="nickName" style="width: 200px;"/></td>
            </tr>
            <tr>
                <td>个性签名：</td>
                <td><input type="text" id="slogan" name="slogan" style="width: 400px;"/></td>
            </tr>
            <tr>
                <td>个人头像：</td>
                <td><input type="file" id="imageFile" name="imageFile" style="width: 400px;"/></td>
            </tr>
            <tr>
                <td valign="top">个人简介：</td>
                <td>
                    <div id="my-editormd" style="width:100%;height:500px;">
                    <textarea class="editormd-markdown-textarea" name="profile" id="profile"></textarea>
                    </div>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <a href="javascript:submitData()" class="easyui-linkbutton"
                       data-options="iconCls:'icon-submit'">提交</a>
                </td>
            </tr>
        </table>
    </form>
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

    $.post("${pageContext.request.contextPath}/admin/blogger/find.do",null,function (result) {
        console.log(result.profile);
        $("#slogan").val(result.slogan);
        $("#nickName").val(result.nickName);
        $("#profile").val(result.profile);
    },"json");

</script>
</body>
</html>