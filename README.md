# ru.faickoff.api.proxy

REST API proxy microservice of Faickoff - provides proxy configuration for the current user.

## Table of Contents

1. [Overview](#overview)
2. [Prerequisites](#prerequisites)
3. [Quick Start](#quick-start)
4. [Configuration](#configuration)
5. [Running the Application](#running-the-application)
   - [Local Development with Maven](#local-development-with-maven)
   - [Docker Development Mode](#docker-development-mode)
   - [Production Mode](#production-mode)
6. [Contacts](#contacts)
7. [License](#license)

## Overview

Microservice for managing and providing proxy configurations for the current user.

## Prerequisites

- **Java 17+** (for local development)
- **Maven** (or use included `./mvnw` wrapper)
- **Docker & Docker Compose** (for containerized deployment)

## Quick Start

### 1. Clone and configure
```bash
git clone https://github.com/stonedch/ru.faickoff.api.proxy
cd ru.faickoff.api.proxy

# Configure environment variables
cp .env.example .env
# Edit .env according to your configuration

# Configure application
cp src/main/resources/application.properties.example src/main/resources/application.properties
# Edit application.properties according to your configuration
```

### 2. Run the application
```bash
./mvnw spring-boot:run
```

## Configuration

### .env file
```bash
cp .env.example .env
# Edit the .env file according to your configuration
```

### application.properties file
```bash
cp src/main/resources/application.properties.example src/main/resources/application.properties
# VERY IMPORTANT: Specify ports and addresses that match the values from .env
```

## Running the Application

### Local Development with Maven

1. **Start dependent services:**
   ```bash
   docker-compose -f docker-compose.redis.yml up -d --build
   docker-compose -f docker-compose.database.yml up -d --build
   ```

2. **Run the application:**
   ```bash
   ./mvnw spring-boot:run
   ```

### Docker Development Mode

Run in development mode without database persistence:
```bash
docker-compose -f docker-compose.develop.yml up -d --build
```

### Production Mode

Run in production mode with data persistence:
```bash
docker-compose up -d --build
```

## Contacts

**Maintainer:** Maxim Mukhin
- GitHub: [@stonedch](https://github.com/stonedch)
- Email: stch.max.muhin@gmail.com
- Telegram: [@stonedch](https://t.me/stonedch)

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
