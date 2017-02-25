package top.danny.spider.controller.utils;

import org.beetl.core.Context;
import org.beetl.core.Function;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BeetlCompareDate implements Function {
	public Object call(Object[] paras, Context ctx) {
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1=paras[0].toString(); //当前时间
	    String date2=paras[1].toString(); //传入时间
	    long longDate1=Long.valueOf(date1.replaceAll("[-\\s:]",""));
	    long longDate2=Long.valueOf(date2.replaceAll("[-\\s:]",""));
	    if(longDate1<longDate2){
	    	return -1;
	    }else if(longDate1>longDate2){
	    	return 1;
	    }else{
	    	return -0;
	    }
	}
}
