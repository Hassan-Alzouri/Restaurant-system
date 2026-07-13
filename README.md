# Restaurant System

A desktop restaurant management application built with Java Swing, developed as a team capstone project for an Object-Oriented Programming (OOP2) course. The system splits operations between two roles — a **Manager**, who oversees staff, the menu, and sales reports, and a **Cashier**, who takes customer orders and registers loyalty accounts.

## Overview

The application models a real restaurant workflow end to end: cashiers take orders and register customers for a points-based loyalty program, invoices capture order details and earned points, and managers get visibility into sales performance — including best- and worst-selling items — while retaining full control over staff records and the menu. The UI is built on the FlatLaf "Raven" dashboard template for a modern, themeable look.

## Features

- 🔑 **Role-based login** — separate authenticated flows for Manager and Cashier
- 🧑‍💼 **Employee management** — add, update, remove, and view employee records; export employee lists
- 🧾 **Order & invoicing** — cashiers process orders and generate invoices with item counts, date, and customer info
- ⭐ **Customer loyalty program** — customers earn points on orders, redeemable for discounts over time
- 🍽️ **Menu management** — managers can add, edit, or remove menu items and set prices
- 📊 **Sales reporting** — managers can view total orders, best-sellers, and least-ordered items
- 🌗 **Light/dark themed UI** — built on FlatLaf with a Raven dashboard template for a modern desktop look and feel

## Tech Stack

| Layer | Technology |
|---|---|
| Application | Java, Java Swing (NetBeans GUI Builder) |
| UI Theming | FlatLaf, FlatLaf Extras, Raven dashboard template |
| Database | MySQL, accessed via JDBC (prepared statements) |
| Other libraries | Gson, MigLayout, TimingFramework, JSVG, DateChooser |
| Design | ER diagram + relational schema mapping (see `/docs`) |
| Build | Ant (NetBeans project) |

## Project Structure

```
restaurant-system/
├── app/                       # Java Swing application (NetBeans project)
│   ├── src/
│   │   ├── Dashboard/           # Login, dashboard, customer registration, DB access
│   │   ├── component/           # Shared UI components (header, menu)
│   │   ├── raven/                # FlatLaf Raven dashboard UI framework (theme, menu, icons)
│   │   ├── savic/                 # Forms: employee, menu, invoice, reports, cashier lobby
│   │   ├── savic_application/     # Application entry point
│   │   ├── images12/               # Menu item images
│   │   └── imagesLogin/            # Login screen images
│   ├── lib/                      # Third-party JAR dependencies
│   ├── nbproject/                # NetBeans project configuration
│   └── build.xml
├── Database/
│   └── DatabaseProject.sql    # Schema: Employee, Account, Customer, Invoice, Menu, Sales_Report, Take
└── docs/
    ├── ER(OOP2).drawio          # Entity-relationship diagram
    ├── Mapping(POO2).drawio     # Relational schema mapping
    └── OOP2_Milestone_3.docx    # Project report
```

## Getting Started

### Prerequisites

- Java JDK 8+
- NetBeans IDE (the project uses NetBeans' Ant-based project format)
- MySQL Server

### Setup

1. Clone the repo:
   ```bash
   git clone https://github.com/Hassan-Alzouri/restaurant-system.git
   ```
2. Create a MySQL database and run `Database/DatabaseProject.sql` to build the schema.
3. Update the connection credentials in `app/src/Dashboard/DatabaseAccess.java` to match your local MySQL setup.
4. Open the `app/` folder as a project in NetBeans (File → Open Project) — the JAR dependencies in `app/lib/` are already referenced by the project configuration, no manual library setup needed.
5. Run the project (`F6` or the green Run button) — `savic_application.Application` is the entry point.

## Design Notes

Full entity-relationship modeling and relational schema mapping were done ahead of implementation (see `/docs`), covering Employee, Account, Customer, Invoice, Sales_Report, Menu, and the Take relation connecting orders to menu items. Database access uses JDBC with prepared statements to guard against SQL injection.
