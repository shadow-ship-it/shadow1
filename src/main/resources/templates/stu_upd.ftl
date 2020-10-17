<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<center>
    <form action="updStu" method="post">
        <input type="hidden" name="id" value="${student.id}">
        用户名:<input type="text" name="sname" value="${student.sname}"/><br>
        班级: <select name="gid" id="">
        <option value="-1">--请选择--</option>
        <#list gradeList as grade>
            <#if student.gid==grade.gid>
                <option value="${grade.gid}" selected>${grade.gname}</option>
            <#else>
                <option value="${grade.gid}">${grade.gname}</option>
            </#if>
        </#list>
        </select> <br>
        账户名字:<input type="text" name="aid" value="${student.aname}"/><br>
        <input type="submit" value="提交">
    </form>
</center>
</body>
</html>