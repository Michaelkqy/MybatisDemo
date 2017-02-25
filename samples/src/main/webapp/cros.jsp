<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<%
    response.setHeader("pragma","no-cache");
    response.setHeader("cache-control","private");
    response.setHeader("expires","Thu, 19 Nov 1981 08:52:00 GMT");
    response.setHeader("P3P","CP=\"CURa ADMa DEVa PSAo PSDo OUR BUS UNI PUR INT DEM STA PRE COM NAV OTC NOI DSP COR\"");

    String jsessionid = session.getId();

    javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("JSESSIONID",jsessionid);

    response.addCookie(cookie);
%>
<html>
<head>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="private">
    <meta http-equiv="expires" content="Thu, 19 Nov 1981 08:52:00 GMT">
    <title>cros</title>
    <script src="libs/jquery-2.1.4.min.js" type="text/javascript"></script>


    <script>
        var fn = null;

        if('function'===typeof parent.postMessage){
            fn = function(status){
                var data = {host:location.host,status:status};
                console.log(data);
                try{
                    parent.postMessage(data,"*");
                }catch(ex){
                    console.log(ex);
                }
            }
        }
        function read(){
            alert(document.cookie);
        }

        var ops = {
            url: "api/cros",
            success: function(data,status,xhr){
                $("#data").html(JSON.stringify( data ));
                if(fn){
                    fn('ok')
                }
            },
            error: function(xhr) {
                if(fn){
                    fn(xhr.statusText)
                }
                console.log(xhr);
            }
        };


        $.ajax(ops);

    </script>
</head>
<body>
<button onclick="read()">read the cookie</button>
<div id="data"></div>
</body>
</html>