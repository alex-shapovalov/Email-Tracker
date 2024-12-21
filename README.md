# Email Tracker with Docker

This project is a Spring Boot application for tracking email opens using a tracking pixel. The application runs in a Docker container and is accessible over HTTP. (Eventual move to HTTPS)

---

## Features

1. **Tracking Pixel:** Tracks when an email is opened via a static tracking pixel URL.
2. **Dockerized Deployment:** Runs the application in a Docker container for easy setup and management.
3. **HTTP Support:** The application is accessible over plain HTTP without HTTPS.

---

```bash
sudo docker-compose up --build -d
```
```bash
http://ip-here:8080/track?email=recipient@example.com
```
```bash
<img src="http://ip-here:8080/track?email=recipient@example.com" style="display:none;" alt="Tracking Pixel" />
```
