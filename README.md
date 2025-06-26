# DataBlend API

A Spring Boot REST API that merges user data from multiple sources — MySQL, MongoDB, and CSV files — and provides export functionality in JSON, CSV, and PDF formats.

## Features

- Fetch combined user data from MySQL, MongoDB, and CSV.
- Export merged data as CSV and PDF files.
- Clean and modular code structure using Spring Boot.
- Uses OpenCSV for CSV handling and iText for PDF generation.

## Technologies Used

- Java 17
- Spring Boot 3.1.3
- MySQL
- MongoDB
- OpenCSV
- iText PDF
- Lombok

## Endpoints

| Method | Endpoint             | Description                  |
|--------|----------------------|------------------------------|
| GET    | `/api/users/all`      | Get all combined user data in JSON format |
| GET    | `/api/users/export/csv` | Export combined user data as CSV |
| GET    | `/api/users/export/pdf` | Export combined user data as PDF |

## Getting Started

1. Clone the repo  
   ```bash
   git clone https://github.com/akhilnedunuri/datablend-api.git
