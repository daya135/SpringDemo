<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

 
    <script src='js/jquery-1.8.2.min.js'></script>  
  
	<script type="text/javascript">  
	
			 function dialog(){   
			        //$("#mymodal").modal("toggle");  
			  };
			  
		     function getPic(){   
		           $("#codePic").attr("src","/springDemo/action/codePic?flag="+Math.random());   
		      };  
		      
		      function login(){    
		          var loginid=document.getElementById("loginid").value;    
		          var password=document.getElementById("password").value;    
		          var validcode=document.getElementById("validcode").value;    
		          var matchResult=true;    
		          if(loginid==""){    
		                document.getElementById("dialogs").innerHTML="<h3>用户账号不能为空！</h3>";  
		                dialog();  
		                matchResult=false;    
		          }else if(password==""){    
		                document.getElementById("dialogs").innerHTML="<h3>用户密码不能为空！</h3>";  
		                dialog();  
		                matchResult=false;    
		          }else if(validcode==""){    
		                document.getElementById("dialogs").innerHTML="<h3>验证码不能为空！</h3>";  
		                dialog();  
		                matchResult=false;   
		          }
// 		          }else if(userName.length<6||userName.length>20){    
// 		                document.getElementById("dialogs").innerHTML="<h3>用户名长度应在6到20个字符之间！</h3>";  
// 		                dialog();  
// 		                matchResult=false;    
// 		          }else if(pwd.length<6||pwd.length>20){    
// 		                document.getElementById("dialogs").innerHTML="<h3>密码或重复密码长度应在6到20个字符之间！</h3>";  
// 		                dialog();  
// 		                matchResult=false;
// 		          }    
		          if(matchResult==true){  
		              $.post("/springDemo/action/login", {loginid:loginid, password:password, validcode:validcode},function(data,status){  
		                 var result=data.errorMsg;
		                 getPic();  
		             if(result=="1"){  
		                 errors="true";  
		                 document.getElementById("dialogs").innerHTML="<h3>验证码错误，请重新输入！</h3>";  
		                 dialog();  
		             }  
		             if(result=="2"){  
		                 document.getElementById("dialogs").innerHTML="<h3>您输入的凭证有误！</h3>";  
		                 document.getElementById("loginid").value="";  
		                 document.getElementById("password").value="";  
		                 dialog();  
		             } else if(result=="0"){  
		                location.href="${pageContext.request.contextPath}/index.jsp";
		             }
		            },"json");  
		          }    
		         };  
	</script> 
</head>
<body>
		<%
				String userName = (String) request.getSession().getAttribute("user");
		%>
		已登录用户:<%=userName%>
		</br></br>
		<a href="${pageContext.request.contextPath}/ui/login">login</a><br/>
		<a href="${pageContext.request.contextPath}/ui/regist">regist</a><br/>
		<a href="${pageContext.request.contextPath}/ui/upload">upload</a><br/>
		<a href="${pageContext.request.contextPath}/ui/listfile">listfile</a><br/>
		
</body>

</html>
