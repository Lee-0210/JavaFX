package login;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
	public static WebDriver driver = new ChromeDriver();
	
	public static void main(String[] args) {
		
		// 크롬에서 네이버 실행하기
		driver.get("https://nid.naver.com/nidlogin.login");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();
		
		// 아이디/비번 입력
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('id').value='" + id + "'");
		js.executeScript("document.getElementById('pw').value='" + pw + "'");
		
		// 로그인 버튼 클릭
		WebElement loginButton = driver.findElement(By.id("log.login"));
		loginButton.click();
		driver.findElement(By.className("rb_title[0]")).click();
		
		sc.close();
	}
}
