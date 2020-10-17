<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<center>
    <form action="findByPage" method="post">
        <input type="hidden" name="page"/>
        按照用户名：<input type="text" name="sname" value="${sname!}"/><br>
        按照班级<input type="number" name="gname" value="${gname!}"/>
        <input type="submit" value="检索"/>
    </form>
    <table border="1" rules="all">
        <tr bgcolor="#00ffff" align="center">
            <th>编号</th>
            <th>用户名</th>
            <th>班级</th>
            <th>账户名字</th>
            <th colspan="100">操作<a href="toSaveStu">新增</a></th>
        </tr>
        <#list pageInfo.list as stu>
            <tr align="center">
                <td>${stu.id}</td>
                <td>${stu.sname}</td>
                <td>${stu.gname}</td>
                <td>${stu.aname}</td>
                <td><a href="deleteStuById?id=${stu.id}">删除</a></td>
                <td><a href="toUpdate?id=${stu.id}">修改</a></td>
            </tr>
        </#list>
        <tr bgcolor="#00ffff" align="center">
            <td colspan="100">
                当前${pageInfo.pageNum}/${pageInfo.pages}页，共条记录
                <button  onclick="paging(1)">首页</button>
                <button  onclick="paging(${pageInfo.prePage})">上一页</button>
                <button  onclick="paging(${pageInfo.nextPage})">下一页</button>
                <button  onclick="paging(${pageInfo.pages})">尾页</button>
            </td>
        </tr>
</table>
</center>
</body>
<script>
    function paging(obj) {
        document.getElementsByName("page")[0].value = obj;
        document.forms[0].submit();
    }
</script>
</html>