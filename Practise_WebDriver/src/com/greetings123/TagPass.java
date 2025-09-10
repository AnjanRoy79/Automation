package com.greetings123;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TagPass {

	public static void main(String[] args) throws InterruptedException{ 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://db-master.123g.us/cgi-bin/admin_tools/tag_blacklist.pl");
		//driver.get("http://admin:passwordJ2ycZek6@https://db-master.123g.us/cgi-bin/admin_tools/tag_blacklist.pl");
		driver.findElement(By.xpath("//*[@id=\"myTable\"]/thead/tr/th[4]/div[2]/a[1]")).click();
		driver.findElement(By.xpath("/html/body/center/form/p[2]/table[2]/tbody/tr/td/input[3]")).click();
		driver.findElement(By.xpath("/html/body/center/form/table[2]/tbody/tr/td/input[2]")).click();
		//driver.wait(1000);
driver.close();
	}

}
	