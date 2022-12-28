FROM postgres:latest

EXPOSE 5430
VOLUME /var/lib/postgresql/data

#1 docker build -t cvtheme_db .
#2 docker run -d -p 5430:5432 --name cvtheme_db --env-file .env cvtheme_db