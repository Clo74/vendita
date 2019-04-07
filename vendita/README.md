# Build
mvn clean package && docker build -t com.mycompany/vendta .

# RUN

docker rm -f vendta || true && docker run -d -p 8080:8080 -p 4848:4848 --name vendta com.mycompany/vendta 