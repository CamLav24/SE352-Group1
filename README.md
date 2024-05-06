## Overview
This project aims to create a robust object-oriented system for managing hotel data. It provides a structured framework for organizing information related to hotels, rooms, guests, reservations, and more. By utilizing object-oriented principles, the codebase ensures flexibility, scalability, and maintainability.

## Project Members
| Members | Area | Role |
|---------|-----|------|
| Cameron Laviste | Classes | Developing Hotel Class|
| Jon Doretti | SQL | Database establishment|
| Vinod Kotapati | Persistance | TBD|
| Zhanyuan Tang | Persistance| dao/dto for hotel database |
| Shihua Zhang | Data finding | Hotel Service for list| 

## Features
Hotel Class: Represents a hotel with attributes such as name, address, contact information, and a collection of rooms.

Room Class: Defines individual rooms within a hotel, including room number, type (single, double, suite, etc.), availability status, and pricing information.

Guest Class: Represents guests staying at the hotel, with attributes like name, contact details, and possibly membership information.

Reservation Class: Manages reservations made by guests, including check-in/out dates, room allocation, guest information, and billing details.

Payment Class: Manages payment transactions made by guests, including payment dates, amounts, methods, and associated booking details.

Booking Class: Handles guest bookings, storing information such as check-in and check-out dates, room details, and payment amounts.

## Communication Mechanism
We will be using discord to communicate

## Decisions Made
To be Added
## Setup Instructions
Clone the Repository: Start by cloning the repository to your local machine:

## Meeting Notes

| #   | Date      | Note                                                                             | Participants |
|-----|-----------|----------------------------------------------------------------------------------|--------------|
| 1   | 4-4-2024  | We decided our project scope and setup env.                                      | All          |
 | 2   | 4-25-2024 | Created Basic project and Divided the inital features.                           | All          |



<br/>

## Decision Made

| #   | Area                  | Decision     | Alternative | Rationale                                                             |
|-----|-----------------------|--------------|-------------|-----------------------------------------------------------------------|
| 1   | IDE                   | IntelliJ IDEA | VS Code     | Language independent editor so that it can be used in non java course |
| 2   | Dependency Management | Maven        | Gradle      | familiarity                                                           |
| 3   | Configurations        | Application properties           | YML         | Liked this approach                                                   |
| 4   | Database              | H2            | -           | Will update according to requirement.                                 |


...
## Usage
To use the hotel data project:
...


## Appendix

Working code (Milestone 1):

![img.png](src/main/resources/img/img.png)

![img1.png](src/main/resources/img/img1.png)


Working code (Milestone 2):

![img2.png](src/main/resources/img/img2.png)

![img3.png](src/main/resources/img/img3.png)
