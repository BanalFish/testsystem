<%--
  Created by IntelliJ IDEA.
  User: 86155
  Date: 2022/2/10
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>题库管理</title>
    <%@include file="/WEB-INF/views/common/link.jsp"%>
    <script>

        $(function () {

            $(".btn-delete").click(function () {
                var id = $(this).data('id');//获取id参数
                $.messager.confirm('警告', '确认要删除吗?', function () {
                    $.get("/teacher/ques/delete.do",{id:id},function (data) {
                        if (data.success){
                            window.location.reload();//重新加载当前页面并且会携带参数
                        }else {
                            $.messager.popup(data.msg);
                        }
                    })
                    // $.get("/department/delete.do",{id:id},handlerMessage)
                })
            })

        })

        function goPage(currentPage) {
            document.getElementById("currentPage").value = currentPage;
            document.forms[0].submit();
        }

    </script>

</head>


<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%@include file="/WEB-INF/views/common/navbar.jsp"%>
    <!--菜单回显-->
    <c:set var="currentMenu" value="teacher/ques"/>
    <%@include file="/WEB-INF/views/common/menu.jsp"%>
    <div class="content-wrapper">
        <section class="content-header">
            <h1>题库管理</h1>
        </section>
        <section class="content">
            <div class="box">
                <!--高级查询--->
                <form class="form-inline" id="searchForm" action="/teacher/ques/list" method="post">
                    <input type="hidden" name="currentPage" id="currentPage" value="1">
                    <a href="/teacher/ques/input" class="btn btn-success btn-input" style="margin: 10px">
                        <span class="glyphicon glyphicon-plus"></span> 添加
                    </a>
                </form>
                <!--编写内容-->
                <div class="box-body table-responsive no-padding ">
                    <table class="table table-hover table-bordered">
                        <tr>
                            <th>编号</th>
                            <th>题目描述</th>
                            <th>分值</th>
                            <th>类型</th>
                            <th>所属课程</th>
                            <th>难易程度</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach items="${questions}" var="que" varStatus="vs">
                            <tr>
                                <td>${vs.count}</td>
                                <td>${que.problem}</td>
                                <td>${que.score}</td>
                                <td>${que.type}</td>
                                <td>${que.course.name}</td>
                                <td>${que.degree}</td>
                                <td>
                                    <a href="/teacher/ques/input?id=${que.id}" class="btn btn-info btn-xs btn-input">
                                        <span class="glyphicon glyphicon-pencil"></span> 编辑
                                    </a>
                                    <a href="/teacher/ques/delete?id=${que.id}" data-id="${que.id}" class="btn btn-danger btn-xs btn-delete">
                                        <span class="glyphicon glyphicon-trash"></span> 删除
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        <%--                        <tr align="center">--%>
                        <%--                            <td colspan="9">--%>
                        <%--                                <a href="/teacher/course/listPage?currentPage=1">首页</a>--%>
                        <%--                                <a href="/teacher/course/listPage?currentPage=${pageResult.prevPage}">上一页</a>--%>
                        <%--                                <a href="/teacher/course/listPage?currentPage=${pageResult.nextPage}">下一页</a>--%>
                        <%--                                <a href="/teacher/course/listPage?currentPage=${pageResult.totalPage}">尾页</a>--%>
                        <%--                                当前${pageResult.currentPage} / ${pageResult.totalPage}--%>
                        <%--                                当前总共${pageResult.totalCount}条数--%>
                        <%--                            </td>--%>
                        <%--                        </tr>--%>

                        <%--                        <tr align="center">--%>
                        <%--                            <td colspan="9">--%>
                        <%--                                <a href="javascript:goPage(1);">首页</a>--%>
                        <%--                                <a href="javascript:goPage(${result.prevPage});">上一页</a>--%>
                        <%--                                <a href="javascript:goPage(${result.nextPage});">下一页</a>--%>
                        <%--                                <a href="javascript:goPage(${result.totalPage});">尾页</a>--%>
                        <%--                                当前:${result.currentPage}/${result.totalPage}--%>
                        <%--                                总条数:${result.totalCount}--%>
                        <%--                            </td>--%>
                        <%--                        </tr>--%>

                    </table>
                    <!--分页-->
                    <%--                    <%@include file="/WEB-INF/views/common/page_v1.jsp"%>--%>
                    <!--分页-->
                </div>
            </div>
        </section>
    </div>
    <%@include file="/WEB-INF/views/common/footer.jsp"%>
</div>
</body>
</html>

