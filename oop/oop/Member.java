package oop;

import java.util.ArrayList;

public class Member {
    private String studentID;
    private String password;

    // คอนสตรัคเตอร์สำหรับสร้างสมาชิก
    public Member(String studentID, String password) {
        this.studentID = studentID;
        this.password = password;
    }

    // ฟังก์ชัน login ที่ตรวจสอบว่า ID และ password ตรงกันหรือไม่
    public boolean login(String inputID, String inputPassword) {
        return studentID.equals(inputID) && password.equals(inputPassword);
    }

    // สร้างเมธอด static ที่จะเช็คการล็อกอินจากอาร์เรย์ของสมาชิก
    public static boolean authenticate(String inputID, String inputPassword) {
        // รายชื่อสมาชิกที่ต้องการให้ใช้งาน
        ArrayList<Member> members = new ArrayList<>();
        members.add(new Member("67050508", "9"));
        members.add(new Member("12345678", "password123"));
        members.add(new Member("98765432", "mypassword")); 

        // ใช้ for-each loop เพื่อตรวจสอบสมาชิกในระบบ
        for (Member member : members) {
            if (member.login(inputID, inputPassword)) {
                return true;  // ถ้าตรงให้เข้าสู่ระบบ
            }
        }
        return false;  // หากไม่ตรงให้ปฏิเสธการเข้าสู่ระบบ
    }
}
