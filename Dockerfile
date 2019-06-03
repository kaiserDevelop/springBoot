FROM java:8
VOLUME /tmp
ADD target/inventory-0.0.1-SNAPSHOT.jar inventario.jar
RUN bash -c 'touch /inventario.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /inventario.jar"]