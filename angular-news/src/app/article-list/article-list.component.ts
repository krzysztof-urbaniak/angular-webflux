import { Component, OnInit } from '@angular/core';
import {ArticleService} from '../shared/article/article.service';
import {Article} from '../shared/article/Article';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-article-list',
  templateUrl: './article-list.component.html',
  styleUrls: ['./article-list.component.css']
})
export class ArticleListComponent implements OnInit {
  articles: Array<Article>;

  constructor(private articleService: ArticleService) { }

  ngOnInit() {
      this.articles = this.articleService.getAllSync();
  }

}
