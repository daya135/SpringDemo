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
        <form id="loginForm"/>	
        	username:<input type="text" id="loginid" name="loginid" value="jzz"/><br>
			password:<input type="password" id="password" name="password" value="123"/><br>
        	&nbsp;验证码：
        	<input type="text" name="validcode" style="width:70px; vertical-align:middle;" id="validcode"/>  
       	 	<img id="codePic" src="/springDemo/action/codePic" 
       	 		width="60" height="21" style="vertical-align:middle;cursor:pointer;"/>   
         	<a class="blurry" id="newPic" onclick="getPic();">看不清楚，换一张</a>
         	<div class="modal-body" id="dialogs">  
                <p></p>  
            </div>
        	<input type="button" value="登录" onclick="login();"/> 
        </form>
		
</body>

</html>
