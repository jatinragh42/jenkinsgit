# Stage 1: Build the Angular application
FROM node:16.19.1 as build

WORKDIR /app

# Copy package.json and package-lock.json files
COPY package.json package-lock.json ./

# Install Angular CLI globally
RUN npm install -g @angular/cli@16.0.0

# Install dependencies with legacy peer dependencies flag
RUN npm install --legacy-peer-deps

# Copy the entire Angular project
COPY . .

# Build the Angular application
RUN ng build --output-path=/app/P10-UI

# Stage 2: Serve the Angular application with Tomcat
FROM tomcat:latest

# Remove the default Tomcat application
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copy the built Angular files from Stage 1 to Tomcat
COPY --from=build /app/P10-UI /usr/local/tomcat/webapps/ROOT

# Expose port 4200 (Tomcat default)
EXPOSE 4200
