# Sherpa

This is a simple project using Java EE in order to perform a test.

Libraries used:
JAX-RS for RESTful API endpoint.

The app works and responds in the following relative path:
/api/register

and it is expecting the following query parameters:
http://localhost:8080/SherpaEE/api/register?username=javi&postCode=48991

Runned and tested on a glassFish application server.

JUnit test provided for main clases and services:
Register Resource
MasterDBService
DetailsDBService
