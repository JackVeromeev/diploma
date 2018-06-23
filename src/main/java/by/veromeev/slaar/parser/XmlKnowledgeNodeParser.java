package by.veromeev.slaar.parser;

import by.veromeev.slaar.entity.KnowledgeNode;
import by.veromeev.slaar.entity.dto.KnowledgeNodeArray;
import lombok.SneakyThrows;
import org.jdom2.Element;
import org.jdom2.input.DOMBuilder;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class XmlKnowledgeNodeParser implements KnowledgeNodeParser {

    @Override
    @SneakyThrows
    public KnowledgeNodeArray parse(String data) {
        org.jdom2.Document jdomDoc;
        jdomDoc = useDOMParser(data);
        Element root = jdomDoc.getRootElement();
        return new KnowledgeNodeArray(
                processKnowledgeNode(root).toArray(new KnowledgeNode[0])
        );
    }

    private List<KnowledgeNode> processKnowledgeNode(Element listElement) {
        List<KnowledgeNode> knowledgeNodes = new ArrayList<>();
        if (listElement != null) {
            List<Element> knowledgeNodeElements = listElement.getChildren("node");
            System.out.println(knowledgeNodeElements.size());
            for (Element element : knowledgeNodeElements) {
                KnowledgeNode newNode = new KnowledgeNode();
                newNode.setName(element.getChildText("name"));
                newNode.setQuestion(element.getChildText("question"));
                newNode.setAnswer(element.getChildText("answer"));
                newNode.setIsSpecial(Boolean.parseBoolean(element.getChildText("special")));
                newNode.getKnowledgeNodes().addAll(
                        processKnowledgeNode(element.getChild("children"))
                );
                newNode.getKnowledgeNodes().forEach(child -> child.setParentNode(newNode));
                knowledgeNodes.add(newNode);
            }
        }
        return knowledgeNodes;
    }

    private org.jdom2.Document useDOMParser(String data)
            throws ParserConfigurationException, IOException, org.xml.sax.SAXException {
        //creating DOM Document
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(
                new InputSource(new ByteArrayInputStream(data.getBytes("utf-8")))
        );
        DOMBuilder domBuilder = new DOMBuilder();
        return domBuilder.build(doc);
    }
}
