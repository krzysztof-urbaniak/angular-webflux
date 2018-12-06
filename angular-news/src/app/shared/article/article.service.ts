import {Injectable} from '@angular/core';
import {Observable, of} from 'rxjs';
import {map} from 'rxjs/operators';
import {HttpClient} from '@angular/common/http';
import {SseService} from '../sse/sse.service';

@Injectable({
    providedIn: 'root'
})
export class ArticleService {

  constructor(private http: HttpClient, private sse: SseService) { }

    getAllAsync(): Observable<Article> {
        return of(
            this.getCreateSampleNews(),
            this.getCreateSampleNews()
        ).pipe(map(data => data.article));
    }

    getArticles() {
        return this.http.get('http://localhost:8080/news/pl/technology')
            .pipe(map<News, Article>(data => data.article));
    }

    getA(): Observable<Article> {
      return this.sse.observeMessages('http://localhost:8080/news/pl/technology')
          .pipe(map(data => data.article));
    }

    private getCreateSampleNews(): News {
        return {
            article: {
                author: 'John Major',
                title: 'Major shift in UK',
                description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed...',
                date: '2018-12-02',
                sourceName: 'Times',
                articleUrl: 'https://www.tabletowo.pl/2018/12/02/google-upraszcza-interfejs-w-sklepie-play/',
                imageUrl: 'http://www.benchmark.pl/uploads/article/68815/BIGICON/288e99696e8703bd87b3e1e72dd151359403a58f.jpg'
            }
        };
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
