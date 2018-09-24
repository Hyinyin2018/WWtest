package test1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class ReadTestFile {
	
	 public static String fileName="test.txt";

	public static void main(String[] args) throws Exception{
		
		 BufferedReader objReader = null;
		 String filePath=".";
		 String[] dic = new String[10];
		 int index=0;
		 
		 //read file and save to array
		  try {
		   String strCurrentLine;

		   if(!doesFileExist(filePath))
		   {
			   throw new Exception(fileName+" file does not exist in path "+filePath);
		   }
		   
		   String file=filePath+"\\"+fileName;
		   objReader = new BufferedReader(new FileReader(file));

		   while ((strCurrentLine = objReader.readLine()) != null) {
			   if(!strCurrentLine.isEmpty())
			   {
				   dic[index] = strCurrentLine;
				   //System.out.println(dic[index]);
				   index++;
			   }
		   }

		  } catch (IOException e) {

		   e.printStackTrace();

		  } finally {

		   try {
		    if (objReader != null)
		     objReader.close();
		   } catch (IOException ex) {
		    ex.printStackTrace();
		   }
		  }
	
		  //split the string and display the result
		  System.out.println("=========Result of reading test file============");
		  for(int i=0; i<dic.length; i++)
		  {
			  splitTest(dic[i]);
		  }
			 
	}
		  
	private static void splitTest(String line)	  
	{
		String temp[] = line.trim().split("–");
		System.out.println(temp[0].trim());
		
		for(String str:temp[1].split(","))
			System.out.println(str);
		
		System.out.print("\n");
		 
	}
		
	/***
	 * takes the path of the file and tells the user if the file exists at that path or not
	 * @param path - String 
	 * @return
	 */
	public static boolean doesFileExist(String path)
	{
			 String file = path+"\\"+fileName;
			 File f = new File(file);
			 if(f.exists() && !f.isDirectory()) 
				 return true;
			 else
				 return false;
	}
}
