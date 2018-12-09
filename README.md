# angular-webflux

## App based on Webflux
### build
`cd webflux-news` 
`./gradlew build`
### run
`cd webflux-news` 
`./gradlew run`

### Documentation
`http://localhost:8080/swagger-ui.html`

## App based on Angular
(Node.js is needed.)
### build
`cd angular-news`
`npm install`
### run
`cd webflux-news` 
`npm start` or `ng-serve` if you downloaded Angular CLI.
Go to:
`http://localhost:4200`.

## Running applications with Docker

### build
Make sure to build applications first:
* For the Angular one, first run `npm install` and then `npm run ng build` in the `angular-news` folder.
* For the Spring Boot application, execute `./gradle build` in the `webflux-news` folder.


### run
Run `docker-compose up` from the `docker` folder. 
Go to: `localhost:8900`.
