# ms_user-email Microservice

This project is part of a microservice architecture, specifically handling the email sending functionality triggered by user creation in the associated user creation microservice.

## Overview

When the user creation microservice triggers a message dispatch, this microservice, through its consumer (also known as listener), picks up the message from the RabbitMQ queue and sends an email based on the configuration in the application.properties file.

## Key Features

- Consumes messages from RabbitMQ queue
- Sends emails using JavaMailSender
- Error handling using Enum
- Shares database with user creation microservice, but uses a separate table

## Components

1. **Consumer**: Responsible for retrieving and consuming messages from the RabbitMQ queue.
2. **EmailService**: Handles the email sending process using JavaMailSender. It uses setters to populate email details from the EmailModel.
3. **EmailModel**: Represents the email entity and is responsible for creating and manipulating the "emails" table in the database.
4. **Repository**: Manages the persistence of the EmailModel entity.
5. **Enum**: Handles error states and successful email sending status.
6. **Config**: Contains configuration for connecting to the RabbitMQ queue as a consumer.
7. **DTO**: Data Transfer Object for email, shared with the user creation microservice.

## Project Structure

The project follows a structure similar to the user creation microservice:

- `configs`: RabbitMQ consumer configuration
- `consumer`: Handles message consumption from RabbitMQ
- `dtos`: Contains EmailDTO shared with the user creation microservice
- `enums`: Defines email status (e.g., SENT, ERROR)
- `models`: Defines EmailModel for the "emails" table
- `repositories`: Manages data persistence for the EmailModel
- `services`: Contains EmailService for sending emails

## Technologies Used

- Spring Boot
- PostgreSQL (shared with user creation microservice)
- RabbitMQ
- JavaMailSender

## How It Works

1. The consumer listens for messages on the RabbitMQ queue.
2. When a message is received, it's processed by the EmailService.
3. The EmailService uses JavaMailSender to send an email based on the received message.
4. The result of the email sending process (success or failure) is stored in the database.

## Setup and Configuration

(Add instructions on how to set up and run the project locally, including any necessary environment variables or application.properties settings)

## Dependencies

This project relies on the JavaMailSender dependency, which was added through the Spring Initializr.

## Error Handling

Errors are captured and managed using an Enum, allowing for standardized error reporting and handling.
