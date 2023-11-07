package ch15_inout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOut {
    public static void main(String[] args) {
        // 1. /home/ssam/stuList/강연/id.txt에 내용 추가

        File idFile = new File("/home/pc12/stuList/강연/id.txt");

        System.out.println(idFile.exists());

        // 파일 안에 내용을 작성하기 위한
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(idFile);

            // OutPutStream은 byte단위로 데이터를 전송하므로
            // 데이터는 바이트 단위
            // a001을 작성하고자 한다면
            // 너무 비효율적 밑에는
//            byte[] id = {'a', '0', '0', '1'};
//            fos.write(id);

            // String을 만든 후 String을 바이트 배열로 변환해서 사용하는 방식
            String msg = "A001";
            byte[] msgByte = msg.getBytes();

            fos.write(msgByte);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fos != null) {try {fos.close();} catch (IOException e) {throw new RuntimeException(e);}}
        }

        System.out.println("\n----------------------------\n");

        // 존재하지 않는 파일을 생성하고 그 파일에 텍스트 입력
        File temp = new File("/home/pc12/stuList/total.txt");
// 해당 파일에 내용을 추가하고자 한다면 생성자에 true 추가
        try(FileOutputStream fosA = new FileOutputStream(temp, true);) {
            String msg = "종합 6등\n";
            fosA.write(msg.getBytes());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
