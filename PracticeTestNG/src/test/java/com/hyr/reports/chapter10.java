package com.hyr.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.Author;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class chapter10 {

	public static void main(String[] args) throws IOException {
		ExtentReports extentReports=new ExtentReports();
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter
				("report.html");

		
		sparkReporter.viewConfigurer().viewOrder().as(new ViewName[] {
				ViewName.DASHBOARD,
				ViewName.TEST,
				ViewName.EXCEPTION,
				ViewName.CATEGORY,
				ViewName.DEVICE,
				
		}).apply();
		
		
		extentReports.attachReporter(sparkReporter);

		//method chaining process write the code like this for 
		//readability
		extentReports.createTest("Test based test")
		.log(Status.INFO,"info1")
		.log(Status.INFO, "<b>info 2</b>")
		.log(Status.INFO, "<i>info 3</i>")
		.log(Status.INFO, "<b><i>info 3</b></i>");




		String xmlData="<menu id=\"file\" value=\"File\">\r\n"
				+"<popup>\r\n"
				+" <menuitem value=\"New\" onclick=\"CreateNewDoc()\"/>\r\n"
				+" <menuitem value=\"Open\" onclick=\"OpenDoc()\"/>\r\n"
				+" <menuitem value=\"Close\" onclick=\"CloseDoc()\"/>\r\n"
				+"</popup>\r\n"
				+"</menu>";
		
		String jsonData="{\"menu\": {\r\n"
		+"	  \"id\": \"file\",\r\n"
		+"	  \"value\": \"File\",\r\n"
		+"	  \"popup\": {\r\n"
		+"	   \"menuitem\": [\r\n"
		+"	      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\r\n"
		+"	      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\r\n"
		+"	      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\r\n"
		+"	    ]\r\n"
		+"	  }\r\n"
		+"	}}";


		//by writing this code we can not get the xml
		//data directly on the related page
//		extentReports.createTest("xml based test")
//		.log(Status.INFO,xmlData);
//		
		//so this is the line of code we cn get xml data directly
		extentReports.createTest("xmla based data")
		.log(Status.INFO,MarkupHelper.createCodeBlock(xmlData,CodeLanguage.XML));
		
		//this lone of code for json
		extentReports.createTest("json based test")
		.info(MarkupHelper.createCodeBlock(jsonData,CodeLanguage.JSON));

		
		List<String> listData=new ArrayList<>();
		listData.add("gopi");
		listData.add("krishna");
		listData.add("kativarapu");
		
		Map<Integer,String> mapData=new HashMap<>();
		
		mapData.put(101, "gopi");
		mapData.put(102, "krishna");
		mapData.put(103, "kativarapu");
		
		Set<Integer> setData=mapData.keySet();
		
		extentReports.createTest("list based test")
		.info(MarkupHelper.createOrderedList(listData))
		.info(MarkupHelper.createUnorderedList(listData));

		
		extentReports.createTest("map based test")
		.info(MarkupHelper.createOrderedList(mapData))
		.info(MarkupHelper.createUnorderedList(mapData));

		
		extentReports.createTest("set based test")
		.info(MarkupHelper.createOrderedList(setData))
		.info(MarkupHelper.createUnorderedList(setData));

		
		//highlighted text
		extentReports.createTest("highlight log test")
		.info("normal test with out any colour code")
		.info(MarkupHelper.createLabel("highlighted text", ExtentColor.ORANGE));
		
		
		try {
			
		} catch (Exception e) {
			
			extentReports.createTest("exception test 1")
			.fail(e);
					}

		Throwable t=new RuntimeException("this is custom exception");
				extentReports.createTest("exception test 2")
				.fail(t);
				extentReports.createTest("exception test 3")
				.fail(t);
				
		
		extentReports.flush();

		Desktop.getDesktop().browse(new File("report.html").toURI());

	}

}
