import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {News} from '../article/article.service';

@Injectable({
    providedIn: 'root'
})
export class SseService {

    constructor() {
    }

    observeMessages(url: string): Observable<News> {
        return new Observable(obs => {
            const es = new EventSource(url);
            es.addEventListener('message', (event: MessageEvent) => {
                obs.next(JSON.parse(event.data));
            });
            es.onerror = () => {
                es.close();
            };
            es.addEventListener('closed', () => obs.complete());
            return () => es.close();
        });
    }
}
