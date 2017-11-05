<%--
  Created by IntelliJ IDEA.
  User: k.kotov
  Date: 05.08.2017
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8"  language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>page4</title>
    <link href="style1.css" type="text/css" rel="stylesheet"/>

    <script src="jquery-3.2.1.js"></script>
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

    <script type='text/javascript' content="text/html; charset=UTF-8" charset="UTF-8">

        $(document).ready(function () {
            $("a.sec").click(function(event) {
                event.preventDefault();

                var id = this.id;
                $.ajax({
                    url: "MethodServlet",
                    data: {
                        pageManagerID: "ajax",
                        id: id

                    },
                    contentType: "text/html;charset=UTF-8",
                    success: function (responseText) {
                        $('#sectioncontent').text(responseText);
                    }
                });

            });
        });
    </script>
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
                <li><a href="/method?pageManagerID=profile">Профиль</a></li>
                <li><a href="/method?pageManagerID=signOut">Выйти</a></li>
            </ul>
        </div>
        <div id="leftmenu"><ul>
            Доступные разделы:
            <p></p>

            <li><%if (request.getAttribute("section_name0") == null){%>
                <% }else {%>
                <a id="0" class="sec" href="/method?sectionID=0&pageManagerID=ajax"><%= request.getAttribute("section_name0")%>
                    <%}%></a></li>
            <li><%if (request.getAttribute("section_name1") == null){%>
                <% }else {%>
                <a id="1"  class= "sec" href="/method?sectionID=1&pageManagerID=ajax"><%= request.getAttribute("section_name1")%>
                    <%}%></a></li>
            <li><%if (request.getAttribute("section_name2") == null){%>
                <% }else {%>
                <a id="2"  class="sec" href="/method?sectionID=2&pageManagerID=ajax"><%= request.getAttribute("section_name2")%>
                    <%}%></a></li>
            <li><%if (request.getAttribute("section_name3") == null){%>
                <% }else {%>
                <a id="3" class="sec" href="/method?sectionID=3&pageManagerID=sections"><%= request.getAttribute("section_name3")%>
                    <%}%></a></li>
            <li><%if (request.getAttribute("section_name4") == null){%>
                <% }else {%>
                <a id="4" class="sec" href="/method?sectionID=4&pageManagerID=sections"><%= request.getAttribute("section_name4")%>
                    <%}%></a></li>
            <li><%if (request.getAttribute("section_name5") == null){%>
                <% }else {%>
                <a id=5 class="sec" href="/method?sectionID=5&pageManagerID=sections"><%= request.getAttribute("section_name5")%>
                    <%}%></a></li>
            <li><%if (request.getAttribute("section_name6") == null){%>
                <% }else {%>
                <a id=6 class="sec" href="/method?sectionID=6&pageManagerID=sections"><%= request.getAttribute("section_name6")%>
                    <%}%></a></li>
            <li><%if (request.getAttribute("section_name7") == null){%>
                <% }else {%>
                <a id=7 class="sec" href="/method?sectionID=7&pageManagerID=sections"><%= request.getAttribute("section_name7")%>
                    <%}%></a></li>
            <li><%if (request.getAttribute("section_name8") == null){%>
                <% }else {%>
                <a id=8 class="sec" href="/method?sectionID=8&pageManagerID=sections"><%= request.getAttribute("section_name8")%>
                    <%}%></a></li>
        </ul></div>
        <div id="section">
            <div id="heading"> <%= request.getAttribute("section_name")%></div>
            <div id="sectioncontent"><%= request.getAttribute("section_content")%></div>


            <div id="ajaxadditionalinfo">

                <p id="ajaxtest"></p>
                <p></p>
                <button type="button" onclick=loadDoc()>Дополнительные данные для пользователя <%= request.getAttribute("user")
                %></button>

            </div>
        </div>
    </div>
</div>
</body>
</html>