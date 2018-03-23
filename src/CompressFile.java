import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class CompressFile{

	public void Compress(String path,String cName){ 
		 StringBuilder first_step_message=new StringBuilder();
		 StringBuilder first_step_byte_message=new StringBuilder();
	     ArrayList<String> temp_message = new ArrayList<String>();
	     String compression_name=cName;
	     String space="01011111"; 
        //variable declaration starts
        int k=0;
	    int j=0;
        //variable declaration ends

        // secret key for xor step 2 
	    String secretkey0="01110111";        
	    String secretkey1="10100011";
	     //Setting Up Reqirements Starts

        //reading Input File starts
		StringBuilder input_file=new StringBuilder();
	   
	         try  
	         {
	           BufferedReader br = new BufferedReader(new FileReader(path));	
	           String line;
	    			while ((line = br.readLine()) != null) {
	      					input_file.append(line);
	      				}
	          }catch(Exception e){
	                System.out.println(e);
	         }
	    //reading Input File ends     
	     
	     //reading Dictionary File Starts
	     	 HashMap<String,String> binary_dictionary=new HashMap<String,String>();
	     	 HashMap<String,String> word_dictionary=new HashMap<String,String>();
	         String dictionary_line[]=new String[2]; 
	          try{
	            BufferedReader br1=new BufferedReader(new FileReader("secret.txt"));
	               String line1;
	                while((line1=br1.readLine())!=null){
	                	dictionary_line=line1.split(" ");
	                	binary_dictionary.put(dictionary_line[0],dictionary_line[1]); //adding value to dictionary
	                	word_dictionary.put(dictionary_line[1],dictionary_line[0]);
	                	System.out.println(" adding key binary :- "+dictionary_line[1]+" "+dictionary_line[0]);
	                	 System.out.println("adding key word :- "+dictionary_line[0]+" adding value :- "+dictionary_line[1]);
	                }
	            }catch(Exception e1){
	            	System.out.println(e1);
	            }
	     //reading Dictionary File Ends

 //Setting Up Reqirements Ends

         int repeat_process=input_file.length()/8;

	    while(k<repeat_process){
	    	System.out.println("\n\n"+(k+1)+"  time ........\n");        
	    	 
	    	ArrayList<String> input_part_to_binary = new ArrayList<String>(); //stores binary of first 8 characters and so on
	    	String input_part=input_file.substring((k*8),(k*8)+8);   //picking first 8 character and so on.... 
//	    	byte[] bytes = input_part.getBytes();
	    	StringBuilder single_char_to_binary = new StringBuilder(); //stores binary conversion of a character 
	    	System.out.println(input_part);	
			for(int i=0;i<input_part.length();i++){
				String ss=Character.toString(input_part.charAt(i));
				System.out.println(ss);
				if(ss.equals(" ")){
			    	single_char_to_binary.append(space);
			    	System.out.println("space found :- "+space );
				}
				else{
		    	single_char_to_binary.append(word_dictionary.get(ss));
				System.out.println("appended :- "+word_dictionary.get(ss));
				}
		    	single_char_to_binary.append(' ');
			}
	    	input_part_to_binary.add(single_char_to_binary.toString());
				for (String object : input_part_to_binary) {
	        		System.out.println("'" + input_part + "' to binary: " + object); 
	    		}

			
	    //seperating each byte code
	    String message=input_part_to_binary.get(0).toString();
	    String seperation_array[]=message.split(" "); 
	     for(String x:seperation_array)
	     	System.out.println(x);
	    //seperation done
	    		
	    //------------------------------------------------ Applying first step---------------------------------------------

	    String last_character=seperation_array[7];
	    System.out.println("last_character::: "+last_character);
	            
	    temp_message.clear();
 		
 		//swaping first index of each character with Last character's binary digits
	    for(int swap_count=0;swap_count<7;swap_count++){    
	    	StringBuilder temp=new StringBuilder(seperation_array[swap_count]);
	    	System.out.println("temp::: "+temp);
	    	if(!(temp.charAt(0)==(last_character.charAt(7-(swap_count))))){
	    		temp.setCharAt(0,last_character.charAt(7-(swap_count)));
	    	}
	    	temp_message.add(temp.toString());
	    }
	    try{
	        System.out.println("Temporary Message::::"+temp_message.toString());
	    System.out.println("After compression:::");
	    for(String u:temp_message){
	    	  first_step_message.append(binary_dictionary.get(u));
	    	  first_step_byte_message.append(u);
	          System.out.println("Caharacter:- "+u+"-------------------Finally appened::"+binary_dictionary.get(u));
	    	    
	    	}
	    	   // System.out.println(finalMessage);
	  
	}catch(Exception e2){
		System.out.println(e2);
	}
	        k++;
	}  		
	    String remain=input_file.substring(k*8,input_file.length());
		ArrayList<String> messageList = new ArrayList<String>();
		    	StringBuilder remain_char_to_binary = new StringBuilder(); //stores binary conversion of a character 
		    	System.out.println(remain);	
				for(int i=0;i<remain.length();i++){
					String ss1=Character.toString(remain.charAt(i));
					System.out.println(ss1);
					if(ss1.equals(" ")){
				    	remain_char_to_binary.append(space);
				    	first_step_message.append(' ');
				    	first_step_byte_message.append(space);
				    	System.out.println("space found :- "+space );
					}
					else{
			    	remain_char_to_binary.append(word_dictionary.get(ss1));
			    	first_step_message.append(ss1);
			    	first_step_byte_message.append(word_dictionary.get(ss1));
			    	System.out.println("appended :- "+word_dictionary.get(ss1));
					}
			    	remain_char_to_binary.append(' ');
				}
				messageList.add(remain_char_to_binary.toString());
					for (String object : messageList) {
		        		System.out.println("'" + remain + "' to binary: " + object); 
		    		}
	//printing first step output to file first_step.txt
	try{
 FileWriter fw;     
    
    String first_step_file="C://compression//"+compression_name+"//"+compression_name+"_firststep.txt";
    String first_step_byte_file="C://compression//"+compression_name+"//"+compression_name+"_byteoutput.txt";
    
    File f1=new File(first_step_file);
    File f2=new File(first_step_byte_file);
   

    if(!(f1.exists()))
      f1.createNewFile();

    if(!(f2.exists()))
      f2.createNewFile();

 
    
    BufferedWriter bw=new BufferedWriter(new FileWriter(f1.getAbsoluteFile()));
    bw.write(first_step_message.toString());
    bw.close();
    BufferedWriter bw1=new BufferedWriter(new FileWriter(f2.getAbsoluteFile()));
    bw1.write(first_step_byte_message.toString());
    bw1.close();
    System.out.println("\n"+first_step_file+".txt is successfully created.");
    System.out.println("\n"+first_step_byte_file+".txt is successfully created.");

}catch(Exception e){
 System.out.println(e);
}       


// -------------------------------------Applying second Step Xor Conversion-----------------------------------------------------

   //reading first step output file
System.out.println("");
StringBuffer final_xor_output =new StringBuffer();
String character_set="";
try{
  String input_path="C://compression//"+compression_name+"//"+compression_name+"_byteoutput.txt";
  String byte_input_file=new String(Files.readAllBytes(Paths.get(input_path)));
  for(int i=0;i<byte_input_file.length()/8;i++)
  {
  	character_set=byte_input_file.substring((i*8),(i*8)+8);
  		System.out.println("secretkey applied on character_set:- "+character_set);
  		for(int z=0;z<8;z++){
  			if(secretkey0.charAt(z)==character_set.charAt(z))
  				final_xor_output.append('0');
  			else
  				final_xor_output.append('1');
  		}
  }
  String xor_output_path="C://compression//"+compression_name+"//"+compression_name+"_encode_xor_output.txt";
  File f1=new File(xor_output_path);
  
  if(!(f1.exists()))
      f1.createNewFile();
  
 BufferedWriter bw2=new BufferedWriter(new FileWriter(f1));
 bw2.write(final_xor_output.toString());
 bw2.close();

    StringBuffer real=new StringBuffer();
    String output_path1="C://compression//"+compression_name+"//"+compression_name+"_encode_xor_text_output.txt";
    for(int i=0;i<final_xor_output.length();i++){
    String subset=final_xor_output.substring(i,i+8);
    real.append(binary_dictionary.get(subset));
    BufferedWriter bw1=new BufferedWriter(new FileWriter(output_path1));
  bw1.write(real.toString());
  bw1.close();

  i=i+7;
    }
    System.out.println("\n"+xor_output_path+"is successfully created.");
    System.out.println("\n"+output_path1+" is successfully created.");
    }catch(Exception e){
	System.out.println(e);
}

// --------------------------------------------------Applying Third Step Huffman Coding-----------------------------------------
     
 

	}
}