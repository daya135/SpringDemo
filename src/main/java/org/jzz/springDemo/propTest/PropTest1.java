package org.jzz.springDemo.propTest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropTest1 {
	
	@Value("${nameA}")
	private String nameA;
	@Value("${passA}")
	private String passA;
	
	public void test () {
		System.out.println(this.getClass().getName() + " name:" + nameA);
		System.out.println(this.getClass().getName() + " pass:" + passA);
	}
}
