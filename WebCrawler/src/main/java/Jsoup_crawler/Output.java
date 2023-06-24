package Jsoup_crawler;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;
import java.io.IOException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Output {

    static void text_output(Document doc) {

            Elements paragraphs = doc.select("p");

            System.out.println(doc.select("title").text());

            for (Element paragraph : paragraphs) {

                System.out.println(paragraph.text());

            }


        System.out.println();

    }


}
