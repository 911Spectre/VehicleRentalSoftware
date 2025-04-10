# Car Rental Software

## Description
Car Rental Software is a Java-based desktop application for managing car rentals. Built with **Java Swing** and **PostgreSQL**, it supports managing car inventory, customers, rentals, and returns. Features include a splash screen, secure login, automatic fine calculations, and CSV exports. The system uses **Maven** for project management and is packaged as a JAR.

**Student Name:** [Arslan]

## Objectives
- Efficiently manage cars, customers, rentals, and returns.
- Integrate a PostgreSQL database for persistent data.
- Automate rental fees and fine calculations.
- Implement secure user login with admin access.
- Provide CSV export for data reporting.

## Dependencies & Build
- **PostgreSQL JDBC Driver** `org.postgresql:postgresql:42.5.0`
- **rs2xml** `net.proteanit.sql:rs2xml:1.0` (manual install)
- **JCalendar** `com.toedter:jcalendar:1.4`
- **AbsoluteLayout** `org.netbeans.external:AbsoluteLayout:RELEASE122`
- **Maven Compiler Plugin** `maven-compiler-plugin:3.10.1` (Java 17)
- **MySQL Connector/J** included but unused

## Installation
1. Clone the repo: `git clone <repository-url>`
2. Install Java 17, Maven, PostgreSQL.
3. Create DB `vehicledb` with:
   - Username: `**********`
   - Password: `**********`
4. Run: `mvn clean install`
5. Launch app: `java -jar target/CarRentalProgram-1.0-SNAPSHOT.jar`

## Usage
- Splash screen → login (`admin123` / `admin`)
- Modules:
  - **Cars**: Add/update/delete, export
  - **Customers**: Manage records, export
  - **Rent Car**: Process rentals, auto fee calc
  - **Return Car**: Handle returns, calc delay + fine
- Export CSV to desktop
- Logout or exit anytime

## Features
- Car and customer management with JTable views
- Rental and return processing with fee/fine automation
- CSV export for all modules
- Secure login (admin + future user roles)
- Real-time UI updates from DB

## Database Schema
### Tables
- **cartable** (`StateNumber`, `Brand`, `Model`, `Status`, `Price`)
- **customertable** (`CustId`, `CustName`, `CustAddress`, `CustPhone`)
- **renttable** (`CarStateNum`, `CustName`, `RentDate`, `ReturnDate`, `RentFees`)
- **returntable** (`CarStateNum`, `CustName`, `RetDate`, `Delay`, `Fine`)
- **usertable** *(assumed)*: for login/authentication

## Requirements
1. Splash screen on startup
2. Login with admin credentials
3. Add/update/delete cars
4. Add/update/delete customers
5. Rent cars + calculate rental fee
6. Return cars + calculate delay + fine
7. PostgreSQL integration for all tables
8. Export all data as CSV
9. Sidebar UI for navigation
10. Automated rental + fine calculations

## Implementation Details

### Algorithms
#### Fee Calculation (`Rents.java`)
- `Fee = Days × Price` using date diff (`RentDate` to `ReturnDate`)
- Invalid date selection triggers error

#### Fine Calculation (`Returns.java`)
- `Fine = Fee + (DelayDays × Price)`
- If no delay → fine = `Fee` only

### Key Modules / Functions
- `Connect()` — sets up DB connection via JDBC
- `DisplayX()` — loads data from DB to JTables (cars, rents, etc.)
- `UpdateCar()` — changes car `Status` between `Available`/`Booked`
- `ExportX()` — writes data to CSV (cars, customers, rents, returns)
- `Reset()` — clears input fields
- `CreateUser.java` — adds new user accounts (admin only)

### Data Structures
- **PostgreSQL tables** for persistent storage
- **JTable** (`DefaultTableModel`) to show data
- **JComboBox** to select customer/car names from DB

## Known Issues / Limitations
- `CreateUser.java` not fully implemented
- MySQL JDBC dependency unused
- Limited exception feedback (via `JOptionPane`)
- Hardcoded DB credentials (security risk)

## Future Improvements
- Full user roles (admin, staff, viewer)
- Better error handling and validation
- Responsive layouts (replace AbsoluteLayout)
- Secure credential storage (e.g. config file or env vars)
- UI/UX improvements with better styling
