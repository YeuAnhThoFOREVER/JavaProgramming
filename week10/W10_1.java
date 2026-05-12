package week10;

class CCTV {
    private String resolution;
    public CCTV(String resolution) { this.resolution = resolution; }
    protected String getResolution() { return resolution; }
}

class AICCTV extends CCTV {
    private boolean faceRecognition;

    public AICCTV(String resolution, boolean faceRecognition) {
        super(resolution);
        this.faceRecognition = faceRecognition;
    }

    public void printInfo() {
        String status = faceRecognition ? "작동 중" : "미작동";
        System.out.println("CCTV는 " + getResolution() + "급이며, 현재 얼굴인식 " + status);
    }
}

public class W10_1 {
    public static void main(String[] args) {
        AICCTV ai = new AICCTV("FHD", true);
        ai.printInfo();
    }
}