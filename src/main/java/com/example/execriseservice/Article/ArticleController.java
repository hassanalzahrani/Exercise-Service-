package com.example.execriseservice.Article;

import com.example.execriseservice.Apirespons.ApiResponse;
import com.example.execriseservice.Model.Article;
import com.example.execriseservice.Servicee.ArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/article")
public class ArticleController {

 private final ArticleService articleService;
@GetMapping("get")

public ResponseEntity getAllArticles() {
 ArrayList<Article>articles=articleService.getArticles();
 return ResponseEntity.ok(articles);
}
@PostMapping("/add")
public ResponseEntity addArticle(@Valid @RequestBody Article article, Errors errors) {
 if (errors.hasErrors()) {
  String message = errors.getFieldError().getDefaultMessage();
  return ResponseEntity.badRequest().body(message);
 }
 articleService.addArticle(article);
 return ResponseEntity.status(200).body(new ApiResponse("Article added successfully"));


}
@PutMapping("/update/{id}")
public ResponseEntity updateArticle(@PathVariable int id ,@Valid @RequestBody Article article, Errors errors) {
 if (errors.hasErrors()) {
  String message = errors.getFieldError().getDefaultMessage();

 }
 boolean isUpdated=articleService.updateArticle(id,article);
 if(isUpdated) {
  return ResponseEntity.status(200).body(new ApiResponse("Article updated successfully"));
 }
 return ResponseEntity.status(404).body(new ApiResponse("Article not found"));



}
@DeleteMapping("delete/{id}")
public ResponseEntity deleteArticle(@PathVariable int id) {
 boolean isDeleted=articleService.deleteArticle(id);
 if(isDeleted) {
  return ResponseEntity.status(200).body(new ApiResponse("Article deleted successfully"));
 }
 return ResponseEntity.status(404).body(new ApiResponse("Article not found"));


}
@PutMapping("puplished/{id}")
public ResponseEntity puplished(@PathVariable int id) {
 articleService.puplished(id);
 return ResponseEntity.status(200).body(new ApiResponse("Article pulished successfully"));
}
@GetMapping("/get/{category}")
public ResponseEntity getNewArticaleByCategory (@PathVariable String category) {

 return ResponseEntity.status(200).body(articleService.getNewarticaleByCategory(category));
}
public ResponseEntity getallpublishednewsArticles(){
 return ResponseEntity.status(200).body(articleService.getallpublishednewsArticles());
}




}