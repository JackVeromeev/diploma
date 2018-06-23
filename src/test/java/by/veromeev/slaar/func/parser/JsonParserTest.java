package by.veromeev.slaar.func.parser;

import by.veromeev.slaar.entity.KnowledgeNode;
import by.veromeev.slaar.parser.KnowledgeNodeParsingService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JsonParserTest {

    private KnowledgeNodeParsingService parsingService;

    @Before
    public void initService() {
        parsingService = new KnowledgeNodeParsingService();
    }

    @Test
    public void shouldParse3Nodes() {
        KnowledgeNode[] nodes = parsingService.parse(KnowledgeNodeParsingService.DocumentType.JSON, "{\"nodes\":[{\n" +
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
                "}]}").getNodes();
        Assert.assertEquals(nodes[0].getName(), "lol");
    }

}
