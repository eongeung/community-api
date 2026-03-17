# 🏘️ Community API

> 눈치 보지 않고 진짜 이야기를 꺼낼 수 있는 익명 커뮤니티 REST API

## 🛠️ Tech Stack
`Java 17` `Spring Boot 4.0.3` `JWT` `JPA` `PostgreSQL` `AWS EC2 · RDS · S3` `nginx` `GitHub Actions`

## ☁️ Architecture
```
Client → nginx (80) → Spring Boot (8080) → RDS (PostgreSQL)
→ S3 (이미지)
```

## 📌 API
| Method | URL | Description |
|--------|-----|-------------|
| POST | /api/users/signup | 회원가입 |
| POST | /api/users/login | 로그인 |
| GET/POST | /api/posts | 게시글 목록/작성 |
| GET/PUT/DELETE | /api/posts/{id} | 게시글 상세/수정/삭제 |
| POST/DELETE | /api/posts/{id}/comments | 댓글 작성/삭제 |
| POST/DELETE | /api/posts/{id}/likes | 좋아요/취소 |
| GET | /api/images/presigned-url | S3 이미지 업로드 URL 발급 |

## 🚀 Getting Started
```bash
cp src/main/resources/application.properties.example src/main/resources/application.properties
./gradlew bootRun
```

## 👤 Author
GitHub: [@eongeung](https://github.com/eongeung)

