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
	
	//����һ��ȫ�ֶ�̬����洢����Ŀ¼�ı������
	static ArrayList<String> result = new ArrayList<String>();
	
	public static ArrayList<String> fileTrav(String filepath) {
		File file = new File(filepath);
		if (file != null) {
			if (file.isDirectory()) {
				File[] content = file.listFiles();
				if (content != null) {
					for (int i = 0; i < content.length; i++) {
						if (content[i].isDirectory()) {
							//System.out.println("Directory: " + content[i].getPath()); //���Ŀ¼
							result.add(content[i].getPath());
						}
					fileTrav(content[i].getPath());              //�ݹ����fileTrav�����ļ��н��б���
					}
				}
			} else {
				//System.out.println("File: " + file.getPath());             //�ѱ�������ײ�Ŀ¼���ļ�������ļ�
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
	            //�������ڴ洢Ŀ¼����������ı��ļ�
	            file.createNewFile();
	            //������Ŀ¼�������д�봴����txt
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

	            System.out.println("����Ŀ¼�Ĺ�ϣֵΪ��" + result);
	           
	            outFile.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
   }
}
