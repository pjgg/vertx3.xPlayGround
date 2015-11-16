package org.pablo.utils;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;


public class SuperAssembler<A,B> implements SuperPabloConverter<A, B>{

    private Class<B> resultClass;
    private Class<A> originClass;

    public SuperAssembler(Class<A> originClass, Class<B> resultClass) {
		this.resultClass = resultClass;
		this.originClass = originClass;
    }

	@Override
	public B apply(A t) {
		
		B result = null;

		try {
			
			result = resultClass.newInstance();
		    BeanUtils.copyProperties(result, t);
		    
		} catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
		   e.printStackTrace();
		} 

		return result;
	}
	
	@Override
	public A applyReverseType(B t){

		A result = null;

		try {
			
			result = originClass.newInstance();
		    BeanUtils.copyProperties(result, t);
		    
		} catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
		   e.printStackTrace();
		} 

		return result;
	}
   
}
