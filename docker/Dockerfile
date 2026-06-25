FROM node:18

WORKDIR /app

RUN npm install zxcvbn

COPY app.js .

ENTRYPOINT ["node", "app.js"]