<%--
  编写者： vole 
  Time： 2018/5/31.10:27
  内容：
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">

    function checkData() {
        var q = document.getElementById("q").value.trim();
        if (q == null || q == "") {
            alert("请输入您要查询的关键字！");
            return false;
        } else {
            return true;
        }
    }

</script>

<div class="row">
    <div class="col-md-12 ">
        <nav class="navbar navbar-default navbar-fixed-top ">

            <div class="navbar-collapse collapse" style="text-align: center;background-color: rgba(0,0,0,.075);">
                <ul class="nav navbar-nav" style="display: inline-block;float: none;">
                    <li><a class="navbar-brand"
                           href="${pageContext.request.contextPath}/index.html"><font color="black"><strong>Home</strong></font></a>
                    </li>
                    <li><a href="${pageContext.request.contextPath}/blogger/aboutMe.html"><font
                            color="black"><strong>About Me</strong></font></a></li>
                    <li>
                        <a href="https://github.com/volewu/BlogGakki" target="_blank"><font color="black"><strong>Download</strong></font></a>
                    </li>

                    <li >
                        <form action="${pageContext.request.contextPath}/blog/q.html"
                              class="navbar-form navbar-right" role="search" method="post"
                              onsubmit="return checkData()">
                            <div class="form-group">
                                <input type="text" id="q" name="q" value="${q }"
                                       class="form-control" placeholder="Please enter the keyword...">
                            </div>

                        </form>
                    </li>
                </ul>
            </div>

        </nav>
    </div>
</div>
