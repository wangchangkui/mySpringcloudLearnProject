package com.myxiaowang;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.keygen.BytesKeyGenerator;
import org.springframework.security.crypto.keygen.KeyGenerators;

/**
 * @author wck
 * @version 1.0.0
 * @Description
 * @createTime 2022年11月04日 14:12:00
 */

public class ApplicationTest {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean matches2 = passwordEncoder.matches("admin","$2a$10$Bqf8TtterPbpupunjdu4muHfz0zkxBR/LAWKVbdx9iyAMnVOX3xUi"); //false
        System.out.println(matches2);
    }
}
