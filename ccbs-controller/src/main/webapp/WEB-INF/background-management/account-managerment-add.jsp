<%--
  Created by IntelliJ IDEA.
  User: 丁丁
  Date: 2018/10/30
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" %>
<%
    String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + request.getContextPath() + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>账户管理-添加</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="./css/x-admin.css" media="all">
</head>

<body>
<div class="x-body">
    <form action="<%=path %>background-management/accountAdd"
          method="post" onsubmit="return checkForm()">
        <input type="hidden" value="addManager" name="method">
        <div class="layui-form-item">
            <label for="L_email" class="layui-form-label"> <span
                    class="x-red">*</span>设置账户名
            </label>
            <div class="layui-input-inline">
                <input type="text" name="ACCOUNTNAME" id="accountname" onblur="check1()"
                       class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span>必填 &nbsp<span style="color: red"
                                                          id="message"></span>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label"> <span class="x-red">*</span>密码
            </label>
            <div class="layui-input-inline">
                <input type="password" id="L_pass" name="ADMINPSW"
                       onblur="check2()" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">6到16个字符</div>
        </div>
        <div class="layui-form-item">
            <label for="L_repass" class="layui-form-label"> <span
                    class="x-red">*</span>确认密码
            </label>
            <div class="layui-input-inline">
                <input type="password" id="L_repass" name="REPWD" onblur="check3()"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="L_username" class="layui-form-label"> <span
                    class="x-red">*</span>角色
            </label>
            <select name="ACCOUNTROLE">
                <option value="1">管理员</option>
                <option value="2">医生</option>
            </select>
        </div>

        <div class="layui-form-item">
            <label for="L_repass" class="layui-form-label"> </label>
            <button class="layui-btn">
                <font color="yellow">增加</font>
            </button>
            <button class="layui-btn" type="reset">重置</button>
        </div>
    </form>
</div>
<script src="./lib/layui/layui.js" charset="utf-8">

</script>
<script src="./js/x-layui.js" charset="utf-8">

</script>
<script type="text/javascript">
    $(document)
        .ready(
            function() {
                $("REALNAME")
                    .blur(
                        function() {
                            var realName = document
                                .getElementById("REALNAME").value;
                            $
                                .ajax({
                                    url : "${pageContext.request.contextPath}/LoginServlet?method=checkName&REALNAME="
                                        + realName,
                                    async : true,
                                    success : function(
                                        data) {
                                        alert(data);
                                    }
                                });
                        });
            });
    function checkName() {
        var realName = document.getElementById("REALNAME").value;
        var req = getXMLHttpRequest();
        req.open("get",
            "${pageContext.request.contextPath}/LoginServlet?method=checkName="
            + realName, true);
        req.send();
        req.onreadystatechange = function() {
            if (req.readyState == 4 && req.status == 200) {
                if (req.responseText == "true") {
                    $("#message").text("用户名可用");
                } else {
                    $("#message").text("用户名已存在！");
                }
            }
        }
    }
    function check1() {
        var Username = document.getElementById("accountname").value;

        if (Username == "")

            alert("请设置账户名！");
    }
    function check2() {
        var pwd = document.getElementById("L_pass").value;
        if (pwd == "")
            alert("请输入密码");
    }
    function check3() {
        var pwd = document.getElementById("L_repass").value;
        if (pwd == "")
            alert("请确认密码");
    }

</script>
</body>
</html>
