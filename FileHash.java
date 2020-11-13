package assignment_4;

import java.io.File;
import java.util.ArrayList;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.io.FileWriter;

public class FileHash {
	
	//定义一个全局动态数组存储给定目录的遍历结果
	static ArrayList<String> result = new ArrayList<String>();
	
	public static ArrayList<String> fileTrav(String filepath) {
		File file = new File(filepath);
		if (file != null) {
			if (file.isDirectory()) {
				File[] content = file.listFiles();
				if (content != null) {
					for (int i = 0; i < content.length; i++) {
						if (content[i].isDirectory()) {
							//System.out.println("Directory: " + content[i].getPath()); //输出目录
							result.add(content[i].getPath());
						}
					fileTrav(content[i].getPath());              //递归调用fileTrav对子文件夹进行遍历
					}
				}
			} else {
				//System.out.println("File: " + file.getPath());             //已遍历到最底层目录的文件，输出文件
				result.add(file.getPath());
			}
		}
		return result;
	}
	
	 public static byte[] SHA1Checksum(InputStream is) throws Exception {
	        byte[] buffer = new byte[1024];
	        MessageDigest complete = MessageDigest.getInstance("SHA-1");
	        int numRead = 0;
	        do {
	            numRead = is.read(buffer);
	            if (numRead > 0) {
	                complete.update(buffer, 0, numRead);
	            }
	        } while (numRead != -1);
	        is.close();
	        return complete.digest();
	    }
	
	public static void main(String[] args) {
		 try {
			 	fileTrav("E:\\Develop\\JavaProject\\Assignment");
	            File file = new File("D:\\hash.txt");
	            //创建用于存储目录遍历结果的文本文件
	            file.createNewFile();
	            //将给定目录遍历结果写入创建的txt
	            FileWriter outFile = new FileWriter(file);
	            for (int j = 0; j < result.size(); j++) {
	            	outFile.write(result.get(j) + '\n');
	            	outFile.flush();
	            }
	            
	            FileInputStream is = new FileInputStream(file);
	            byte[] sha1 = SHA1Checksum(is);

	            String result = "";
	            for (int i = 0; i < sha1.length; i++) {
	                result += Integer.toString(sha1[i], 16);
	            }

	            System.out.println("给定目录的哈希值为：" + result);
	           
	            outFile.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
   }
}
