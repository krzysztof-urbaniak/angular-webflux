import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {MatExpansionModule} from '@angular/material/expansion';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatDividerModule} from '@angular/material/divider';
import {AppComponent} from './app.component';
import {ArticleListComponent} from './article-list/article-list.component';
import {MatListModule, MatToolbarModule} from '@angular/material';
import {HttpClientModule} from '@angular/common/http';
import {MatButtonModule} from '@angular/material/button';

@NgModule({
    declarations: [
        AppComponent,
        ArticleListComponent
    ],
    imports: [
        BrowserModule,
        MatExpansionModule,
        MatDividerModule,
        MatListModule,
        MatToolbarModule,
        MatButtonModule,
        BrowserAnimationsModule,
        HttpClientModule
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule {
}
