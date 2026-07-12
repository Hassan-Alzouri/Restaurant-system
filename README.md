# Restaurant System

A desktop restaurant management application built with Java Swing, developed as a team capstone project for an Object-Oriented Programming (OOP2) course. The system splits operations between two roles — a **Manager**, who oversees staff, the menu, and sales reports, and a **Cashier**, who takes customer orders and registers loyalty accounts.

## Overview

The application models a real restaurant workflow end to end: cashiers take orders and register customers for a points-based loyalty program, invoices capture order details and earned points, and managers get visibility into sales performance — including best- and worst-selling items — while retaining full control over staff records and the menu.

## Features

- 🔑 **Role-based login** — separate authenticated flows for Manager and Cashier
- 🧑‍💼 **Employee management** — add, update, remove, and view employee records; export employee lists
- 🧾 **Order & invoicing** — cashiers process orders and generate invoices with item counts, date, and customer info
- ⭐ **Customer loyalty program** — customers earn points on orders, redeemable for discounts over time
- 🍽️ **Menu management** — managers can add, edit, or remove menu items and set prices
- 📊 **Sales reporting** — managers can view total orders, best-sellers, and least-ordered items
- 🌗 **Light/dark themed UI** — built with FlatLaf for a modern desktop look and feel

## Tech Stack

| Layer | Technology |
|---|---|
| Application | Java, Java Swing (NetBeans GUI Builder) |
| UI Theming | FlatLaf, FlatLaf Extras |
| Database | MySQL, accessed via JDBC (prepared statements) |
| Design | ER diagram + relational schema mapping (see `/docs`) |
| Build | Ant (NetBeans project) |

## Project Structure

```
Restaurant-system/
├── app/                    # Java Swing application source (NetBeans project)
│   ├── src/
│   │   ├── Dashboard/       # Login, dashboard, customer registration, DB access
│   │   ├── component/       # Shared UI components (header, menu)
│   │   ├── savic_application/  # Application entry point
│   │   └── savic/            # Forms: employee, menu, invoice, reports, cashier lobby
│   └── build.xml
├── Database/
│   └── DatabaseProject.sql  # Schema: Employee, Account, Customer, Invoice, Menu, Sales_Report, Take
└── docs/
    ├── ER(OOP2).drawio        # Entity-relationship diagram
    ├── Mapping(POO2).drawio   # Relational schema mapping
    └── OOP2_Milestone_3.docx  # Project report
```

## Getting Started

### Prerequisites

- Java JDK 8+
- NetBeans IDE (the project uses NetBeans' Ant-based project format)
- MySQL Server

### Setup

1. Clone the repo:
   ```bash
   git clone https://github.com/Hassan-Alzouri/Restaurant-system.git
   ```
2. Create a MySQL database and run `Database/DatabaseProject.sql` to build the schema.
3. Update the connection credentials in `DatabaseAccess.java` to match your local MySQL setup.
4. Open the `app/` project in NetBeans and run it (`Application.java` is the entry point).

## Team

Built as a group project for OOP2, second semester 2024.

| Member | Responsibility |
|---|---|
| **Hassan Mohammed Alzourei** (Team Lead) | Dashboard, ArrayList, and Database Access classes; project supervision |
| Abdulrahman Mohammed Al-mejna | Employee, Customer View, Reports, Logout, Login forms, and UI theming |
| Ahmed Al-Shaikh Mohammed | Report generation |
| Ali Alkhars | Menu view, UML design |
| Abdullah Mohammed Al-Battat | Customer registration |
| Baqer Abdullah Alhaddad | Documentation and UML |

## Design Notes

Full entity-relationship modeling and relational schema mapping were done ahead of implementation (see `/docs`), covering Employee, Account, Customer, Invoice, Sales_Report, Menu, and the Take relation connecting orders to menu items. Database access uses JDBC with prepared statements to guard against SQL injection.
