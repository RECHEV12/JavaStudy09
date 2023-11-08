package ch16_network.open_api.main;

import ch16_network.open_api.dto.MedicineDTO;
import ch16_network.open_api.service.MedicineService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MedicineService medicineService = MedicineService.getInstance();

        Scanner scan = new Scanner(System.in);


        while (true) {

            System.out.println("증상을 이야기해주세요 [종료 : q]");
            System.out.print(">>> ");
            String ache = scan.nextLine();

            if (ache.equals("q")) {
                System.out.println("종료합니다.");
                break;
            }

            ArrayList<MedicineDTO> list = medicineService.acheSelectMed(ache);

            if (list.size() == 0) {
                System.out.println("해당 증상에 대한 약이 없습니다.");
                continue;
            }

            System.out.println("약국에 가서 아래의 약들을 요청하세요");

            for (MedicineDTO medi : list) {
                System.out.println(medi.getMed_itmName());
            }


        }


    }
}
