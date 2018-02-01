package org.jzz.springDemo.propTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropTest2 {
	
	private String nameB;
	private String passB;

	@Value("${nameB}")
	public void setNameB(String nameB) {
		this.nameB = nameB;
	}
	@Value("${passB}")
	public void setPassB(String passB) {
		this.passB = passB;
	}

	public void test () {
		System.out.println(this.getClass().getName() + " name:" + nameB);
		System.out.println(this.getClass().getName() + " pass:" + passB);
	}
}
