package Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	
	@DataProvider(name="login Data")
	public String[][] getData() throws IOException {
		
		String path="C:\\temp\\InetBanking\\testdata\\Excel.xlsx";
		Excelutility xcel=new Excelutility(path);
		int totalrows=xcel.getRowCount("testdata");
				int totalcols=xcel.getCellCount("testdata", 1);
				String logindata[][]=new String[totalrows][totalcols];
				for(int i=1;i<totalrows;i++) {
					for(int j=0;j<totalcols;j++) {
						
						logindata[i-1][j]=xcel.getCellData("testdata", i, j);
					}
				}
		return logindata;
		
		
	}
}
