ARG ADMIN_USERNAME
ARG ADMIN_PASSWORD

FROM quay.io/keycloak/keycloak:latest as builder
WORKDIR /opt/keycloak
RUN /opt/keycloak/bin/kc.sh build


FROM eclipse-temurin:latest
COPY --from=builder /opt/keycloak/ /opt/keycloak/

ENV KEYCLOAK_ADMIN=$ADMIN_USERNAME
ENV KEYCLOAK_ADMIN_PASSWORD=$ADMIN_PASSWORD
# RUN apt-get update \
#     && apt-get -y install curl

ENTRYPOINT ["/opt/keycloak/bin/kc.sh"]