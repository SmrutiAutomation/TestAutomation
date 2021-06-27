package modifier1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class CreateModifyXmlDoc {

	public static String line = null;
	static List<String> lines = new ArrayList<String>();
	public static final String RunManager="RunManager.xlsx";
	public static final String RunManagerMainSheet="Iteration";
	public static String FILENAME = "C:/Selenium Setup/JavaXMLModifierProject/TACTestScript.xml";
	public static String NEWDIR = "D:/Documents/AllTACScript/TACTestScript.xml";
    // xslt for pretty print only, no special task
    //private static final String FORMAT_XSLT = "src/main/resources/xslt/staff-format.xslt";
    public static int totalIteration;
    public static int higherRange;
    public static int lowerRange;
    public static String strIterator;
    
    
    public static void main(String[] args) throws IOException {
      
    File f1=null;
    File f2=null;
    FileReader fr=null;
    BufferedReader br=null;
    FileWriter fw=null;
    BufferedWriter out=null;
    String Range=IterationRange();
    
    String [] arrStr = Range.split("\\|");
    System.out.println("arrStr size :"+arrStr.length);
    
    for(int i=0; i<=arrStr.length-1; i++) {
    	  String [] arrStr1 = arrStr[i].split("\\-");
    	  //int j=arrStr1.length;
    	      lowerRange = Integer.parseInt(arrStr1[0]);
    		  higherRange = Integer.parseInt(arrStr1[1]);
    		 totalIteration= (higherRange - lowerRange)+1;
    		 
    	       for (int a=0; a<=totalIteration-1; a++) {
    	    	  
    	          try {
    	        	  int currentItr=lowerRange+a;
    	        	  strIterator = Integer.toString(currentItr);
    	        	  String NewScriptItr = "TACTestScript_"+strIterator+".xml";
    	        	  MoveToAnotherDirectoryAndRename(NewScriptItr);
    	        	  String NewXML= "D:/Documents/AllTACScript/"+NewScriptItr;
    	              f1 = new File(NewXML);
    	              
    	              fr = new FileReader(f1);
    	              br = new BufferedReader(fr);
    	              while ((line = br.readLine()) != null) {
    	                  if (line.contains("ChubbIndia"))
    	                      line = line.replace("ChubbIndia", strIterator);
    	                  
    	                  lines.add(line);
    	              }

    	              fw = new FileWriter(f1);
    	              out = new BufferedWriter(fw);
    	              for (String s : lines)
    	            	  out.write(s);
    	                  out.flush();
    	                  lines.clear();
    	           
    	          } catch (Exception ex) {
    	              ex.printStackTrace();
    	          } finally {
    	              try{
    	              fr.close();
    	              br.close();
    	              out.close();
    	              }catch(IOException ioe)

    	              {
    	                  ioe.printStackTrace();
    	              }
    	          }
    	        System.out.println("New TACTestScript File Created and Modified Successfully for Iterator"+strIterator);

    	    	 }
    	      }

   }
    
    
    
    public static void MoveToAnotherDirectoryAndRename(String TestScript) throws IOException {

      	  //create the target directories, if directory exits, no effect
          File Source = new File(FILENAME);
          File dest = new File(NEWDIR);
          try {
          	Files.copy(Source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
          } catch (IOException e) {
              e.printStackTrace();
          }

    	  try{

    	    // rename a file in the same directory
    		Path source = Paths.get(NEWDIR);  
    	    Files.move(source, source.resolveSibling(TestScript));
            System.out.println();
    	  } catch (IOException e) {
    	    e.printStackTrace();
    	  }
    	  
    }
    
    
    
    public static Workbook xl_GetWorkbook(String filePath) throws IOException{
		InputStream fis= new FileInputStream(filePath);
		String[] path=filePath.split("\\.");
		String ext=path[1];
		 Workbook wbookObj=null;
		if(ext.equalsIgnoreCase("xls")){
			   wbookObj= new HSSFWorkbook(fis);
		}else if(ext.equalsIgnoreCase("xlsx")){
			wbookObj=new XSSFWorkbook(fis);
		}
		return wbookObj;
		
	}
    
    
    
    public static String IterationRange() throws IOException {
	    Workbook wbookObj = xl_GetWorkbook(RunManager);
		Sheet sheetobj=wbookObj.getSheet(RunManagerMainSheet);
		
		int rowCount=sheetobj.getLastRowNum();
		System.out.println(rowCount);
	    MissingCellPolicy mcp=Row.CREATE_NULL_AS_BLANK;
	    
		String Iterations=null;
		for(int i=1; i<=rowCount; i++){
			Row rowObj=sheetobj.getRow(i);
			if(rowObj!=null){
				Cell cellObjname=rowObj.getCell(0, mcp);
				Iterations=cellObjname.getStringCellValue();
				//System.out.println(cellObjstatus.CELL_TYPE_BOOLEAN);
				}
		}
		return Iterations;
    }
    

}
