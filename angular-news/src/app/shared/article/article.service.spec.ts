import {Article, ArticleService, News} from './article.service';
import {of} from 'rxjs';
import {SseService} from '../sse/sse.service';

describe('ArticleService', () => {
    let articleService: ArticleService;
    let sseService: SseService;
    let spy: any;

    beforeEach(() => {
        sseService = new SseService();
        articleService = new ArticleService(sseService);
    });

    it('should map data correctly', () => {
        // given:
        const articles: Article[] = [];
        const data = {
            article: {
                author: 'John'
            } as Article
        } as News;
        spy = spyOn(sseService, 'observeMessages').and.returnValue(of(data));
        // when:
        articleService.getArticles().subscribe((article) => articles.push(article));
        // then:
        expect(articles).toEqual([{author: 'John'} as Article]);
    });

    it('should call correct service', () => {
        // given:
        const articles: Article[] = [];
        const data = {
            article: {
                author: 'John'
            } as Article
        } as News;
        spy = spyOn(sseService, 'observeMessages').and.returnValue(of(data));
        // when:
        articleService.getArticles().subscribe((article) => articles.push(article));
        // then:
        expect(sseService.observeMessages).toHaveBeenCalledWith('http://localhost:8080/news/pl/technology');
    });
});
