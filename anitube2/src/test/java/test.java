import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ogiwara on 2017/03/28.
 */
public class test {

    public static void main(String[] args) throws IOException{
        HttpTransport httpTransport = new NetHttpTransport();
        try{
            HttpRequestFactory requestFactory = httpTransport.createRequestFactory();
            GenericUrl url = new GenericUrl("http://www.anitube.se/");
            HttpRequest req = requestFactory.buildGetRequest(url);
            HttpResponse res = req.execute();
            try {
                String html = res.parseAsString();
                Document document = Jsoup.parse(html);
                Element element = document.getElementById("fragment-1");
                //System.out.println(element.outerHtml());

                Document document1 = Jsoup.parse(element.outerHtml());
                Elements elements = document1.select("#fragment-1 ul .mainList");
                Element e = elements.first();//foreacher

                Document document2 = Jsoup.parse(e.outerHtml());
                Elements elements1 = document2.select(".mainList .videoThumb");
                Element e2 = elements1.first();
                String str = e2.outerHtml();

                String str2 = StringUtils.substringAfter(str,"a href=\"");

                String str3 = StringUtils.substringBefore(str2,"\" title");

                System.out.println(str3);

                /*GenericUrl url1 = new GenericUrl(str3);
                HttpRequest req1 = requestFactory.buildGetRequest(url1);
                HttpResponse res1 = req1.execute();

                System.out.println(res1.parseAsString());*/

            }finally {
                res.disconnect();
            }
        }finally {
            httpTransport.shutdown();
        }
    }

}
