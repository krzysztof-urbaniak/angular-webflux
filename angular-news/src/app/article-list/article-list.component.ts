import { Component, OnInit } from '@angular/core';
import {Article, ArticleService} from '../shared/article/article.service';

@Component({
  selector: 'app-article-list',
  templateUrl: './article-list.component.html',
  styleUrls: ['./article-list.component.css']
})
export class ArticleListComponent implements OnInit {
  articles: Article[] = [];

  constructor(private articleService: ArticleService) { }

  ngOnInit() {
      this.articleService.getArticles().subscribe((article) => this.articles.push(article));
  }

}
