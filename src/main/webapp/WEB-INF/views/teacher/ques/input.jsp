<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>题库管理</title>
    <%@include file="/WEB-INF/views/common/link.jsp" %>
</head>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%@include file="/WEB-INF/views/common/navbar.jsp" %>
    <!--菜单回显-->
    <c:set var="currentMenu" value="course"/>
    <%@include file="/WEB-INF/views/common/menu.jsp" %>
    <div class="content-wrapper">
        <section class="content-header">
            <c:choose>
                <c:when test="${empty que}">
                    <h1>添加题目</h1>
                </c:when>
                <c:otherwise>
                    <h1>编辑题目</h1>
                </c:otherwise>
            </c:choose>
        </section>
        <section class="content">
            <div class="box">
                <form class="form-horizontal" action="/teacher/ques/save" method="post" id="editForm">
                    <input type="hidden" value="${que.id}" name="id">

                    <div class="form-group" style="margin-top: 10px;">
                        <label for="problem" class="col-sm-1 control-label">题干描述</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="problem" name="problem" value="${que.problem}"
                                   placeholder="请输入题干描述">
                        </div>
                    </div>

                    <div class="form-group" style="margin-top: 10px;">
                        <label for="score" class="col-sm-1 control-label">分值</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="score" name="score" value="${que.score}"
                                   placeholder="请输入该题分值">
                        </div>
                    </div>

                    <div class="form-group" style="margin-top: 10px;">
                        <label for="degree" class="col-sm-1 control-label">难易程度</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="degree" name="degree" value="${que.degree}"
                                   placeholder="请输入难易程度">
                        </div>
                    </div>

                    <div class="form-group" style="margin-top: 10px;">
                        <label for="type" class="col-sm-1 control-label">题目类型</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="type" name="type" value="${que.type}"
                                   placeholder="请输入题目类型">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="course" class="col-sm-2 control-label">课程：</label>
                        <div class="col-sm-6">
                            <select class="form-control" id="course" name="course.id">
                                <c:if test="${not empty courses}">
                                    <c:forEach items="#{courses}" var="c">
                                        <option value="${c.id}">${c.name}</option>
                                    </c:forEach>
                                </c:if>
                            </select>
                        </div>
                    </div>

                    <script>
                        <c:if test="${not empty que.course}">
                        $("#course").val(${que.course.id})
                        </c:if>
                    </script>

                    <div class="form-group">
                        <div class="col-sm-offset-1 col-sm-6">
                            <button id="submitBtn" type="submit" class="btn btn-primary">保存</button>
                            <button type="reset" class="btn btn-danger">重置</button>
                        </div>
                    </div>

                </form>

            </div>

        </section>
    </div>
    <%@include file="/WEB-INF/views/common/footer.jsp" %>
</div>


</body>
</html>
