-- UTENTI
INSERT INTO utente (id, nome, surname, cellphone) VALUES (0, 'tommaso', 'rossi', 12345) ON CONFLICT (id) DO NOTHING;
INSERT INTO utente (id, nome, surname, cellphone) VALUES (1, 'luisa', 'bianchi', 67890) ON CONFLICT (id) DO NOTHING;
INSERT INTO utente (id, nome, surname, cellphone) VALUES (2, 'ale', 'verdi', 13579) ON CONFLICT (id) DO NOTHING;
-- AUTO
INSERT INTO automobile (id, plate, model, country, owner_id) VALUES (0, 'CD2', '500', 'italy', 1) ON CONFLICT (id) DO NOTHING;
INSERT INTO automobile (id, plate, model, country, owner_id) VALUES (1, 'EF3', 'panda', 'italy', 1) ON CONFLICT (id) DO NOTHING;
INSERT INTO automobile (id, plate, model, country, owner_id) VALUES (2, 'GH4', 'gtf', 'france', 2) ON CONFLICT (id) DO NOTHING;
-- TICKET
INSERT INTO ticket (id, description, state, estimated_time, cost, car_id) VALUES (0,'sostituzione candele','WIP','1 settimana',30.00,0) ON CONFLICT (id) DO NOTHING;
INSERT INTO ticket (id, description, state, estimated_time, cost, car_id) VALUES (1,'controllo motore','COMPLETED','4 giorni',50.00,0) ON CONFLICT (id) DO NOTHING;
INSERT INTO ticket (id, description, state, estimated_time, cost, car_id) VALUES (2,'tagliando periodico','COMPLETED','2 giorni',120.00,1) ON CONFLICT (id) DO NOTHING;
INSERT INTO ticket (id, description, state, estimated_time, cost, car_id) VALUES (3,'drenaggio e sostituzione liquidi','WIP','2 settimane',200.00,2) ON CONFLICT (id) DO NOTHING;
-- RICAMBIO
INSERT INTO ricambio (id, nome, producer, quantity) VALUES (0,'olio motore','fiat',4) ON CONFLICT (id) DO NOTHING;
INSERT INTO ricambio (id, nome, producer, quantity) VALUES (1,'candela','fiat',8) ON CONFLICT (id) DO NOTHING;
INSERT INTO ricambio (id, nome, producer, quantity) VALUES (2,'fanale','ford',3) ON CONFLICT (id) DO NOTHING;
INSERT INTO ricambio (id, nome, producer, quantity) VALUES (3,'cinghia trasmissione','fiat',10) ON CONFLICT (id) DO NOTHING;
INSERT INTO ricambio (id, nome, producer, quantity) VALUES (4,'batteria','bmw',1) ON CONFLICT (id) DO NOTHING;
-- CREDENZIALI
INSERT INTO credenziali (id, username, password, user_role, user_id) VALUES (0, 'kylix', '$2a$12$nyfe3EpguXvYduWqt46YbuzkNvgPAelIboSi2WT.DXE0OL7XWSI.G', 'ADMIN', 0) ON CONFLICT (id) DO NOTHING;
INSERT INTO credenziali (id, username, password, user_role, user_id) VALUES (1, 'lulu', '$2a$12$nyfe3EpguXvYduWqt46YbuzkNvgPAelIboSi2WT.DXE0OL7XWSI.G', 'USER', 1) ON CONFLICT (id) DO NOTHING;
INSERT INTO credenziali (id, username, password, user_role, user_id) VALUES (2, 'ale', '$2a$12$nyfe3EpguXvYduWqt46YbuzkNvgPAelIboSi2WT.DXE0OL7XWSI.G', 'USER', 2) ON CONFLICT (id) DO NOTHING;

SELECT setval('utente_seq', GREATEST(COALESCE((SELECT MAX(id) FROM utente), 0) + 1, 20), false);
SELECT setval('automobile_seq', GREATEST(COALESCE((SELECT MAX(id) FROM automobile), 0) + 1, 20), false);
SELECT setval('ticket_seq', GREATEST(COALESCE((SELECT MAX(id) FROM ticket), 0) + 1, 20), false);
SELECT setval('ricambio_seq', GREATEST(COALESCE((SELECT MAX(id) FROM ricambio), 0) + 1, 20), false);
SELECT setval('credenziali_seq', GREATEST(COALESCE((SELECT MAX(id) FROM credenziali), 0) + 1, 20), false);

