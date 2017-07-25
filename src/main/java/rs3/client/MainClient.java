package rs3.client;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class MainClient {
    public static void main(String[] args) {

        PasswordEncoder enc = new BCryptPasswordEncoder();
        System.out.println(enc.encode("admin"));
        System.out.println(enc.matches("admin","$2a$10$6llxa0oCNmlW60r9zqrfe.2gVcOxnBrnGCVTbl0dAJtt8VskIyDz2"));
    }
}
