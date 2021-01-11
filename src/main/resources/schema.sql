CREATE TABLE solicitud (
  id INT NOT NULL AUTO_INCREMENT,
  cliente_id VARCHAR(100) NOT NULL,
  nombre_razon_social VARCHAR(100),
  dni_cuit VARCHAR(100),
  fecha_envio DATETIME,
  visualizado BOOL DEFAULT FALSE,
  PRIMARY KEY (id)
);

CREATE TABLE firmante (
    id INT NOT NULL AUTO_INCREMENT,
    nombre varchar(100) NOT NULL,
    solicitud_id INT,
    PRIMARY KEY (id),
    CONSTRAINT fk_solicitud_id FOREIGN KEY (solicitud_id) REFERENCES solicitud (id)
);