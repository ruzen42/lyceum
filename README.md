# lyceum

lyceum - это веб-сайт предназначенный для школы.

## Стек технологий

| Слой | Технология |
|------|-----------|
| Backend | Spring Boot 4.0.5 (Java 21) |
| Сборка | Gradle (Kotlin DSL) |
| Шаблоны | JTE 3.2.3 (SSR) |
| База данных | PostgreSQL 15 |
| Аутентификация | JWT (JJWT) + Spring Security |
| Хранилище файлов | AWS S3 / MinIO |
| Поиск | Elasticsearch |
| AI | Spring AI + Ollama (qwen2.5) |
| Прокси | Nginx |
| Инфраструктура | Docker Compose |

## Функциональность

- Главная страница, новости, вакансии, достижения
- Страницы классов и виртуальный музей
- Портфолио учеников
- Страница поступления (подача заявок)
- Личный кабинет ученика
- Административная панель
- Аутентификация через JWT

## Запуск

### Требования

- Docker и Docker Compose
- (опционально) Java 21 + Gradle для локальной разработки

### Через Docker Compose

1. Скопировать файл переменных окружения:
   ```bash
   cp .env.example .env
   ```

2. Заполнить `.env` (обязательные переменные — см. ниже).

3. Запустить:
   ```bash
   docker compose up -d
   ```

Сервисы:

| Сервис | URL |
|--------|-----|
| Сайт | http://localhost |
| Backend API | http://localhost:8080 |
| MinIO Console | http://localhost:9001 |
| Ollama | http://localhost:11434 |

### Локальная разработка (без Docker)

1. Запустить PostgreSQL и MinIO вручную (или через compose только для зависимостей):
   ```bash
   docker compose up -d db minio minio-init ollama
   ```

2. Запустить backend:
   ```bash
   cd backend
   ./gradlew bootRun
   ```

## Переменные окружения

| Переменная | Описание | Пример |
|------------|----------|--------|
| `DB_URL` | JDBC-адрес PostgreSQL | `jdbc:postgresql://localhost:5432/lyceum-db` |
| `DB_USER` | Пользователь БД | `postgres` |
| `DB_PASSWORD` | Пароль БД | |
| `JWT_SECRET` | Секрет для подписи JWT (Base64) | |
| `JWT_EXPIRATION` | Время жизни токена (мс) | `86400000` |
| `AWS_S3_REGION` | Регион S3 | `us-east-1` |
| `AWS_S3_BUCKET` | Имя бакета | |
| `AWS_ACCESS_KEY` | Access key S3/MinIO | |
| `AWS_SECRET_KEY` | Secret key S3/MinIO | |
| `AWS_S3_ENDPOINT_URL` | Endpoint (для MinIO) | `http://minio:9000` |
| `AWS_S3_PUBLIC_URL` | Публичный URL хранилища | `http://localhost/storage` |
| `OLLAMA_URL` | URL Ollama | `http://ollama:11434` |
| `OLLAMA_MODEL` | Модель Ollama | `qwen2.5` |
| `CORS_ALLOWED_ORIGINS` | Разрешённые CORS-источники | `http://localhost:3000` |

## Структура проекта

```
lyceum/
├── backend/                    # Spring Boot приложение
│   ├── src/main/
│   │   ├── java/com/jvmd/lyceum_backend/
│   │   │   ├── config/         # Конфигурации (Security, S3, App)
│   │   │   ├── controller/
│   │   │   │   ├── rest/       # REST API контроллеры
│   │   │   │   └── web/        # SSR веб-контроллеры
│   │   │   ├── model/          # JPA-сущности
│   │   │   ├── repository/     # Spring Data репозитории
│   │   │   ├── service/        # Бизнес-логика
│   │   │   └── payload/        # DTO запросов/ответов
│   │   ├── jte/                # JTE-шаблоны страниц
│   │   └── resources/
│   │       └── application.properties
│   ├── Dockerfile
│   └── build.gradle.kts
├── nginx/
│   └── nginx.conf
├── compose.yaml                # Docker Compose (все сервисы)
└── .env.example
```
