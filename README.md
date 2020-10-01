# Backend Engineer hiring challenge - Ferenc Hammerl
## Getting started
### Discovery
I started by registering an account on Doodle and playing around a bit with my dashboard. Creating polls, participating in them as different users, checking out the request to `https://api.doodle.com/v2.2/users/me/polls` and its response. 
### Analysys
After analyzing polls.json, I came up with a rough relational DB schema and some ideas about the tech stack.
## Technology choices
### Visual Studio Code + Remote Development / Dev Containers
With VS Code Remote Development, you can use a Docker container as a full-featured development environment. That includes building, running, debugging and testing your application in complete isolation. I am on a new PC and I don't need a JDK installed for development.

Note: While VS Code is great for smaller Java projects, it's not mature enough for complex, multi-project Java solutions.

### Spring Boot
Nothing really comes close.

### PostgreSQL
Easy integration with Java, UUID as primary key natively, can index JSON objects.
