FROM mysql:8.0.16

LABEL maintainer="husseyn.despaignereyes@gmail.com"

ENV MYSQL_ROOT_PASSWORD=test_passw
ENV MYSQL_DATABASE=persons_database
ENV MYSQL_ROOT_HOST=%

COPY ./scripts/ /docker-entrypoint-initdb.d/

CMD ["--default-authentication-plugin=mysql_native_password"]