insert into address (id, address_line1, address_line2, city, postal_code)
            values (1, 'xx', 'yy', 'city', '62-030');

INSERT INTO doctor (id,first_name, last_name, telephone_number, email, doctor_number, specialization)
            VALUES (1,'Jerzy', 'Dorański', 733733733, 'jerzy.doranski@wp.pl', 1, 'Pediatra');

INSERT INTO doctor (id,first_name, last_name, telephone_number, email, doctor_number, specialization)
            VALUES (2,'Paweł', 'Rubek', 123123145, 'pawel.rubek@wp.pl', 2, 'Chirurg');

INSERT INTO patient (id,first_name, last_name, telephone_number, email, patient_number, date_of_birth, contact_person_phone_number)
            VALUES (2,'Tomek', 'Tomkowski', 778778778, 'tom.test@wp.pl', 2, '1990-01-01', '721721721');

INSERT INTO patient (id,first_name, last_name, telephone_number, email, patient_number, date_of_birth, contact_person_phone_number)
            VALUES (3,'Arek', 'Mostowiak', 888888745, 'arek90@wp.pl', 3, '1990-01-01', '123446789');

INSERT INTO patient (id,first_name, last_name, telephone_number, email, patient_number, date_of_birth, contact_person_phone_number)
            VALUES (4,'Bartek', 'Mostowiak', 888777444, 'bartek90@wp.pl', 4, '1991-01-01', '123456789');

INSERT INTO  visit (id, description, time, patient_entity_id, doctor_entity_id)
            VALUES (1,'Jakas notatka','2024-05-06 14:53:00',2,1);

INSERT INTO  visit (id, description, time, patient_entity_id, doctor_entity_id)
            VALUES (2,'Jakas notatka','2024-05-07 14:53:00',3,1);

INSERT INTO  visit (id, description, time, patient_entity_id, doctor_entity_id)
            VALUES (3,'Jakas notatka','2024-05-07 14:53:00',2,2);

INSERT INTO  visit (id, description, time, patient_entity_id, doctor_entity_id)
            VALUES (4,'Jakas notatka','2024-05-08 14:53:00',2,1);

INSERT INTO  medical_treatment (description, type, visit_entity_id)
            VALUES ('Konsultacja lekarska', 'Konsultacja',1);

INSERT INTO  medical_treatment (description, type, visit_entity_id)
            VALUES ('Konsultacja lekarska', 'Zabieg',2);

INSERT INTO  medical_treatment (description, type, visit_entity_id)
            VALUES ('Konsultacja lekarska', 'Operacja',3);

INSERT INTO  medical_treatment (description, type, visit_entity_id)
            VALUES ('Konsultacja lekarska', 'Porada',4);