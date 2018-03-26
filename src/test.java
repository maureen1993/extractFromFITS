
import nom.tam.fits.*;
import nom.tam.image.*;
import nom.tam.image.compression.hdu.*;
import nom.tam.util.ArrayDataInput;
import nom.tam.util.BufferedDataInputStream;
import nom.tam.util.BufferedFile;
import nom.tam.image.*;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;



public class test{

public static void main(String[] args) {
	try{
//Path to source FITS file
//BufferedFile f=new BufferedFile("/Users/maoyishu/Documents/SKA/MUSER/muserdata/UVFITS-oneMinute/one_minute.uvfits");
BufferedFile f = new BufferedFile("/Users/maoyishu/Documents/SKA/lstm/PulsarObs-2017-09-03/raw/n2003-07-19-23:38:47.rf");
ArrayDataInput adi=f;

TableHDU[] t=new TableHDU[4];

Header h=Header.readHeader(f);


byte[] b=new byte[2880];
//ImageHDU[] b=new ImageHDU[4];
FileWriter fw=new FileWriter("/Users/maoyishu/Desktop/temp.txt");
int sum;
int cnt=0;
while(adi.readLArray(b)>0){
	sum=0;
	for(int i=0;i<b.length;i++){
		sum+=b[i]&(0x00FF);
	    cnt++;
	}
	fw.write(sum+"\r\n");
	
}
fw.write(cnt);

fw.close();
 


  
 /*
  Object[] temp=f.read();
  for(int i=0;i<temp.length;i++){
	  l=0;
	  for(int j=i*4;j<=i*4+3;j++){
		  l+=f.getHDU(j).getSize();
	  }
	  System.out.println(l);
  }    
  f.close();
  */




	}
	catch(FileNotFoundException e){
		e.printStackTrace();
	}
	catch(IOException IOe){
		IOe.getMessage();
	}
	catch(FitsException Fe){
		Fe.getMessage();		
	}
	
}


}