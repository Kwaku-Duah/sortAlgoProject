# Sorting Algorithms RESTful API Project

This project demonstrates the implementation of a RESTful API using servlets that adheres to HATEOAS principles. It includes various sorting algorithms (Heap Sort, Quick Sort, Merge Sort, Radix Sort, and Bucket Sort) and is configured to run on an Apache Tomcat web server.



## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup and Installation](#setup-and-installation)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Usage](#usage)
- [HATEOAS](#hateoas)
- [Contribution](#contribution)
- [License](#license)



## Introduction

This project is a web application built with Java servlets, deployed on an Apache Tomcat server, and designed to demonstrate RESTful API principles with a focus on HATEOAS (Hypermedia as the Engine of Application State). It includes various sorting algorithms to manipulate datasets.



## Features

1. **HTTP Protocols & Apache Tomcat Web Server:**

   - Configure and deploy the web application on Apache Tomcat.
   - Ensure proper handling of HTTP requests and responses.

2. **API Design:**

   - Design a RESTful API adhering to HATEOAS principles.
   - Implement API endpoints for CRUD operations on a sample dataset.

3. **Sorting Algorithms:**
   - Implement Heap Sort, Quick Sort, Merge Sort, Radix Sort, and Bucket Sort algorithms.
   - Integrate these sorting algorithms within the application for data manipulation.
   - Provide an interface to select and execute different sorting algorithms on a sample dataset.

---

## Technologies Used

- Java
- Servlets (Jakarta EE)
- Apache Tomcat
- JSON for data interchange
- Maven for build automation
- HTML, CSS for frontend


## Setup and Installation

### Prerequisites

- Java Development Kit (JDK) 8 or later
- Apache Tomcat 9 or later
- Maven
- VSCode

### Cloning the Repository

```sh
git clone git remote add origin git@github.com:Kwaku-Duah/sortAlgoProject.git
cd sortAlgoProject
```

### Building the Project

```sh
mvn clean install
```

### Deploying to Tomcat

1. **Copy the WAR file** generated in the `target` directory to the `webapps` directory of your Apache Tomcat installation.

   ```sh
   cp target/sorting-algorithms-api.war /path/to/tomcat/webapps/
   ```

2. **Start Tomcat**:

   ```sh
   /path/to/tomcat/bin/startup.sh
   ```

3. **Access the application** at `http://localhost:8080/sorting-algorithms-api`.



## Running the Application

### Accessing the Web Application

- Once Tomcat is running and the application is deployed, navigate to `http://localhost:8080/sorting-algorithms-api` to access the web interface.

### Using the API Endpoints

Use tools like Postman or `curl` to interact with the API.


## API Endpoints

### GET /api/sorting

- Description: Retrieve the available sorting algorithms.
- Response: List of sorting algorithms with HATEOAS links.

### POST /api/sorting/{algorithm}

- Description: Sort the provided dataset using the specified algorithm.
- Request Body: JSON array of integers.
- Response: Sorted array with HATEOAS links.


## Usage

### Sorting Array Example

1. **Navigate to the application**.
2. **Select the sorting algorithm** you want to use.
3. **Enter the dataset** (comma-separated values).
4. **Submit the form** to see the sorted results along with HATEOAS links for further actions.



## HATEOAS

This application follows HATEOAS principles by including links in the API responses that guide the client on possible actions, enhancing the discoverability and usability of the API.



## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

