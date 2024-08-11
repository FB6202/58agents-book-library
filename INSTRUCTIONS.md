# instructions to run the application
- download/clone the project
- create a user in your local postgres (username: agents_user, password: password)
- (or change the environment variables in variables.env to custom user of postgres db)
- run 'docker-compose up'
- docker-compose will pull the spring boot app from my personal docker hub (public repo)
- (and the postgres image...)
- use postman, insomnia or the swagger-ui to perform REST calls (or build a whole frontend app in order to use it)