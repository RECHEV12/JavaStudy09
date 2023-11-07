package ch15_inout;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NotePad {
    public static void main(String[] args) {
        //프로그램 실행시
        //파일명과 내용을 입력받아
        // /home/pc12/stuList 폴더 내에 해당 파일명으로 입력한 내용이 들어간
        // 텍스트 파일 생성하기

        Scanner scan = new Scanner(System.in);

        System.out.println("파일명을 입력해주세요");
        String title = scan.nextLine();

        System.out.println("내용을 입력해주세요");
        String content = scan.nextLine();


        File newFile = new File("/home/pc12/stuList/" + title + ".txt");

        try (FileWriter writer = new FileWriter(newFile)) {
            writer.write(content);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
    }
}
