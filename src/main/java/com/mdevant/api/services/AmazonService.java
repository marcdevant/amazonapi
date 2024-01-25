package com.mdevant.api.services;

import com.mdevant.api.models.AmazonItem;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AmazonService {
    private final String AMAZON_BESTSELLERS_FASHION_URL = "https://www.amazon.es/gp/bestsellers/fashion/ref=zg_bs_fashion_sm";
    public List<AmazonItem> getFashionBestSellers() {
        List<AmazonItem> list = new ArrayList<AmazonItem>();
        try {
            System.out.println("> Connection to URL");
            Document doc = Jsoup.connect(AMAZON_BESTSELLERS_FASHION_URL).get();
            System.out.println("> Successfully connected!");

            Elements mainContainer = doc.getElementsByClass("a-cardui");
            if (mainContainer != null && mainContainer.size() > 0) {
                Elements itemContainers = mainContainer.first().getElementsByClass("a-column");
                if (itemContainers != null && itemContainers.size() > 0) {
                    for (int i = 0; i < itemContainers.size(); i++) {
                        AmazonItem item = new AmazonItem();
                        Element itemContainer = itemContainers.get(i);

                        //Getting Href attribute
                        Elements links = itemContainer.getElementsByClass("a-link-normal");
                        if (links != null && links.size() > 0) {
                            String href = links.get(0).attr("href");
                            item.setHref(href);
                        }

                        //Getting price
                        Elements prices = itemContainer.getElementsByClass("a-color-price");
                        if (prices != null && prices.size() > 0) {
                            Element price = prices.get(0);
                            String priceStr = price.text();
                            item.setPricestr(priceStr);
                        }

                        //Getting description
                        if (links != null && links.size() >= 2) {
                            Element descriptionContainer = links.get(1);
                            String description = descriptionContainer.text();
                            item.setDescription(description);
                        }

                        list.add(item);
                    }
                }
            }

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

}
