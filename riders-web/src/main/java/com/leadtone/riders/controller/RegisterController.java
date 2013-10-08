package com.leadtone.riders.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.codec.digest.DigestUtils;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.leadtone.riders.constants.Constants;
import com.leadtone.riders.entity.User;
import com.leadtone.riders.service.impl.UserService;

@Controller
public class RegisterController {
	public static Logger log = Logger.getLogger(RegisterController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value="register",method = RequestMethod.GET)
	public String registerForm() {
		return "user/register";
	}

	@RequestMapping(value="register",method = RequestMethod.POST)
	public String register(@Valid User user,MultipartHttpServletRequest request) throws IOException {
		log.info(" begin to register");
		MultipartHttpServletRequest multireq = (MultipartHttpServletRequest)request; 
        CommonsMultipartFile file = (CommonsMultipartFile) multireq.getFile("pictureFile"); 
         
        //保存上传图片
        String contentpath = request.getSession().getServletContext().getRealPath("/");
        File contentFile = new File(contentpath);
        while(!contentFile.getName().contains("webapps")&&!contentFile.getName().contains("wtpwebapps")){
        	contentFile = contentFile.getParentFile();
        }
        String md5 = DigestUtils.md5Hex(user.getEmail());
        String endfilePath = Constants.PICTURE_FILE_PATH + md5 +"/";
        String filepath = contentFile.getAbsolutePath() + endfilePath;
        log.info("filepath-->"+filepath);
        if(!new File(filepath).exists()){
        	new File(filepath).mkdirs();
        }
        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
//        String extName = ".jpg";
        String fileName = md5+extName;
        File save = new File(filepath + fileName); 
         
        FileCopyUtils.copy(user.getPictureFile(), save); 
		user.setPicture("http://192.168.8.95:10002/"+endfilePath + fileName);
		log.info("icon-->"+user.getPicture());
		userService.registerUser(user);
//		redirectAttributes.addFlashAttribute("username", user.getEmail());
		return "redirect:/login";
	}

	/**
	 * Ajax请求校验email是否唯一。
	 */
	@RequestMapping(value = "/register/checkEmail")
	@ResponseBody
	public String checkEmail(@RequestParam("email") String email) {
		if (userService.findUserByEmail(email) == null) {
			return "true";
		} else {
			return "false";
		}
	}
	
	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws ServletException {
		binder.registerCustomEditor(byte[].class,
				new ByteArrayMultipartFileEditor());
	}
	
//	@InitBinder  
//	//此处的参数也可以是ServletRequestDataBinder类型  
//	public void initBinder(WebDataBinder binder) throws Exception {  
//	    //注册自定义的属性编辑器  
//	    //1、日期  
//	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
//	    CustomDateEditor dateEditor = new CustomDateEditor(df, true);  
//	    //表示如果命令对象有Date类型的属性，将使用该属性编辑器进行类型转换  
//	    binder.registerCustomEditor(Date.class, dateEditor);      
//	    //自定义的电话号码编辑器(和【4.16.1、数据类型转换】一样)  
////	    binder.registerCustomEditor(User, new MyPropertyEditor());  
//	}  

}