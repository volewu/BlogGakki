<%--
  编写者： vole 
  Time： 2018/5/31.14:32
  内容：
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="data_list">
    <div class="data_list_title">
        关于在下</div>
    <div style="padding: 30px" id="profile">
         <textarea style="display:none;" placeholder="markdown语言">${blogger.profile }</textarea>
    </div>
</div>

<script type="text/javascript">
    editormd.markdownToHTML("profile");

    var testEditor;
    $(function () {
        testEditor = editormd.markdownToHTML("profile", {//注意：这里是上面DIV的id
            htmlDecode: "style,script,iframe",
            emoji: true,
            taskList: true,
            tocm: true,
            tex: true, // 默认不解析
            flowChart: true, // 默认不解析
            sequenceDiagram: true, // 默认不解析
            codeFold: true
        });
    });
</script>
