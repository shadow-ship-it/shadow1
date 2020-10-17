<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<center>
    <form action="saveStu" method="post">
        用户名:<input type="text" name="sname"/><br>
        班级: <select name="gid" id="">
            <option value="-1">--请选择--</option>
            <#list gradeList as grade>
                <option value="${grade.gid}">${grade.gname}</option>
            </#list>
        </select> <br>
        账户名字:<input type="number" name="aid"/><br>
        <input type="submit" value="提交">
    </form>
</center>
</body>
</html>