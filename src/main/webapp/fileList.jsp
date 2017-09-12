 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE HTML>
 <html>
   <head>
     <title>下载文件显示页面</title>
   </head>
   <%
        HashMap<String, String> fileNameMap = new HashMap<String, String>();
   		fileNameMap.put("testpath", "testname1");
   		fileNameMap.put("testpath2", "testname2");
   		fileNameMap.put("testpath3", "testname3");
   		request.setAttribute("fileNameMap", fileNameMap);

   %>
   <body>

     <c:forEach var="me" items="${fileNameMap}">
         <c:url value="/servlet/DownLoadServlet" var="downurl">
             <c:param name="filename" value="${me.key}"></c:param>
         </c:url>
         ${me.value}<a href="${downurl}">下载</a>
         <br/>
     </c:forEach>
   </body>
 </html>