<%--
  Created by IntelliJ IDEA.
  User: k.kotov
  Date: 02.08.2017
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>page2</title>
    <link href="style1.css" type="text/css" rel="stylesheet"/>
    <script>function loadDoc() {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("ajaxtest").innerHTML = this.responseText;
            }
        };
        xhttp.open("GET", "ajaxtest.txt", true);
        xhttp.send();
    }</script>
</head>

<body>
<div id="wrapper">
    <div id="header">Корпоративная система обучения компании Х
        <div id="userinheader">Пользователь: <%= request.getAttribute("user")
        %></div>
    </div>
    <div id="content">
        <div id="topmenu">
            <ul>
                <li><a href="/method?pageManagerID=home">Home</a></li>
                <li>Статистика</li>
                <li><a href="/method?pageManagerID=profile"> Профиль</a></li>
                <li><a href="/method?pageManagerID=signOut">Выйти</a></li>
            </ul>
        </div>
        <div id="leftmenu"><ul>
            Доступные темы:
            <p></p>

            <li><%if (request.getAttribute("topic0") == null){%>
                <% }else {%>
                <a href="/method?topID=0&pageManagerID=topics"><%= request.getAttribute("topic0")%>
                    <%}%></a></li>
            <li><%if (request.getAttribute("topic1") == null){%>
                <% }else {%>
                <a href="/method?topID=1&pageManagerID=topics"><%= request.getAttribute("topic1")%>
                <%}%></a></li>
            <li><%if (request.getAttribute("topic2") == null){%>
                <% }else {%>
                <a href="/method?topID=2&pageManagerID=topics"><%= request.getAttribute("topic2")%>
                <%}%></a></li>
            <li><%if (request.getAttribute("topic3") == null){%>
                <% }else {%>
                <a href="/method?topID=3&pageManagerID=topics"><%= request.getAttribute("topic3")%>
                    <%}%></a></li>
            <li><%if (request.getAttribute("topic4") == null){%>
                <% }else {%>
                <a href="/method?topID=4&pageManagerID=topics"><%= request.getAttribute("topic4")%>
                <%}%></a></li>
            <li><%if (request.getAttribute("topic5") == null){%>
                <% }else {%>
                <a href="/method?topID=5&pageManagerID=topics"><%= request.getAttribute("topic5")%>
                <%}%></a></li>
            <li><%if (request.getAttribute("topic6") == null){%>
                <% }else {%>
                <a href="/method?topID=6&pageManagerID=topics"><%= request.getAttribute("topic6")%>
                <%}%></a></li>
            <li><%if (request.getAttribute("topic7") == null){%>
                <% }else {%>
                <a href="/method?topID=7&pageManagerID=topics"><%= request.getAttribute("topic7")%>
                <%}%></a></li>
            <li><%if (request.getAttribute("topic8") == null){%>
                <% }else {%>
                <a href="/method?topID=8&pageManagerID=topics"><%= request.getAttribute("topic8")%>
                <%}%></a></li>
        </ul></div>
        <div id="section">
            <div id="heading">Добро пожаловать в систему <%= request.getAttribute("user")%></div>
            <div id="sectioncontent">Данные пользователя</div>
            <div id="ajaxadditionalinfo">
                <p></p>
                <button type="button" onclick=loadDoc()>Дополнительные данные для пользователя <%= request.getAttribute("user")
                %></button>
                <p id="ajaxtest"></p>


            </div>
        </div>
    </div>
</div>
</body>
</html>

