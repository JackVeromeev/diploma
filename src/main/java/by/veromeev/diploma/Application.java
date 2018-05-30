package by.veromeev.diploma;

import by.veromeev.diploma.core.ApplicationStatus;
import by.veromeev.diploma.dao.KnowledgeNodeDAO;
import by.veromeev.diploma.entity.dto.KnowledgeNodeArray;
import by.veromeev.diploma.parser.XmlKnowledgeNodeParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;

@SpringBootApplication
@EntityScan("by.veromeev.diploma.entity")
@EnableJpaRepositories("by.veromeev.diploma.dao")
public class Application {

    public static void main(String[] args) {
        System.out.println("hello");
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ApplicationStatus maintenanceStatus() {
        return new ApplicationStatus();
    }

    //    @Bean
//    @Autowired
//    public ApplicationRunner r(JsonKnowledgeNodeParser jsonParser) {
//        return args -> {
//            jsonParser.parse("{\"nodes\":[{\n" +
//                    "\"name\":\"lol\",\n" +
//                    "\"question\":\"lol1\",\n" +
//                    "\"answer\":\"lol2\",\n" +
//                    "\"children\":[{\n" +
//                    "\"name\":\"lol3\",\n" +
//                    "\"question\":\"lol4\",\n" +
//                    "\"answer\":\"lol5\",\n" +
//                    "\"isSpecial\":\"true\",\n" +
//                    "\"children\":[]}]\n" +
//                    "},{\n" +
//                    "\"name\":\"lol\",\n" +
//                    "\"question\":\"lol1\",\n" +
//                    "\"answer\":\"lol2\",\n" +
//                    "\"children\":[]}]}");
//
//        };
//    }
//
    @Bean
    @Autowired
    public ApplicationRunner r2(XmlKnowledgeNodeParser parser, KnowledgeNodeDAO d) {
        return args -> {

            KnowledgeNodeArray a = parser.parse("<?xml version=\"1.0\" encoding=\"UTF-8\"?><nodes>" +
                    "<node>" +
                    "<name>name</name>" +
                    "<question>q</question>" +
                    "<answer>a</answer>" +
                    "<children>" +
                    "<node>" +
                    "<name>name1</name>" +
                    "<question>q1</question>" +
                    "<answer>a1</answer>" +
                    "</node>" +
                    "<node>" +
                    "<name>name2</name>" +
                    "<question>q2</question>" +
                    "<answer>a2</answer>" +
                    "<special>true</special>" +
                    "</node>" +
                    "</children>" +
                    "</node>" +
                    "</nodes>");
            d.saveAll(Arrays.asList(a.getNodes()));
        };
    }
}