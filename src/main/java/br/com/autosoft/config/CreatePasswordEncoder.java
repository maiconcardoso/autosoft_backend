package br.com.autosoft.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CreatePasswordEncoder{

   public String encode(String password) {
      BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
      return passwordEncoder.encode(password);
   }
}
