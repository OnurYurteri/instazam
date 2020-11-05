# instazam


### Run with docker-compose
```bash
cd instazam
./mvnw package
docker build -t instazam-backend:1.0 .
docker-compose up
```

### Test It
```bash
curl --location --request POST 'localhost:8080/1.0/recognize-from-video' \
--header 'Content-Type: application/json' \
--data-raw '{
    "type" : "VIDEO_MP4",
    "url" : "https://instagram.com/a/b"
}'
```
