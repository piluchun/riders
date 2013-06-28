package com.leadtone.riders.service;

import java.lang.reflect.Method;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.leadtone.riders.RidersBiz;
import com.leadtone.riders.protocol.beans.Content;

@Service
public class BizServiceImpl implements IBizService {

	
	@Override
	public  Content process(Content requestContent,Object classInstance) {
		String type = requestContent.getType();
		Content content =  null;
//		if ("login".equalsIgnoreCase(type)) {
//			content = authUser(requestContent.getData());
//			content.setType(type);
//		} else if ("register".equalsIgnoreCase(type)) {
//			content = register(requestContent.getData());
//			content.setType(type);
//		}

		Method[] methods = ReflectionUtils.getAllDeclaredMethods(classInstance.getClass());
		for (Method method : methods) {
			RidersBiz rb = AnnotationUtils.findAnnotation(method,RidersBiz.class);
			if (rb!=null && type.equals(rb.value())) {
				try {
//					TODO
					content =(Content) method.invoke(classInstance, requestContent.getData());
					content.setType(type);
					break;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return content;
	}

}
