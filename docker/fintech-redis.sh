docker run -d \
--name fintech-redis \
-p 6379:6379 \
--network docker_fintech \
redis:latest