import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Printer{
   public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader("testfile.txt");
		BufferedReader br = new BufferedReader(fr);
		String buffer;
        String fulltext="";
        while ((buffer = br.readLine()) != null) {
            System.out.println(buffer);
            fulltext += buffer;
        }
        br.close();
        fr.close();
	}
   
}
