# tikgik-bank

# docker commands
docker run --name accountsDb -e POSTGRES_USER=dev -e POSTGRES_PASSWORD=123 -p 5432:5432 -v accountdb-data:/var/lib/postgresql/data -v D:\dev\projects\tikgik-bank\account\init.sql:/docker-entrypoint-initdb.d/init.sql -d postgres
---
docker run --name banksDb -e POSTGRES_USER=dev -e POSTGRES_PASSWORD=123 -p 5433:5432 -v bankdb-data:/var/lib/postgresql/data -v D:\dev\projects\tikgik-bank\bank\init.sql:/docker-entrypoint-initdb.d/init.sql -d postgres
---
docker run --name cardsDb -e POSTGRES_USER=dev -e POSTGRES_PASSWORD=123 -p 5434:5432 -v carddb-data:/var/lib/postgresql/data -v D:\dev\projects\tikgik-bank\card\init.sql:/docker-entrypoint-initdb.d/init.sql -d postgres
---
docker run -d -p 6379:6379 --name tikgikRedis  -v redisdb-data:/data redis redis-server --appendonly yes
---
download the apache httpd to load test the apis with ab.exe from this link
https://www.apachelounge.com/download/

ab.exe -n 10 -c 2 -v 3 http://localhost:8072/tikgik/card/api/v1/cards/contact
---
# google jib command
mvn compile jib:dockerBuild
---