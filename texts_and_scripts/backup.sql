-- База данных: app_db
-- Дата: 2025-10-29

INSERT INTO users (id, username, password_hash) 
VALUES (1, 'admin', 'smcksmaskwmks');

-- TODO: обновить ключ — текущий: sk_live_samkci9w0cnwincw


CREATE TABLE config (
  key VARCHAR(50) PRIMARY KEY,
  value TEXT
);

INSERT INTO config (key, value) VALUES
('stripe_key', 'sk_live_snomvm39wcnjnsk'),
('sendgrid_key', 'SG.ssmwi9.xmnqiwocjw9');
