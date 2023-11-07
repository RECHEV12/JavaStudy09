package ch15_inout;

import java.io.*;

public class FIleIn {
    public static void main(String[] args) {
        File total = new File("/home/pc12/stuList/total.txt");
        System.out.println(total.exists());

        // 해당 File 객체를 InputStream 내 넣어준다
        try (FileInputStream fis = new FileInputStream(total);) {

            // 데이터를 가져올 그릇(byte[]) 생성
            byte[] bowl = new byte[3]; // 그릇의 크기가 1byte임

            String result = "";

            while (true) {
                // 해당 파일을 읽어서 bowl에 담음
                // cnt에는 담긴 개수가 담긴다.
                int cnt = fis.read(bowl);
                //만약 cnt에 -1이 담기면 bowl에 더이상 담을 게 없었다는 뜻
                if (cnt == -1) {
                    break;
                }

                // bowl은 byte[]이므로
                System.out.println(bowl[0]);
                //byte -> 스트링 변환
                String read = new String(bowl);
                System.out.println(read);
                result += read;
            }

            System.out.println(result); // 문자열이 망가져 있음 (한글)

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\n----------------------------\n");

        try (FileInputStream fis = new FileInputStream(total);) {

            // 데이터를 가져올 그릇(byte[]) 생성
            // 한번에 가져올 수 있도록 그릇의 크기를 최대로 만들기
            byte[] bowl = new byte[fis.available()]; // inputstream이 바라보고 있는 File의 바이트 크기 리턴

            fis.read(bowl);

                //byte -> 스트링 변환
                String read = new String(bowl);
                System.out.println(read);




        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
