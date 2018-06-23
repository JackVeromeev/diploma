package by.veromeev.slaar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("by.veromeev.slaar.entity")
@EnableJpaRepositories("by.veromeev.slaar.dao")
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


//    @Bean
//    @Autowired
//    public ApplicationRunner r2(XmlKnowledgeNodeParser parser, KnowledgeNodeDAO d) {
//        return args -> {
//
//            KnowledgeNodeArray a = parser.parse("<?xml version=\"1.0\" encoding=\"UTF-8\"?><nodes>" +
//                    "<node>" +
//                    "<name>name</name>" +
//                    "<question>q</question>" +
//                    "<answer>a</answer>" +
//                    "<children>" +
//                    "<node>" +
//                    "<name>name1</name>" +
//                    "<question>q1</question>" +
//                    "<answer>a1</answer>" +
//                    "</node>" +
//                    "<node>" +
//                    "<name>name2</name>" +
//                    "<question>q2</question>" +
//                    "<answer>a2</answer>" +
//                    "<special>true</special>" +
//                    "</node>" +
//                    "</children>" +
//                    "</node>" +
//                    "</nodes>");
//            d.saveAll(Arrays.asList(a.getNodes()));
//        };
//    }
}