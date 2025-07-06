FROM node:18-alpine AS build

WORKDIR /app

COPY . .

RUN npm install && npm run build --prod

RUN ls -lR /app/dist/

FROM nginx:alpine

COPY --from=build app/dist/country-app/browser /usr/share/nginx/html

COPY nginx.conf /etc/nginx/conf.d/default.conf

CMD ["nginx", "-g", "daemon off;"]