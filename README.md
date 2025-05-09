# 🧾 Personal Finance Tracker – Development Roadmap

## ✅ Phase 1: Core User Management

### 📌 Iteration 1.1 – Project Setup
- [ ] Initialize Spring Boot project
- [ ] Add dependencies: Spring Web, Security, JPA, JWT, Lombok
- [ ] Setup PostgreSQL or H2
- [ ] Configure application.yml
- [ ] Initialize Git repo + README

### 📌 Iteration 1.2 – User Entity & Repository
- [ ] Create `User` entity
- [ ] Define `UserRepository`

### 📌 Iteration 1.3 – Registration Endpoint
- [ ] Create `/register` endpoint
- [ ] Validate input
- [ ] Encrypt password and save to DB

### 📌 Iteration 1.4 – Login & JWT Authentication
- [ ] Create `/login` endpoint
- [ ] Generate JWT on success
- [ ] Add JWT filter and configure Spring Security

### 📌 Iteration 1.5 – User Profile
- [ ] Create `/me` endpoint
- [ ] Allow update of name/email/password

## ✅ Phase 2: Expense & Income Tracking

### 📌 Iteration 2.1 – Define Transaction Entity
- [ ] Create `Transaction` entity with: date, amount, type, category, note

### 📌 Iteration 2.2 – CRUD Endpoints
- [ ] POST `/transactions`
- [ ] GET `/transactions`
- [ ] GET `/transactions/{id}`
- [ ] PUT `/transactions/{id}`
- [ ] DELETE `/transactions/{id}`

### 📌 Iteration 2.3 – Category Management
- [ ] Create `Category` entity
- [ ] Pre-populate default categories
- [ ] Allow custom user categories (optional)

### 📌 Iteration 2.4 – Filters & Pagination
- [ ] Add pagination (`page`, `size`)
- [ ] Filter by type, date range, category
- [ ] Sort by date/amount

## ✅ Phase 3: Budget Planning & Notifications

### 📌 Iteration 3.1 – Budget Entity
- [ ] Create `Budget` entity
- [ ] CRUD endpoints for monthly category budgets

### 📌 Iteration 3.2 – Budget Usage Calculation
- [ ] Compare expenses with budgeted amounts
- [ ] Return current usage for a month

### 📌 Iteration 3.3 – Notifications
- [ ] Background job checks for budget usage
- [ ] Notify user on 80% and 100% usage
- [ ] Send email/log or store in DB

## ✅ Phase 4: Reports & Dashboard

### 📌 Iteration 4.1 – Monthly Summary
- [ ] Income, Expenses, Net Savings per month
- [ ] Endpoint for summarized view

### 📌 Iteration 4.2 – Category Breakdown
- [ ] Group expenses by category (for charts)
- [ ] Group by month (trend over time)

### 📌 Iteration 4.3 – Export Reports
- [ ] CSV export
- [ ] PDF export with Apache POI/iText

## ✅ Phase 5: Recurring Transactions

### 📌 Iteration 5.1 – RecurringTransaction Entity
- [ ] Fields: frequency, nextRunDate, etc.
- [ ] CRUD endpoints

### 📌 Iteration 5.2 – Recurring Transaction Job
- [ ] Spring scheduled job
- [ ] Auto-create transaction when due
- [ ] Update next run date

## ✅ Phase 6: Integrations & Advanced

### 📌 Iteration 6.1 – Simulated Bank Integration
- [ ] Fetch mock transaction data from external API
- [ ] Import and map to user transactions

### 📌 Iteration 6.2 – Currency Conversion API
- [ ] Integrate with public FX API
- [ ] Convert foreign transactions to base currency

### 📌 Iteration 6.3 – Audit Logging
- [ ] Log updates to budget/transactions
- [ ] Use AOP or Entity Listeners
