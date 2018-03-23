import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class DecompressionWithSecurity{

	public String decode(String path,String cName){ 
		 StringBuilder first_step_message=new StringBuilder();
		 StringBuilder first_step_byte_message=new StringBuilder();
		 StringBuilder returnString=new StringBuilder();

	     ArrayList<String> temp_message = new ArrayList<String>();
	     String compression_name=cName;
        
        //variable declaration starts
        String afterfirststep=""; 
        FileReader f;
        int k=0;
	    int j=0;
        //variable declaration ends

        // secret key for xor step 2 
	    String secretkey0="01110111";        
	    String secretkey1="10100011";
	     //Setting Up Reqirements Starts     
	     
	     //reading Dictionary File Starts
	     	 HashMap<String,String> binary_dictionary=new HashMap<String,String>();
	         String dictionary_line[]=new String[2]; 
	          try{
	            BufferedReader br1=new BufferedReader(new FileReader("secret.txt"));
	               String line1;
	                while((line1=br1.readLine())!=null){
	                	dictionary_line=line1.split(" ");
	                	binary_dictionary.put(dictionary_line[0],dictionary_line[1]); //adding value to dictionary
	                	// System.out.println("adding key:- "+dictionary_line[0]+" adding value :- "+dictionary_line[1]);
	                }
	            }catch(Exception e1){
	            	System.out.println(e1);
	            }
	     //reading Dictionary File Ends

// -------------------------------------Applying second Step Xor Conversion for decoding----------------------------------------------

   //reading first step output file
System.out.println("");
StringBuffer after_xor_output =new StringBuffer();
String character_set="";

try{
  String byte_input_file=new String(Files.readAllBytes(Paths.get(path)));
  for(int i=0;i<byte_input_file.length()/8;i++)
  {
  	character_set=byte_input_file.substring((i*8),(i*8)+8);
  		System.out.println("secretkey applied on character_set:- "+character_set);
  		for(int z=0;z<8;z++){
  			if(secretkey0.charAt(z)==character_set.charAt(z))
  				after_xor_output.append("0");
  			else
  				after_xor_output.append("1");
  		}
  }
  String initial_output_path="C://compression//"+compression_name+"//"+compression_name+"_decode_xoroutput.txt";
  File f1=new File(initial_output_path);
   String initial_text_path="C://compression//"+compression_name+"//"+compression_name+"_firststep_dtext_output_.txt";
  File f2=new File(initial_text_path);
  
  if(!(f1.exists()))
      f1.createNewFile();

  if(!(f2.exists()))
      f2.createNewFile();

 BufferedWriter bw2=new BufferedWriter(new FileWriter(f1));
 bw2.write(after_xor_output.toString());
 bw2.close();
 
 StringBuffer real=new StringBuffer();
    for(int i=0;i<after_xor_output.length();i=i+8){
    String subset=after_xor_output.substring(i,i+8);
    real.append(binary_dictionary.get(subset));
    }

 BufferedWriter bw3=new BufferedWriter(new FileWriter(f2));
 bw3.write(real.toString());
 bw3.close();
    System.out.println("\n"+initial_output_path+" is successfully created.");
    System.out.println("");
    System.out.println("\n"+initial_text_path+" is successfully created.");
      
    int i=0;
    StringBuffer final_output=new StringBuffer();
		String input_path="C://compression//"+compression_name+"//"+compression_name+"_decode_xoroutput.txt";
		String byte_input_file1=new String(Files.readAllBytes(Paths.get(input_path)));
		System.out.println(byte_input_file1);
	    for(i=0;i<byte_input_file1.length()/56;i++){
			StringBuffer sb1=new StringBuffer();
	    	String part=byte_input_file1.substring((i*56),(i*56)+56);
	    	System.out.println("part :- "+part);
	    	for(int j1=0;j1<part.length()/8;j1++){
	    		StringBuffer sb=new StringBuffer();
	    	    String character=part.substring((j1*8),(j1*8)+8);
            System.out.println(" character:- "+character);
            sb1.append(character.charAt(0));   
            sb.append('0');                    
           
//01100100 11100101 11100101 11110000 01100001 11101011 00100000                    
            for(int k2=1;k2<character.length();k2++){
                sb.append(character.charAt(k2));	
            }
           final_output.append(sb);
           System.out.print(" sb final:- "+sb.toString());
           System.out.print(" sb1 khoya:- "+sb1.toString());
	    	}
	    sb1.append('0');
	    final_output.append(sb1.reverse());	
	    }
	    
System.out.println("\nfinal Output :- "+final_output);
for(int k1=0;k1<final_output.length()/8;k1++){
	String cut=final_output.substring((k1*8),(k1*8)+8);
	// binary_dictionary.get(cut);
	if(cut.equals("01011111")){
		returnString.append(' ');
	}
	else{
	returnString.append(binary_dictionary.get(cut));
	}
}


StringBuffer final_output1=new StringBuffer();
	System.out.println(byte_input_file1);
		String remain=byte_input_file1.substring(i*56,byte_input_file1.length());
    	System.out.println("remain :- "+remain);
    	for(int j1=0;j1<remain.length()/8;j1++){
    	    String character1=remain.substring((j1*8),(j1*8)+8);
        System.out.println(" character:- "+character1);
        if(character1.equals("01011111")){
        	returnString.append(' ');
        }
        else{
        returnString.append(binary_dictionary.get(character1));
        }
}

}catch(Exception e){
	System.out.println(e);
}

// --------------------------------------------------Applying Third Step Huffman Coding-----------------------------------------
     
     //Go to DHuffman.java For huffman encoding and decoding.....
	 return returnString.toString(); 
	}
}