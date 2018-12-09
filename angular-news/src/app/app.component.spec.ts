import {async, TestBed} from '@angular/core/testing';
import {AppComponent} from './app.component';
import {MatButtonModule, MatDividerModule, MatExpansionModule, MatListModule, MatToolbarModule} from '@angular/material';
import {ArticleListComponent} from './article-list/article-list.component';
import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

describe('AppComponent', () => {
    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [
                AppComponent, ArticleListComponent
            ],
            imports: [
                BrowserModule,
                MatExpansionModule,
                MatDividerModule,
                MatListModule,
                MatToolbarModule,
                MatButtonModule,
                BrowserAnimationsModule
            ]
        }).compileComponents();
    }));

    it('should create the app', () => {
        const fixture = TestBed.createComponent(AppComponent);
        const app = fixture.debugElement.componentInstance;
        expect(app).toBeTruthy();
    });

    it(`should have as title 'angular-news'`, () => {
        const fixture = TestBed.createComponent(AppComponent);
        const app = fixture.debugElement.componentInstance;
        expect(app.title).toEqual('angular-news');
    });

    it('should render title in a h1 tag', () => {
        const fixture = TestBed.createComponent(AppComponent);
        fixture.detectChanges();
        const compiled = fixture.debugElement.nativeElement;
        expect(compiled.querySelector('h1').textContent).toContain('Recent News');
    });
});
