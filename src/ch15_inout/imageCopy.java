package ch15_inout;

import java.io.*;

public class imageCopy {
    public static void main(String[] args) {
        File readImg = new File("/home/pc12/images.jpeg");
        File writeImg = new File("/home/pc12/stuList/강연/images.jpeg");

        try(FileInputStream fis = new FileInputStream(readImg);
            FileOutputStream fos = new FileOutputStream(writeImg)) {

            System.out.println(fis.available());
            byte[] bowl = new byte[fis.available()];

            fis.read(bowl);

            fos.write(bowl);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
