package Jsoup_crawler;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Output {

    static void text_output(Document doc) {

            Elements paragraphs = doc.select("p, title");

            for (Element paragraph : paragraphs) {

                System.out.println(paragraph);

            }


        System.out.println();

    }


}
