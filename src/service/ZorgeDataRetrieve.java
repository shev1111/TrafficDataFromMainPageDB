package service;


import model.Category;
import model.Template;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ZorgeDataRetrieve {
    private String url;
    private static Document document;
    private final static String US_PROXY_IP = "205.145.146.174";
    private final static int US_PROXY_IP_PORT = 41004;

    public ZorgeDataRetrieve() {
        File in = new File("C:/Users/Tom/Desktop/index.html");
        try {
            document = Jsoup.parse(in, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Template> getTemplates(){

        List<Template> templates = new ArrayList<>();

        if(document!=null){

            Elements rows = document.getElementsByClass("tooltip");
            Elements category = document.getElementsByClass("category");
            Elements table = document.select("table");
            Iterator<Element> rowIterator = rows.iterator();
            Iterator<Element> tableIterator = table.iterator();
//            System.out.println(category.get(1));
//            System.out.println(table.get(1));
            for (int i = 0;i<category.size();i++){
                String tempCategory = category.get(i).select("span").first().text();
                Element tbl = table.get(i);
                Elements tooltips = tbl.getElementsByClass("tooltip");
                Iterator<Element> tooltipsIterator = tooltips.iterator();
                while (tooltipsIterator.hasNext()){
                    Element tooltip = tooltipsIterator.next();
                    Elements colHeaders = tooltip.select("span");
                    Elements urls = tooltip.select("a");
                    Elements linkImage = tooltip.select("img");
                    Template template = new Template();
                    Elements urlName = tooltip.select("strong");
                    if(!colHeaders.text().isEmpty()){

                        //System.out.println("info - "+colHeaders.text().trim());
                        template.setInfo(colHeaders.text().trim());

                    }

                    try {
                        //System.out.println("urls - "+urls.first().attr("href"));
                        template.setUrl(urls.first().attr("href"));
                    } catch (Exception e) {
                        //e.printStackTrace();
                    }
                    //.out.println("pageName - "+urlName.text());
                    template.setName(urlName.text());
                    //System.out.println("linkImage - "+linkImage.attr("src"));
                    template.setImage(linkImage.attr("src"));
                    template.setCategory(tempCategory);
                    //System.out.println("Category - "+template.getCategory());
                    templates.add(template);
                    System.out.println(template);
                }

            }

            //System.out.println(templates.size());
        }
        return templates;
    }

    public List<Category> getCategories(){
        String asin = null;
        List<Category> categories = new ArrayList<>();
        if(document!=null){

            Elements navigation = document.getElementsByClass("sidenav");
            Elements a_nav = navigation.select("a");

            Iterator<Element> navIterator = a_nav.iterator();
            while (navIterator.hasNext()){
                Category category = new Category();
                Element aTag = navIterator.next();
                category.setName(aTag.text());
                if(!category.getName().equals("×")){
                    categories.add(category);
                }
            }
            System.out.println(categories);


        }
        return categories;
    }







}
