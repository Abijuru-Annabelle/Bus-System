# Bus Management System

A comprehensive Java-based application for managing bus operations, passenger bookings, and transportation logistics. This system provides a complete solution for bus companies to handle fleet management, passenger services, and operational reporting.

## Features

### 🚍 Bus Fleet Management
- **Multiple Bus Types**: Support for City, Express, Luxury, School, Tourist, and Electric buses
- **Factory Pattern Implementation**: Clean object creation using the BusFactory pattern
- **Bus Tracking**: Real-time location and status monitoring
- **Maintenance Management**: Track maintenance schedules and vehicle health

### 👥 Passenger Services
- **Passenger Registration**: Complete passenger profile management
- **Ticket Booking**: Streamlined booking process with validation
- **Payment Processing**: Integrated payment handling system
- **Booking Management**: View, modify, and cancel bookings

### 📊 Reporting & Analytics
- **Comprehensive Reports**: Generate detailed operational reports
- **Fleet Utilization**: Monitor bus usage and efficiency
- **Revenue Tracking**: Financial reporting and analysis
- **Passenger Statistics**: Demographic and booking pattern analysis

### 🔧 System Features
- **Input Validation**: Robust data validation and error handling
- **User-Friendly Interface**: Console-based menu system
- **Data Persistence**: In-memory data management (easily extensible to database)
- **Modular Architecture**: Well-structured, maintainable codebase

## Project Structure

```
BusSystem/
├── BusSystem.java          # Main application entry point
├── BusFactory.java         # Factory for creating different bus types
├── BusManager.java         # Bus management and operations
├── Vehicle.java            # Abstract base class for vehicles
├── CityBus.java            # City bus implementation
├── ExpressBus.java         # Express bus implementation
├── LuxuryBus.java          # Luxury bus implementation
├── SchoolBus.java          # School bus implementation
├── TouristBus.java         # Tourist bus implementation
├── ElectricBus.java        # Electric bus implementation
├── Passenger.java          # Passenger entity
├── Booking.java            # Booking management
├── Payment.java            # Payment processing
├── Ticket.java             # Ticket generation
├── Driver.java             # Driver information
├── Route.java              # Route management
├── Schedule.java           # Schedule handling
├── Maintenance.java        # Maintenance tracking
├── ReportGenerator.java    # Report generation utilities
├── InputValidator.java     # Input validation utilities
├── Trackable.java          # Tracking interface
├── Bookable.java           # Booking interface
└── README.md              # Project documentation
```

## Installation & Setup

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Command line interface (Terminal/PowerShell)

### Compilation
1. Navigate to the project directory:
   ```bash
   cd BusSystem
   ```

2. Compile all Java files:
   ```bash
   javac *.java
   ```

### Running the Application
1. After compilation, run the main class:
   ```bash
   java BusSystem
   ```

2. Follow the on-screen menu to interact with the system

## Usage

The application provides a menu-driven interface with the following main options:

1. **Add a New Bus**: Register different types of buses with specific attributes
2. **Register a Passenger**: Create passenger profiles for booking
3. **Book a Ticket**: Reserve seats on available buses
4. **Track a Bus**: Monitor bus location and status
5. **Generate Reports**: View various operational reports
6. **Exit**: Close the application

### Bus Types and Attributes

- **City Bus**: Includes low-floor accessibility feature
- **Express Bus**: Specifies number of stops
- **Luxury Bus**: WiFi availability
- **School Bus**: Associated school name
- **Tourist Bus**: Tour guide information
- **Electric Bus**: Battery capacity specification

## Architecture

### Design Patterns Used
- **Factory Pattern**: `BusFactory` for creating different bus types
- **Abstract Classes**: `Vehicle` as base for all bus implementations
- **Interfaces**: `Trackable` and `Bookable` for modular functionality

### Key Classes
- `BusSystem`: Main controller with menu system
- `BusManager`: Handles bus operations and data
- `InputValidator`: Ensures data integrity and user input validation
- `ReportGenerator`: Creates various system reports

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## Future Enhancements

- Database integration for persistent storage
- GUI interface using JavaFX or Swing
- Real-time GPS tracking integration
- Mobile application companion
- API endpoints for third-party integrations
- Advanced analytics and machine learning predictions

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Contact

For questions or support, please open an issue in the repository.

---

**Built with Java** | **Console Application** | **Object-Oriented Design**
