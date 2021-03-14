package com.demo.scrap;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App 
{
    public static void main( String[] args ) {
        
    	
    	//Setting driver properties
    	System.setProperty("webdriver.chrome.driver", "C:\\tools\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        
        //Setting language to English
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("intl.accept_languages","en-US");
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--lang='en-US'");
        options.setHeadless(true);
        
        //Initialisation
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://prefeitura.pbh.gov.br/saude/licitacao/pregao-eletronico-151-2020");
        
        String selector = "";
        
        //Publication date selector
        selector = "span.col-sm-6:nth-child(1)";
        WebElement element = driver.findElement(By.cssSelector(selector));
        System.out.println("CSS Selector: " + selector);
        System.out.println("Attribute - " + element.getText());
        System.out.println("\n\n");
        
        //Object
        selector = "span.lbl-licitacao:nth-child(4)";
        element = driver.findElement(By.cssSelector(selector));
        System.out.println("CSS Selector:"  + selector);
        String key = element.getText();
        
        selector = "div.views-field:nth-child(2) > span:nth-child(1) > p:nth-child(6)";
        element = driver.findElement(By.cssSelector(selector));
        System.out.println("CSS Selector:"  + selector);
        System.out.println("Attribute - " + key + element.getText());
        System.out.println("\n\n");
        
        // Bidding date selector
        selector = "span.col-sm-6:nth-child(19)";
        element = driver.findElement(By.cssSelector(selector));
        System.out.println("CSS Selector: " + selector);
        System.out.println("Attribute -  " + element.getText());
        System.out.println("\n\n");
        
        //printing all the links along with title
	        for(int i=1; i<=4; i++) {
	        	String titleSelector = "div.field-content > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child("+ i + ") > td:nth-child(1) > div:nth-child(1)";
	        	String referenceSelector = "div.field-content > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child("+ i + ") > td:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a:nth-child(1)";
	        			
	        	WebElement title = driver.findElement(By.cssSelector(titleSelector));
	        	WebElement value = driver.findElement(By.cssSelector(referenceSelector));
	        	System.out.println("CSS Selector: " + titleSelector);
	        	System.out.println("CSS Selector: " + referenceSelector);
	            System.out.println(title.getText() + " : " + value.getAttribute("href") + "\n");
	        }
       }
}
