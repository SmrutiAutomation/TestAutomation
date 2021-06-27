package modifier1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

public class XMLModify {
	
	

    public static void main(String args[]) throws IOException {
    	
        	
        	String FILENAME = "C:/Selenium Setup/JavaXMLModifierProject/TACTestScript.xml";

            String NEWDIR = "D:/Documents/AllTACScript/TACTestScript.xml";

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
      	    Files.move(source, source.resolveSibling("TACTestScript_56.xml"));
              System.out.println("File copied successfully");
      	  } catch (IOException e) {
      	    e.printStackTrace();
      	  }
      	          	  
        }
    
   
    /*    	    	  
	 File file = new File("TACTestScript.xml");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

           DocumentBuilder db = dbf.newDocumentBuilder();

           Document doc = db.parse(file);
           
           doc.getDocumentElement().normalize();  

           NodeList listOfTestScript= doc.getElementsByTagName("TestScripts");
           //System.out.println(listOfStaff.getLength()); // 2

           for (int k = 0; k < listOfTestScript.getLength(); k++) {
               // get first staff
               Node testscript = listOfTestScript.item(k);
               if (testscript.getNodeType() == Node.ELEMENT_NODE) {
                   //String id = testscript.getAttributes().getNamedItem("id").getTextContent();
                             NodeList childNodes = testscript.getChildNodes();

                       for (int l = 0; l < childNodes.getLength(); l++) {
                           Node item = childNodes.item(l);
                           if (item.getNodeType() == Node.ELEMENT_NODE) {

                               if ("Value".equalsIgnoreCase(item.getNodeName()) && "Chubb".equalsIgnoreCase(item.getNodeValue())) {
                               	
                                   item.setTextContent(arrStr1[i]);
                               }
                           }
                       }
                    }
                  }

           // output to console
           // writeXml(doc, System.out);

           try (FileOutputStream output = new FileOutputStream("c:\\test\\staff-modified.xml")) {
               //writeXml(doc, output);
           } catch (Exception e) {
           e.printStackTrace();
          }
      
 }
}*/
    
    
    }
  
    
  

