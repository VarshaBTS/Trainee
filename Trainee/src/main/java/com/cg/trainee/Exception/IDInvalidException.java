package com.cg.trainee.Exception;

public class IDInvalidException extends RuntimeException{
	public IDInvalidException(String msg){
        super(msg);
    }

    public IDInvalidException(String msg,Throwable e){
        super(msg,e);
    }

}
