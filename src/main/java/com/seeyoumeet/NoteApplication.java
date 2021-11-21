package com.seeyoumeet;

/**
 * @Classname NoteApplication
 * @Description ：...
 * @Date ：2021-11-21
 * @Created by seeyoumeet
 */
@SpringBootApplication(scanBasePackages="com.seeyoumeet.*")
@EnableTransactionManagement
@ServletComponentScan
@ComponentScan({"com.seeyoumeet.*"})
//@MapperScan({"com.seeyoumeet.mapper"})
public class NoteApplication {

    private static final Logger log = LogManager.getLogger();

    public static void main(String[] args) {
        try {
            SpringApplication.run(NoteApplication.class, args);
            SpringApplication.run(com.seeyoumeet.NoteApplication.class, args);
        } catch (Exception e) {
            log.error("SpringApplication.run()", e);
        }
    }

//    @PostConstruct
//    public void init() {
//
//    }
}
