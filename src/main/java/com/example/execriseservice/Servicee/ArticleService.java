package com.example.execriseservice.Servicee;

import com.example.execriseservice.Model.Article;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class ArticleService {
ArrayList<Article> articles = new ArrayList<>();

public ArrayList<Article> getArticles() {
    return articles;
}
public void addArticle(Article article) {
    articles.add(article);

}
public boolean updateArticle(int id ,Article article) {
    for (int i = 0; i < articles.size(); i++) {
        if (articles.get(i).getTitle().equals(article.getTitle())) {
            articles.set(i, article);
            return true;
        }
    }
    return false;
}
public boolean deleteArticle(int id) {
    for (int i = 0; i < articles.size(); i++) {
        if (articles.get(i).getId() == id) {
            articles.remove(i);
        }
        return true;
    }
    return false;
}

public void puplished(int id) {
    for (int i = 0; i < articles.size(); i++) {
        if (articles.get(i).getId() == id) {
            articles.get(i).setPublished(true);
                articles.get(i).setPublishDate(LocalDate.now());
        }

    }
}
public ArrayList<Article> getNewarticaleByCategory(String category) {
    ArrayList<Article> newarticale = new ArrayList<>();
    for (int i = 0; i < articles.size(); i++) {
        if (articles.get(i).getCategory().equals(category)) {
            newarticale.add(articles.get(i));



        }
    }
    return newarticale;

}
public ArrayList<Article> getallpublishednewsArticles(){
    ArrayList<Article> newarticale = new ArrayList<>();

    for (int i = 0; i < articles.size(); i++) {
        if (articles.get(i).isPublished()) {
            newarticale.add(articles.get(i));



        }
    }
    return newarticale;

}


}
