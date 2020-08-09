package cn.zjm404.demo.di;

import cn.zjm404.demo.di.template.MyTestBean;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyXMLBeanConfigParser implements MyBeanConfigParser{
    @Override
    public List<MyBeanDefinition> parse(InputStream inputStream) {
        List<MyBeanDefinition> myBeanDefinitions = new ArrayList();
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(inputStream);
            //获取所有一级子节点
            NodeList nodesList = document.getChildNodes();
            for (int i = 0; i < nodesList.getLength(); i++) {

                Node node  = nodesList.item(i);
                if(node.getNodeType() != Node.ELEMENT_NODE){
                    continue;
                }
                NodeList nodeList = node.getChildNodes();
                for (int j = 0; j < nodeList.getLength(); j++) {
                    Node item = nodeList.item(j);
                    if(item.getNodeType() != Node.ELEMENT_NODE){
                        continue;
                    }
                    MyBeanDefinition myBeanDefinition = new MyBeanDefinition(
                            item.getAttributes().getNamedItem("id").getNodeValue(),
                            item.getAttributes().getNamedItem("class").getNodeValue()
                    );
                    if (item.getAttributes().getNamedItem("scope").getNodeValue().equalsIgnoreCase("PROTOTYPE")) {
                        myBeanDefinition.setScope(MyBeanDefinition.Scope.PROTOTYPE);
                    }
                    if (item.getAttributes().getNamedItem("lazy-init").getNodeValue().equalsIgnoreCase("true")) {
                        myBeanDefinition.setLazyInit(true);
                    }
                    loadProperty(
                            item.getChildNodes(),
                            myBeanDefinition
                    );
                    myBeanDefinitions.add(myBeanDefinition);
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myBeanDefinitions;
    }
    public void loadProperty(NodeList nodeList,MyBeanDefinition myBeanDefinition){

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() != Node.ELEMENT_NODE){
                continue;
            }
            if(node.getNodeName().equals("property")){
                MyBeanDefinition.Property property = null;
                if(node.getAttributes().getNamedItem("isList").getNodeValue().equalsIgnoreCase("false")){
                    property = new MyBeanDefinition.Property.Builder()
                            .setName(node.getAttributes().getNamedItem("name").getNodeValue())
                            .setRef(node.getAttributes().getNamedItem("ref").getNodeValue())
                            .build();

                }else if(node.getAttributes().getNamedItem("isList").getNodeValue().equalsIgnoreCase("true")){
                    NodeList nodes = node.getChildNodes();
                    List<String> beans = new LinkedList<>();
                    for (int j = 0; j < nodes.getLength(); j++) {
                        Node node1 = nodes.item(i);
                        if (node1.getNodeType() != Node.ELEMENT_NODE){
                            continue;
                        }
                        String bean = node1.getAttributes().getNamedItem("bean").getNodeValue();
                        if(!bean.isEmpty()){
                            beans.add(bean);
                        }
                    }
                    property = new MyBeanDefinition.Property.Builder()
                            .setName(node.getAttributes().getNamedItem("name").getNodeValue())
                            .setRefs(beans)
                            .build();
                }
                myBeanDefinition.addProperty(property);
            }
        }
    }

}

class Demo{
    public Object documentAnalysis(InputStream in){
        Object res = null;
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(in);
            //获取所有一级子节点
            NodeList nodesList = document.getChildNodes();
            for (int i = 0; i < nodesList.getLength(); i++) {

                Node node  = nodesList.item(i);
                if(node.getNodeType() != Node.ELEMENT_NODE){
                    continue;
                }
                NodeList nodeList = node.getChildNodes();
                for (int j = 0; j < nodeList.getLength(); j++) {
                    Node item = nodeList.item(j);
                    if(item.getNodeType() != Node.ELEMENT_NODE){
                        continue;
                    }
                    res = Class.forName(item.getAttributes().getNamedItem("class").getNodeValue()).getDeclaredConstructor().newInstance();
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return res;
    }
    public Object getBean(String path){
        Object obj = null;
        try(InputStream in = this.getClass().getResourceAsStream(path)){
            if (in == null){
                throw new RuntimeException("找不到配置文件" + path);
            }
            obj =  documentAnalysis(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }
    public static void main(String[] args) {
        MyTestBean myTestBean  = (MyTestBean) new Demo().getBean("/config/demo1.xml");
        System.out.println(myTestBean.getMsg());
    }
}
