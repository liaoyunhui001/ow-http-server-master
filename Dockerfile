FROM hub.rongshutong.com/backend/ow_server:latest
WORKDIR /app
RUN set -xe ;
ADD . /app
RUN /app/service start
RUN cp ./bin/docker-entrypoint.sh /entrypoint.sh
VOLUME ["/data"]
EXPOSE 8544 
ENTRYPOINT ["/entrypoint.sh"]
CMD ["supervisord"]
