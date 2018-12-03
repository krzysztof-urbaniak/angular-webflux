import { Injectable } from '@angular/core';
import {Observable, of} from 'rxjs';
import {Article, News} from './Article';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  constructor() { }

    getAll(): Observable<News> {
        return of(
            this.getCreateSampleNews(),
            this.getCreateSampleNews()
        );
    }

    private getCreateSampleNews() {
        return new News(
          new Article(
              'John Major',
              'Major shift in UK',
              'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed...',
              '2018-12-02',
              'Times',
              'https://www.tabletowo.pl/2018/12/02/google-upraszcza-interfejs-w-sklepie-play/',
              'http://www.benchmark.pl/uploads/article/68815/BIGICON/288e99696e8703bd87b3e1e72dd151359403a58f.jpg'
          )
        );
    }
}
