# Задание про интеграционный сервис

## Способ 1:
- `git clone https://github.com/Etsor/BookRegistryService`
- Установить [Docker](https://www.docker.com/)
- Запустить `docker-compose up` в папке `BookRegistryService/docker`

## Способ 2:
- `git clone https://github.com/Etsor/BookRegistryService`
- Установить [JDK 21](https://www.oracle.com/nl/java/technologies/downloads/#java21)
- Установить [PostgreSQL](https://www.postgresql.org/download/) и [pgAdmin4](https://www.pgadmin.org/download/)
- Создать файл `.env` на примере `.env-example`
- Запустить скрипт `run.sh` для **macOS/Linux** или `run.bat` для **Windows**
***

- После запуска документация будет доступна по адресу `localhost:8080/swagger-ui/index.html`
![Документация](/images/img_1.png)
![Документация](/images/img_2.png)
