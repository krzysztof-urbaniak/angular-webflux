import {ArticleListComponent} from './article-list.component';
import {Article, ArticleService} from '../shared/article/article.service';
import {of} from 'rxjs';

describe('ArticleListComponent', () => {
    let component: ArticleListComponent;
    let articleService: ArticleService;
    let spy: any;

    beforeEach(() => {
        articleService = new ArticleService(null);
        component = new ArticleListComponent(articleService);
    });

    it('should initialize articles on create', () => {
        // given:
        const message = of({author: 'John'} as Article);
        spy = spyOn(articleService, 'getArticles').and.returnValue(message);
        // when:
        component.ngOnInit();
        // then:
        expect(component.articles).toEqual([{author: 'John'} as Article]);
    });
});
