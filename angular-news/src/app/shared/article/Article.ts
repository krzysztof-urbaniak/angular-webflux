export class News {
  article: Article;

  constructor(article: Article) {
    this.article = article;
  }
}

export class Article {
    author: string;
    title: string;
    description: string;
    date: string;
    sourceName: string;
    articleUrl: string;
    imageUrl: string;


    constructor(
        author: string,
        title: string,
        description: string,
        date: string,
        sourceName: string,
        articleUrl: string,
        imageUrl: string
    ) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.date = date;
        this.sourceName = sourceName;
        this.articleUrl = articleUrl;
        this.imageUrl = imageUrl;
    }
}
