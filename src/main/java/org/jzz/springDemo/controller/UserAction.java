package org.jzz.springDemo.controller;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.jzz.springDemo.dao.IUserDao;
import org.jzz.springDemo.dao.UserDao;
import org.jzz.springDemo.domain.User;
import org.jzz.springDemo.service.IUserService;
import org.jzz.springDemo.utils.CodeImage;
import org.jzz.springDemo.utils.CommonTools;
import org.jzz.springDemo.utils.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value="/action")
//public class LoginAction implements ILoginAction{
public class UserAction {	
	
	@Autowired
	private IUserService userService; 
	@Autowired
	private IUserDao userDao; 
	
	private SimpleDateFormat dateFormat;
	
	public UserAction() {
		dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
	}
	
	@ModelAttribute 
	@RequestMapping(value="/login",method=RequestMethod.POST)
	//@ControllerAopAnotation(description = "用户登陆")
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		/* 先验验证码 */
		String codeInput = request.getParameter("validcode");
		System.out.println("收到验证码: " + codeInput  + " " + session.getId() );
		String errorMsg = "0";
		if (session.getAttribute("code") == null){
			System.out.println("session验证码为空!");
			errorMsg = "1";
			String rspStr = CommonTools.constructJsonStr("errorMsg", errorMsg);
			response.getWriter().write(rspStr);
			return;
		}
		if (codeInput == null || !codeInput.equals(session.getAttribute("code").toString())){
			System.out.println("验证码错误!");
			errorMsg = "1";
			String rspStr = CommonTools.constructJsonStr("errorMsg", errorMsg);
			response.getWriter().write(rspStr);
			return;
		}
		
		/* 验证登陆凭证 */
		if (this.userService.login(request.getParameter("loginid"), request.getParameter("password"))) {
			System.out.println("密码验证成功!");
			session.setAttribute("user", request.getParameter("loginid"));
			errorMsg = "0";
			String rspStr = CommonTools.constructJsonStr("errorMsg", errorMsg);
			response.getWriter().write(rspStr);
			//response.sendRedirect(request.getContextPath() + "/index");
		}	else {
			errorMsg = "2";
			String rspStr = CommonTools.constructJsonStr("errorMsg", errorMsg);
			response.getWriter().write(rspStr);
			return;
		}
	}
	
	@ModelAttribute 
	@RequestMapping(value="/regist",method=RequestMethod.POST)
	public void regist(HttpServletRequest request, HttpServletResponse response) throws IOException {
		User user = new User();

		/* 密码 */
		String salt = PasswordUtil.getSalt();
		String passMD5 = PasswordUtil.md5Hex(request.getParameter("password").toString() + salt);
		
		/* 生日 */
		String birthday = request.getParameter("birthday");
		Date birth = null;
		try {
			birth = new java.sql.Date(dateFormat.parse(birthday).getTime());
		} catch (Exception e) {
			System.out.println(new Date(System.currentTimeMillis()).toString() + " 转换生日日期失败！");
		}

		user.setLoginid(request.getParameter("loginid"));
		user.setUsername(request.getParameter("username"));
		user.setMobile(request.getParameter("mobile"));
		user.setEmail(request.getParameter("email"));
		user.setState("0");
		user.setPassword(passMD5);
		user.setSalt(salt);
		user.setBirthday(birth);
		user.setCreate_time(new java.sql.Timestamp(System.currentTimeMillis()));
			
		if (this.userService.regist(user)) {
			response.sendRedirect(request.getContextPath() + "/ui/login");
		} else {
			response.sendRedirect(request.getContextPath() + "/ui/regist");
		}
	}
	
	@ModelAttribute
	@RequestMapping(value="/codePic",method=RequestMethod.GET)
	public void codePic(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Object[] codePicMap = CodeImage.createImage();
		String code = null;
		BufferedImage image = null;
		code = (String)codePicMap[0];
		image = (BufferedImage)codePicMap[1];
		if (code != null && image != null) {
			session.setAttribute("code", code);
			System.out.println("生成验证码: " +session.getAttribute("code") + " " +session.getId());
			ImageIO.write(image, "JPEG", response.getOutputStream()); 
		} else {
			System.out.println("codePic create error");
		}
	}
	
	@ModelAttribute
	@RequestMapping(value="/userExist",method=RequestMethod.POST)
	public void userExist(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<User> list = userDao.queryUserById(request.getParameter("loginid"));
		if (list.size() > 0) {
			response.getWriter().write(CommonTools.constructJsonStr("errorMsg", "1"));
		} else {
			response.getWriter().write(CommonTools.constructJsonStr("errorMsg", "0"));
		}
	}
	
	@ModelAttribute
	@RequestMapping(value="/filedownload",method=RequestMethod.GET)
	public void fileDownoad(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//得到要下载的文件名
		String fileName = request.getParameter("filename"); 
		fileName = new String(fileName.getBytes("iso8859-1"), "UTF-8");
		//上传的文件都是保存在/WEB-INF/upload目录下的子目录当中
		String fileSaveRootPath = request.getServletContext().getRealPath("/WEB-INF/upload");
		//通过文件名找出文件的所在目录
		String path = CommonTools.findFileSavePathByFileName(fileName, fileSaveRootPath);
		System.out.println("findFileSavePathByFileName: " + fileSaveRootPath);
		System.out.println("fileName: " + fileName);
		//得到要下载的文件
		File file = new File(path + "\\" + fileName);
		//如果文件不存在
		if(!file.exists()){
			System.out.println("文件不存在: " + file);
            request.setAttribute("message", "您要下载的资源已被删除！！");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
            return ;
        }
		//处理文件名
		String realname = fileName.substring(fileName.indexOf("_")+1);
		//设置响应头，控制浏览器下载该文件
		response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(realname, "UTF-8"));
		//读取要下载的文件，保存到文件输入流
		FileInputStream in = new FileInputStream(path + "\\" + fileName);
		//创建输出流
		OutputStream out = response.getOutputStream();
		//创建缓冲区
		byte buffer[] = new byte[1024];
		int len = 0;
		//循环将输入流中的内容读取到缓冲区当中
		while((len=in.read(buffer))>0){
			//输出缓冲区的内容到浏览器，实现文件下载
			out.write(buffer, 0, len);
		}
		in.close();
		out.close();
	}
	
	@ModelAttribute
	@RequestMapping(value="/fileupload",method=RequestMethod.POST)
	public void fileUpload(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

	        //消息提示
	        String message = "";
	        try{
	            //使用Apache文件上传组件处理文件上传步骤：
	            //1、创建一个DiskFileItemFactory工厂
	            DiskFileItemFactory factory = new DiskFileItemFactory();
	            //2、创建一个文件上传解析器
	            ServletFileUpload upload = new ServletFileUpload(factory);
	             //解决上传文件名的中文乱码
	            upload.setHeaderEncoding("UTF-8"); 
	            //3、判断提交上来的数据是否是上传表单的数据
	            if(!ServletFileUpload.isMultipartContent(request)){
	                //按照传统方式获取数据
	                return;
	            }
	            //4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
	            List<FileItem> list = upload.parseRequest(request);
	            for(FileItem item : list){
	                //如果fileitem中封装的是普通输入项的数据
	                if(item.isFormField()){
	                    String name = item.getFieldName();
	                    //解决普通输入项的数据的中文乱码问题
	                    String value = item.getString("UTF-8");
	                    //value = new String(value.getBytes("iso8859-1"),"UTF-8");
	                    System.out.println(name + "=" + value);
	                }else{//如果fileitem中封装的是上传文件
	                    //得到上传的文件名称，
	                    String filename = item.getName();
	                    System.out.println(filename);
	                    if(filename==null || filename.trim().equals("")){
	                        continue;
	                    }
	                    //注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
	                    //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
	                    filename = filename.substring(filename.lastIndexOf("\\")+1);
	                    
	                    //得到上传文件的保存目录
	                    String saveRootPath = request.getServletContext().getRealPath("/WEB-INF/upload");
	        	        String savePath = CommonTools.findFileSavePathByFileName(filename, saveRootPath);
	        	        System.out.println(savePath);
	        	        
	                    //获取item中的上传文件的输入流
	                    InputStream in = item.getInputStream();
	                    //创建一个文件输出流
	                    FileOutputStream out = new FileOutputStream(savePath + "\\" + filename);
	                    
	                    //创建一个缓冲区
	                    byte buffer[] = new byte[1024];
	                    //判断输入流中的数据是否已经读完的标识
	                    int len = 0;
	                    //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
	                    while((len=in.read(buffer))>0){
	                        //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
	                        out.write(buffer, 0, len);
	                    }
	                    //关闭输入流
	                    in.close();
	                    //关闭输出流
	                    out.close();
	                    //删除处理文件上传时生成的临时文件
	                    item.delete();
	                    message = "文件上传成功！";
	                }
	            }
	        }catch (Exception e) {
	            message= "文件上传失败！";
	            e.printStackTrace();
	            
	        }
	        //request.setAttribute("message",message);
	        response.sendRedirect(request.getContextPath() + "/ui/upload");
	}

}
