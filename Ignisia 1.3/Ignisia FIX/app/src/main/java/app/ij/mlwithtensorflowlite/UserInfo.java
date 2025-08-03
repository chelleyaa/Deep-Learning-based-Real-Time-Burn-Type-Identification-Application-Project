package app.ij.mlwithtensorflowlite;

public class UserInfo {
    private String uid; // Tambahkan properti UID
    private String name;
    private String namaDokter;
    private String univ;
    private String nomorDokter;

    public UserInfo() {
        // Constructor kosong diperlukan oleh Firebase
    }

    public UserInfo(String uid, String name, String univ, String namaDokter, String nomorDokter) {
        this.uid = uid; // Simpan UID
        this.name = name;
        this.univ = univ;
        this.nomorDokter = nomorDokter;
        this.namaDokter = namaDokter;
    }

    // Getter dan Setter
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamaDokter() {
        return namaDokter;
    }

    public void setNamaDokter(String namaDokter) {
        this.namaDokter = namaDokter;
    }

    public String getUniv() {
        return univ;
    }

    public void setUniv(String univ) {
        this.univ = univ;
    }

    public String getNomorDokter() {
        return nomorDokter;
    }

    public void setNomorDokter(String nomorDokter) {
        this.nomorDokter = nomorDokter;
    }
}
