package com.xxx;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestDemo {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void test() {
		try {
			throw new RuntimeException("我手动造的异常。");
		}catch(Exception e) {
			log.info("wo{}你","呵呵呵呵");
			log.error("异常",e);
			return;
		}finally {
			System.out.println("heheh");
		}
	}
	
    public static String getStackTrace(Throwable throwable)
    {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        throwable.printStackTrace(pw);
        return sw.getBuffer().toString();
    }
}
