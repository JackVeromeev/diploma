package by.veromeev.slaar.integration;

import by.veromeev.slaar.Application;
import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource("classpath:app-test.yml")
public class AdminSecurityTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldReturnLoginPageUnauthenticated() throws Exception {
        val result = mockMvc
                .perform(
                        MockMvcRequestBuilders.get("/")
                )
                .andReturn();
        assertEquals(302, result.getResponse().getStatus());
        String[] redirectedUrlParts = result.getResponse().getRedirectedUrl().split("/");
        assertEquals(4, redirectedUrlParts.length);
        assertEquals("login", redirectedUrlParts[3]);
    }

    public void d() {
        System.out.println("{\"nodes\":[{\n" +
                "\"name\":\"lol\",\n" +
                "\"question\":\"lol1\",\n" +
                "\"answer\":\"lol2\",\n" +
                "\"children\":[{\n" +
                "\"name\":\"lol3\",\n" +
                "\"question\":\"lol4\",\n" +
                "\"answer\":\"lol5\",\n" +
                "\"isSpecial\":\"true\",\n" +
                "\"children\":[]}]\n" +
                "},{\n" +
                "\"name\":\"lol\",\n" +
                "\"question\":\"lol1\",\n" +
                "\"answer\":\"lol2\"\n" +
                "}]}");
    }
}
