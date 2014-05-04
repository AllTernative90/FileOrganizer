package classes;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Logik  {


	String directory;
	static boolean homeDir = false;
	static int count=1;
	OptionPanes _optionPanes = (Driver._optionPanes);
	
	
	//renaming the files - the filenames are specified in the methods getNewNames() specified
	public void rename(String path, List<String> new_name, List<String> old_name){
		
			int success = 0;
			int fail = 0;
			
			int len1 = new_name.size();
			for (int i=0;i<len1; i++)
				{
				
				File oldfile =new File(path + "/" + old_name.get(i));
				File newfile =new File(path + "/" + new_name.get(i));
				
				if(oldfile.renameTo(newfile)){
					success++;
					
				}else{
					fail++;
				}
			}
			
			Driver.success = success;
			Driver.failed = fail;
	
	}//end rename()
	
	
	//move files from subfolders to the specified path
	static void moveFiles(File aFile, String path) {
		
			//check if it's a file or a directory when cycling through elements
		    if(aFile.isFile()){
		    	
		    	//check if the file is in the root-path. this way files in the root-directory won't be renamed
		    	//this must be implemented, due to the renaming scheme
		    	if(aFile.getParent().equals(path))
		    		homeDir = true;
		    	
		      //check if path is ending with a slash
		      if (!path.endsWith("\\")){
		    	  
		    	  if(new File(path+("\\")+aFile.getName()).exists()==true && homeDir==false){
		    		  aFile.renameTo(new File(path + "\\"+ "[existed_" + count + "]_" + aFile.getName()));
		    		  count++;
	    		  }
		    	  else{
		    		  aFile.renameTo(new File(path + "\\" + aFile.getName()));
		    	  }
		      }
		      else{
		    	  
		    	  if(new File(path+aFile.getName()).exists()==true  && homeDir==false){
		    		  aFile.renameTo(new File(path + "[existed_" + count + "]_" + aFile.getName()));
		    		  count++;
	    		  }
		    	  else{
		    		  aFile.renameTo(new File(path + aFile.getName()));
		    	  }
		      }
		      
		  	homeDir = false;
		  	
		    }//if aFile.isFile()
		    else if (aFile.isDirectory()) {
		    	
		      File[] listOfFiles = aFile.listFiles();
		      
		      if(listOfFiles!=null) {
		        for (int i = 0; i < listOfFiles.length; i++)
		          moveFiles(listOfFiles[i], path);
		      }
		      
		    }//else if
	}//end moveFiles()
	
	
	public List<String> getOldNames(String path){
		
			List<String> list_oldNames = new ArrayList<String>();
			String [] dir = new java.io.File(path).list();
			
			
			int len1 = dir.length;
			for (int i=0;i<len1; i++)
			{
				
				if(new File (path + "/" + dir[i]).isDirectory()==false){
	
					list_oldNames.add(dir[i]);
				}
				
			}
			
			return list_oldNames;
	}

	
	public List<String> getNewNames_brackets(List<String> dir){
		
		
			List<String> extension = new ArrayList<String>();
			List<String> new_name_list = new ArrayList<String>();
			String ext = "";
			String new_name = "";
		
			int len1 = dir.size();
			for (int i=0;i<len1; i++)
			{
		
					//return ".xxx", the filextension including the dot
					ext = dir.get(i).substring(dir.get(i).lastIndexOf("."), dir.get(i).length());
					extension.add(i, ext);
				
				if (dir.get(i).lastIndexOf("(") != -1){
					//returns the filename with extension, but without the last bracket and everything after that
					new_name = (dir.get(i).substring(0, dir.get(i).lastIndexOf("("))) + extension.get(i);		
					new_name_list.add(i, new_name);
				}
				else{
					new_name_list.add(i, dir.get(i));
				}
			}
		return new_name_list;
	}//end getNewNames_song()
	
	
	public List<String> getNewNames_tv(String show, String season, List<String> dir, Boolean c2, Boolean c3, Boolean c4, Boolean c5){		
		
		
			List<String> extension = new ArrayList<String>();
			List<String> new_names = new ArrayList<String>();
			String ext = "";
				
			Pattern pattern = Pattern.compile("[sS][0-9]{2}?[eE][0-9]{2}?");
			Pattern pattern2 = Pattern.compile("[0-9]{1,2}?[xX][0-9]{2}?");
			Pattern pattern3 = Pattern.compile("\\.[0-9]{2}?\\.");
			Pattern pattern4 = Pattern.compile("\\.[0-9]{3}?\\.");
			Pattern pattern5 = Pattern.compile("[0-9]{3}?");
			
			String episode = "";
			String episode2 = "";
			boolean found = false;
		
		
			int len1 = dir.size();
			for (int i=0;i<len1; i++)
			{
		
				//return ".xxx", the filextension including the dot
				ext = dir.get(i).substring(dir.get(i).lastIndexOf("."), dir.get(i).length());
				extension.add(i, ext);
				
				found = false;
				
				
				Matcher matcher = pattern.matcher(dir.get(i));
				
				 while (matcher.find()) {
				      episode = matcher.group();
				      found = true;
				    }
				 
				 
				 if (found == false && c2 == true){
					 
						
							Matcher matcher2 = pattern2.matcher(dir.get(i));
							
							 while (matcher2.find()) {
							      episode2 = matcher2.group();
							      
							      
							      if(matcher2.end() - matcher2.start() == 5)
							      {
							    	  episode = "s" + episode2.substring(0,2) + "e" + episode2.substring(3,5);
							      }
							      else{
							    	  episode = "s0" + episode2.substring(0,1) + "e" + episode2.substring(2,4);
							      }
							      found=true;
							    }
				 }
				 
				 
			 	if (found == false && c3 == true){
					
							Matcher matcher3 = pattern3.matcher(dir.get(i));
							
							 while (matcher3.find()) {
							      episode2 = matcher3.group();
							      
							      if(season.length()>1){
							    	  episode = "s" + season + "e" + episode2.substring(1,3);
							      }
							      else
							      {
							    	  episode = "s0" + season + "e" + episode2.substring(1,3);
							      }
							      
							      found=true;
							    }
				 }
				 
			 	
			 	if (found == false && c4 == true){
					
					Matcher matcher4 = pattern4.matcher(dir.get(i));
					
					 while (matcher4.find()) {
					      episode2 = matcher4.group();
					      episode = "s0" + episode2.substring(1,2) + "e" + episode2.substring(2,4);
					      found=true;
					    }
			 	}
			 	
			 	
			 	
			 	if (found == false && c5 == true){
					
					Matcher matcher5 = pattern5.matcher(dir.get(i));
					
					 while (matcher5.find()) {
					      episode2 = matcher5.group();
					      episode = "s0" + episode2.substring(0,1) + "e" + episode2.substring(1,3);
					      found=true;
					    }
			 	}
			 	
			 	
			 	
		 
				 if(found == true){
					 new_names.add(i,show + " - " + episode.toLowerCase() + extension.get(i));
				 }
				 else{
					 new_names.add(i,dir.get(i));
				 }
				 
				 
				 
				 
				
			}//end for loop
		return new_names;
	}//end getNewNames_tv()

	
}//end class
