# Тестовое задание
Необходимо создать мини проект, который будет загружать JSON данные из HTTP REST сервера в БД.
### Требования

1. Весть проект на SpringBoot, любой версии.

2. Сборка Maven.

3. http клиент на ваш выбор, предпочтительно OkHttp.

4. БД на ваш выбор, предпочтительно postgres.

5. Тест WireMock или JUnit.

<https://lb.api-sandbox.openprocurement.org/api/2.4/contracts/ffb2e977797440719208b510ed91548b/documents>

<https://lb.api-sandbox.openprocurement.org/api/2.4/contracts/6aa21ab58b0f402591ef4cc6abebe6c3/documents>

<https://lb.api-sandbox.openprocurement.org/api/2.4/contracts/800384f02be04ce091277202897de676/documents>

# Конфигурация проекта

В проекте в качестве база данных используется ```PostgreSQL```.

Ниже приведено содержание ```sql``` скрипта для создания базы данных и таблицы.

```SQL
-- Database: public-bid

-- DROP DATABASE "public-bid";

CREATE DATABASE "public-bid"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Russian_Ukraine.1251'
    LC_CTYPE = 'Russian_Ukraine.1251'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
```

```SQL
-- Table: public.contract

-- DROP TABLE public.contract;

CREATE TABLE public.contract
(
    id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    date_modified timestamp without time zone,
    date_published timestamp without time zone,
    document_of character varying(255) COLLATE pg_catalog."default",
    format character varying(255) COLLATE pg_catalog."default",
    hash character varying(255) COLLATE pg_catalog."default",
    title character varying(255) COLLATE pg_catalog."default",
    url character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT contract_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.contract
    OWNER to postgres;
```

## swap API документация

**Методы публичного API**

+ Tочка входа API для загрузки документов с REST сервера в базу данных: ```/upload```
+ Метод: ```POST```
+ Пример:<http://localhost:8080/upload>
+ Пример ответа

```JSON
Body
{
    "success": "The data is loaded into the database"
}
```

```JSON
Headers
content-type →application/json;charset=UTF-8
date →Sat, 21 Apr 2018 16:38:09 GMT
transfer-encoding →chunked
```
