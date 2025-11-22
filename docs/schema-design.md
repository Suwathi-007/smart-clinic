# MySQL Schema Design - smart_clinic_db

## Tables

### 1. doctor
- id INT AUTO_INCREMENT PRIMARY KEY
- name VARCHAR(100) NOT NULL
- email VARCHAR(100) UNIQUE NOT NULL
- specialty VARCHAR(100)
- available_times JSON  -- stores daily time slots or recurring availability
- created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP

### 2. patient
- id INT AUTO_INCREMENT PRIMARY KEY
- name VARCHAR(100) NOT NULL
- email VARCHAR(100) UNIQUE NOT NULL
- phone VARCHAR(20)
- created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP

### 3. appointment
- id INT AUTO_INCREMENT PRIMARY KEY
- doctor_id INT NOT NULL
- patient_id INT NOT NULL
- appointment_time DATETIME NOT NULL
- status VARCHAR(20) DEFAULT 'BOOKED'
- notes TEXT
- created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
- FOREIGN KEY (doctor_id) REFERENCES doctor(id)
- FOREIGN KEY (patient_id) REFERENCES patient(id)

### 4. prescription
- id INT AUTO_INCREMENT PRIMARY KEY
- appointment_id INT NOT NULL
- doctor_id INT NOT NULL
- patient_id INT NOT NULL
- medication TEXT NOT NULL
- instructions TEXT
- created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
- FOREIGN KEY (appointment_id) REFERENCES appointment(id)
- FOREIGN KEY (doctor_id) REFERENCES doctor(id)
- FOREIGN KEY (patient_id) REFERENCES patient(id)
