package ch15_inout;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class FileBasic {
    public static void main(String[] args) {

        // 현재 디렉토리의 경로 가져오기
        String path = System.getProperty("user.dir");

        System.out.println(path); // /home/pc12/IdeaProjects/JavaStudy

        //JavaStudy 내 src폴더를 자바단의 File 객체로 불러오기
        //File의 생성자 안에 파일의 경로를 넣어주면 해당 File 객체는
        //실제 로컬 파일에 해당된다.
        File src = new File(path + "/src");
        // toString 실행시 해당 객체의 풀 경로만 출력됨
        System.out.println(src);
        // 해당 File 객체가 폴더인지 아닌지 구분하는 방법도 있음

        System.out.println(src.isDirectory());

        // 폴더 내 목록 출력
        File[] fileArray = src.listFiles();

        for (File file : fileArray) {
            System.out.println(file); // 풀경로
            System.out.println(file.getName()); //파일명만
        }

        System.out.println(fileArray[4]);

        // 실제로 존재하지 않는 경로에 대해서도 File 객체는 만들어진다.
        File comment = new File(fileArray[4] + "/ExceptionMain.java");
        System.out.println(comment);

        File temp = new File(fileArray[4] + "/Comments.java");
        System.out.println(temp);

        // File 객체가 싳체 로컬 파일을 가르키고 있는지 확인
        System.out.println(comment.exists());
        System.out.println(temp.exists());

        // 실제 파일에 대한 정보 보기
        // .length() 파일 크기 리턴 - byte 단위
        // 1kb  = 1024b 1mb = 1024kb
        System.out.println(comment.length());
        System.out.println(temp.length()); // 0 출력

        //.lastModified() 마지막 수정 날짜
        System.out.println(comment.lastModified());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(comment.lastModified()));

        // 존재하지 않는 파일 생성
        // 해당 경로에 대한 로컬파일이 생성됨
        try {
            temp.createNewFile(); // 파일이 존재하는 상황에서 실행해도 에러가 나지 않는다.
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 폴더 만들기
        // /src/files
        File folder = new File(path + "/src/files");

        folder.mkdir();

        System.out.println("\n----------------------------\n");

        ArrayList<String> stuList = new ArrayList<>();

        stuList.add("강연");
        stuList.add("동우");
        stuList.add("태곤");
        stuList.add("창연");
        stuList.add("성복");
        stuList.add("장선");
        stuList.add("지우");
        stuList.add("유민");
        stuList.add("민재");

        // /home/pcxx/stuList 폴더안에
        // 각 학생들 이름우로 구성된 폴더 만들기

        File newFolder = new File("/home/pc12/stuList");
        newFolder.mkdir();

        for (int i = 0; i < stuList.size(); i++) {
            File tempA;
            String stu;

            stu = stuList.get(i);

            tempA = new File(newFolder + "/" + stu);

            tempA.mkdir();

            File id = new File(tempA + "/id.txt");

            try {
                id.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
