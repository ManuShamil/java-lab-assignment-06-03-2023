import java.io.*;

class Main
{   
    public static void main(String[] args) throws Exception
    {
        try (FileOutputStream fos = new FileOutputStream("C:/Users/HP/OneDrive/Documents/abc.txt")) {
            String str = "hello ruby how are you";
            byte[] b = str.getBytes();
            fos.write(b);
        }
        
    

    }
}