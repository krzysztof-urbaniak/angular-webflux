import {Injectable} from '@angular/core';
import {Observable, of} from 'rxjs';
import {map} from 'rxjs/operators';
import {SseService} from '../sse/sse.service';

@Injectable({
    providedIn: 'root'
})
export class ArticleService {

  constructor(private sse: SseService) { }

    getArticles(): Observable<Article> {
      return this.sse.observeMessages('http://localhost:8080/news/pl/technology')
          .pipe(map(data => data.article));
    }
}

export interface News {
    article: Article;
}

export interface Article {
    author: string;
    title: string;
    description: string;
    date: string;
    sourceName: string;
    articleUrl: string;
    imageUrl: string;
}
