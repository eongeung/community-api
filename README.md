# 🏘️ Community API

## 💡 Overview

SNS가 발달하면서 오히려 자신의 생각을 자유롭게 표현하기 어려워졌습니다.
실명 기반 플랫폼에서는 평판, 인간관계를 의식해 솔직한 의견을 내기 힘든 환경이 됐습니다.

이 프로젝트는 눈치 보지 않고 진짜 이야기를 꺼낼 수 있는 익명 커뮤니티 API 서버입니다.

## 🛠️ Tech Stack

`Java 17` `Spring Boot 4.0.3` `Spring Security + JWT` `PostgreSQL` `AWS EC2 · RDS · S3` `GitHub Actions`

## 📌 API Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| POST | /api/users/signup | 회원가입 |
| POST | /api/users/login | 로그인 |
| GET/POST | /api/posts | 게시글 목록/작성 |
| GET/PUT/DELETE | /api/posts/{id} | 게시글 상세/수정/삭제 |
| POST/DELETE | /api/posts/{id}/comments | 댓글 작성/삭제 |
| POST/DELETE | /api/posts/{id}/likes | 좋아요/취소 |

## 🚀 Getting Started
```bash
cp src/main/resources/application.properties.example src/main/resources/application.properties
./gradlew bootRun
```

## 👤 Author

GitHub: [@eongeung](https://github.com/eongeung)
