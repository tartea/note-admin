package org.tartea.note;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.tartea.note.mapper")
public class NoteAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoteAdminApplication.class, args);
    }

}
