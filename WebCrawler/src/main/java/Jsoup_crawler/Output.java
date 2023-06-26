package Jsoup_crawler;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

public class Output {

    static void text_output(Document doc, String url) {

            Elements paragraphs = doc.select("p, title, h1, h2, h3, h4, h5, h6");



            // vypis

            System.out.println("URL: " + url);

            for (Element paragraph : paragraphs) {
                System.out.println(Text_filter.text_filter(paragraph.toString()));
            }

            System.out.println(Language_detector.language_detector(doc));
            System.out.println();







            }
    }



