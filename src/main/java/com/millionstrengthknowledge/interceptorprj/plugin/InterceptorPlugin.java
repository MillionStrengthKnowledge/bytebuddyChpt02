/*
Copyright &copy;2020 by MillionStrengthKnowledge.com, All rights reserved.

The publication of the ebook and source code are protected by copyright, 
and permission must be obtained from the MillionStrengthKnowledge.com 
prior to any prohibited reproduction, storage in a retrieval system, 
or transmission in any form or by any means, electronic, mechanical, 
photocopying, recording, or likewise.
 */
package com.millionstrengthknowledge.interceptorprj.plugin;

import java.io.IOException;

import com.millionstrengthknowledge.interceptorprj.interceptor.LogInterceptor;
import com.millionstrengthknowledge.interceptorprj.program.DataProducer;

import net.bytebuddy.asm.Advice;
import net.bytebuddy.build.Plugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType.Builder;
import net.bytebuddy.matcher.ElementMatchers;

public class InterceptorPlugin 
implements Plugin {
    @Override
    public boolean matches(TypeDescription target) {
    	System.out.println("Inspecting "+
    			target.getName());
    	
    	if(target.getName()
    		.equals(DataProducer.class.getName())
    	) {
    		System.out.println("Found target code: "+
    				target.getName());
    		
    		return true;
    	}
    	else {
    		System.out.println("Inspected code "+
    			target.getName()+" is not the target code");
    		
    		return false;
    	}
    }

	@Override
	public Builder<?> apply(
		Builder<?> builder, TypeDescription typeDescription, 
		ClassFileLocator classFileLocator
	) {	
		return builder
        		.visit(
        			Advice.to(LogInterceptor.class)
        	    		.on(ElementMatchers.named("create"))
        			);
	}
	
	@Override
	public void close() throws IOException {
		System.out.println("InterceptorPlugin close method");
	}
}
