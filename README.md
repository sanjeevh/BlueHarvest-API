# BlueHarvest API

A Simple set of REST APIs built as part of Blue Harvest assignment. 

## Design 
This application is implemented using Spring boot. Key design element is the seperation of concern between the REST API ( Spring controllers ), Pojo service layer and the Data access layer built using JPA and Spring data. 
The source code have sufficient Test coverage using JUnit / Spring based test harness.

## API Specification
The full API specification ( Swagger file ) is available at the URL https://app.swaggerhub.com/apis/sanjeevh/BlueHarvest/1.0.0 It speicifies the endpoint details and request / response structure and other REST specific details. 

## Usage 
use mvn clean install to build the project , It will create a jar package which is self contained and locally runs on port 8080.
run the application jar using java -jar account-servicing-api-0.0.1-SNAPSHOT.jar to launch the web application at port 8080.
use the REST endpoint - http://localhost:8080/accounts/ & http://localhost:8080/customers/{id} to create account and fetch customer details respectively. 

On startup, the in-memory database is populated with two Customers ( Bank users ) with customer ID 1 & 2 , these IDs can be used in the parameters to create a new account. If more Customer data is needed during startup then the file at location /BlueHarvestAPI/src/main/resources/data.sql should be updated.

## Live deployment available on AWS  
The full implementation of the API spec is deployed on the AWS environment for a quick demo. 

the base URL of the API is - http://blueharvestapi-env.gdfm5euqpu.us-east-1.elasticbeanstalk.com 

## UI 
User Interface to easily play around with the APIs is available at - https://app.swaggerhub.com/apis/sanjeevh/BlueHarvest/1.0.0 which is intergrated with the APIs deployed on the AWS. 

To execute the API , Please use the "try-out" feature on above page as shown in below picture :







