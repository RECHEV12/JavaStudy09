package ch16_network.open_api.dto;

public class MedicineDTO {

    private String med_itmName; /*제품명*/
    private String med_entpName; /*제조회사명*/
    private String med_efcyQesItm; /*효능*/

    public MedicineDTO() {
    }

    public MedicineDTO(String med_itmName, String med_entpName, String med_efcyQesItm) {
        this.med_itmName = med_itmName;
        this.med_entpName = med_entpName;
        this.med_efcyQesItm = med_efcyQesItm;
    }

    @Override
    public String toString() {
        return "MedicineDTO{" +
                "med_itmName='" + med_itmName + '\'' +
                ", med_entpName='" + med_entpName + '\'' +
                ", med_efcyQesItm='" + med_efcyQesItm + '\'' +
                '}';
    }

    public String getMed_itmName() {
        return med_itmName;
    }

    public void setMed_itmName(String med_itmName) {
        this.med_itmName = med_itmName;
    }

    public String getMed_entpName() {
        return med_entpName;
    }

    public void setMed_entpName(String med_entpName) {
        this.med_entpName = med_entpName;
    }

    public String getMed_efcyQesItm() {
        return med_efcyQesItm;
    }

    public void setMed_efcyQesItm(String med_efcyQesItm) {
        this.med_efcyQesItm = med_efcyQesItm;
    }


}



