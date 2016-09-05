CREATE DATABASE ruleoflaw;
USE ruleoflaw;

CREATE TABLE IF NOT EXISTS income_group(
id INT NOT NULL,
income_group_code CHAR(3) NOT NULL,
income_group_name CHAR(20) NOT NULL,
PRIMARY KEY(id)
)ENGINE INNODB;

CREATE TABLE IF NOT EXISTS countries(
id INT NOT NULL AUTO_INCREMENT,
country_code CHAR(5) NOT NULL, 
country_name CHAR(25) NOT NULL,
income_group_id INT NOT NULL,
PRIMARY KEY(id),
CONSTRAINT fkCountries_income
FOREIGN KEY (income_group_id)
REFERENCES income_group (id)
)ENGINE INNODB;

CREATE TABLE IF NOT EXISTS constraints_gov_power(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
country_id INT NOT NULL,
score_2013 DOUBLE NOT NULL,
score_2014 DOUBLE NOT NULL,
score_2015 DOUBLE NOT NULL,
CONSTRAINT fkConstraints_countries
FOREIGN KEY (country_id)
REFERENCES countries (id)
ON UPDATE NO ACTION
ON DELETE NO ACTION
)ENGINE InnoDB;

CREATE TABLE IF NOT EXISTS absence_corruption(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
country_id INT NOT NULL,
score_2013 DOUBLE NOT NULL,
score_2014 DOUBLE NOT NULL,
score_2015 DOUBLE NOT NULL,
CONSTRAINT fkCorruption_countries
FOREIGN KEY (country_id)
REFERENCES countries (id)
ON UPDATE NO ACTION
ON DELETE NO ACTION
)ENGINE InnoDB;

CREATE TABLE IF NOT EXISTS open_gov(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
country_id INT NOT NULL,
score_2013 DOUBLE NOT NULL,
score_2014 DOUBLE NOT NULL,
score_2015 DOUBLE NOT NULL,
CONSTRAINT fkOpenGov_countries
FOREIGN KEY (country_id)
REFERENCES countries (id)
ON UPDATE NO ACTION
ON DELETE NO ACTION
)ENGINE InnoDB;

CREATE TABLE IF NOT EXISTS fundamental_rights(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
country_id INT NOT NULL,
score_2013 DOUBLE NOT NULL,
score_2014 DOUBLE NOT NULL,
score_2015 DOUBLE NOT NULL,
CONSTRAINT fkRights_countries
FOREIGN KEY (country_id)
REFERENCES countries (id)
ON UPDATE NO ACTION
ON DELETE NO ACTION
)ENGINE InnoDB;

CREATE TABLE IF NOT EXISTS order_security(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
country_id INT NOT NULL,
score_2013 DOUBLE NOT NULL,
score_2014 DOUBLE NOT NULL,
score_2015 DOUBLE NOT NULL,
CONSTRAINT fkOrder_countries
FOREIGN KEY (country_id)
REFERENCES countries (id)
ON UPDATE NO ACTION
ON DELETE NO ACTION
)ENGINE InnoDB;

CREATE TABLE IF NOT EXISTS regulatory_enforcement(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
country_id INT NOT NULL,
score_2013 DOUBLE NOT NULL,
score_2014 DOUBLE NOT NULL,
score_2015 DOUBLE NOT NULL,
CONSTRAINT fkEnforcement_countries
FOREIGN KEY (country_id)
REFERENCES countries (id)
ON UPDATE NO ACTION
ON DELETE NO ACTION
)ENGINE InnoDB;

CREATE TABLE IF NOT EXISTS civil_justice(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
country_id INT NOT NULL,
score_2013 DOUBLE NOT NULL,
score_2014 DOUBLE NOT NULL,
score_2015 DOUBLE NOT NULL,
CONSTRAINT fkCivil_countries
FOREIGN KEY (country_id)
REFERENCES countries (id)
ON UPDATE NO ACTION
ON DELETE NO ACTION
)ENGINE InnoDB;

CREATE TABLE IF NOT EXISTS criminal_justice(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
country_id INT NOT NULL,
score_2013 DOUBLE NOT NULL,
score_2014 DOUBLE NOT NULL,
score_2015 DOUBLE NOT NULL,
CONSTRAINT fkCriminal_countries
FOREIGN KEY (country_id)
REFERENCES countries (id)
ON UPDATE NO ACTION
ON DELETE NO ACTION
)ENGINE InnoDB;

CREATE TABLE IF NOT EXISTS overall_score(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
country_id INT NOT NULL,
score_2013 DOUBLE NOT NULL,
score_2014 DOUBLE NOT NULL,
score_2015 DOUBLE NOT NULL,
CONSTRAINT fkScore_countries
FOREIGN KEY (country_id)
REFERENCES countries (id)
ON UPDATE NO ACTION
ON DELETE NO ACTION
)ENGINE InnoDB;

INSERT INTO income_group (id, income_group_code, income_group_name) VALUES (1, "L", "Low income");
INSERT INTO income_group (id, income_group_code, income_group_name) VALUES (2, "LM", "Lower middle income");
INSERT INTO income_group (id, income_group_code, income_group_name) VALUES (3, "UP", "Upper middle income");
INSERT INTO income_group (id, income_group_code, income_group_name) VALUES (4, "H", "Hight income");

INSERT INTO countries (id, country_code, country_name, income_group_id) VALUES
(1, "ARG", "Argentina", 3), 
(2, "BOL", "Bolivia", 2),
(3, "BRA", "Brasil", 3), 
(4, "CAN", "Canada", 4), 
(5, "CHL", "Chile", 3), 
(6,"DOM", "Republica Dominicana", 3), 
(7, "ECU", "Ecuador", 3), 
(8, "SLV", "El Salvador", 2), 
(9, "GTM", "Guatemala", 2), 
(10, "JAM", "Jamaica", 2), 
(11, "MEX", "Mexico", 3), 
(12, "NIC", "Nicaragua", 2),
(13, "PAN", "Panama", 3), 
(14, "PER", "Peru", 3), 
(15, "USA", "Estados Unidos", 4), 
(16, "URY", "Urugay", 3),
(17, "VEN", "Venezuela", 3);

INSERT INTO constraints_gov_power (country_id, score_2013, score_2014,score_2015) VALUES
(1, 0.46, 0.47, 0.49),
(2, 0.38, 0.38, 0.38),
(3, 0.62, 0.63, 0.61),
(4, 0.78, 0.80, 0.78),
(5, 0.74, 0.76, 0.68),
(6, 0.53, 0.48, 0.48),
(7, 0.41, 0.40, 0.47),
(8, 0.50, 0.49, 0.52),
(9, 0.52, 0.52, 0.51),
(10, 0.60, 0.62, 0.61),
(11, 0.55, 0.55, 0.51),
(12, 0.31, 0.31, 0.35),
(13, 0.45, 0.45, 0.53),
(14, 0.64, 0.60, 0.60),
(15, 0.77, 0.71, 0.76),
(16, 0.70, 0.75, 0.76),
(17, 0.25, 0.17, 0.19);

INSERT INTO absence_corruption (country_id, score_2013, score_2014,score_2015) VALUES
(1, 0.47, 0.49, 0.49),
(2, 0.24, 0.32, 0.34),
(3, 0.52, 0.50, 0.46),
(4, 0.81, 0.81, 0.81),
(5, 0.74, 0.73, 0.72),
(6, 0.36, 0.37, 0.36),
(7, 0.47, 0.47, 0.45),
(8, 0.45, 0.46, 0.43),
(9, 0.29, 0.37, 0.33),
(10, 0.51, 0.48, 0.53),
(11, 0.37, 0.37, 0.33),
(12, 0.40, 0.38, 0.37),
(13, 0.41, 0.44, 0.49),
(14, 0.37, 0.36, 0.34),
(15, 0.78, 0.75, 0.75),
(16, 0.78, 0.78, 0.78),
(17, 0.32, 0.30, 0.27);

INSERT INTO open_gov (country_id, score_2013, score_2014,score_2015) VALUES
(1, 0.60, 0.45, 0.56),
(2, 0.41, 0.38, 0.45),
(3, 0.54, 0.50, 0.56),
(4, 0.84, 0.82, 0.75),
(5, 0.68, 0.65, 0.68),
(6, 0.52, 0.48, 0.52),
(7, 0.38, 0.40, 0.51),
(8, 0.37, 0.37, 0.51),
(9, 0.46, 0.45, 0.48),
(10, 0.41, 0.44, 0.51),
(11, 0.53, 0.52, 0.56),
(12, 0.48, 0.45, 0.44),
(13, 0.60, 0.52, 0.55),
(14, 0.43, 0.44, 0.55),
(15, 0.77, 0.70, 0.73),
(16, 0.62, 0.65, 0.65),
(17, 0.36, 0.30, 0.38);

INSERT INTO fundamental_rights (country_id, score_2013, score_2014,score_2015) VALUES
(1, 0.63, 0.67, 0.66),
(2, 0.49, 0.48, 0.53),
(3, 0.69, 0.66, 0.61),
(4, 0.78, 0.77, 0.79),
(5, 0.73, 0.74, 0.74),
(6, 0.67, 0.60, 0.61),
(7, 0.56, 0.54, 0.53),
(8, 0.58, 0.62, 0.62),
(9, 0.59, 0.56, 0.56),
(10, 0.59, 0.61, 0.66),
(11, 0.56, 0.55, 0.56),
(12, 0.54, 0.51, 0.46),
(13, 0.63, 0.60, 0.62),
(14, 0.70, 0.66, 0.60),
(15, 0.73, 0.71, 0.73),
(16, 0.75, 0.76, 0.79),
(17, 0.48, 0.42, 0.39);

INSERT INTO order_security (country_id, score_2013, score_2014, score_2015) VALUES
(1, 0.48, 0.61, 0.61),
(2, 0.67, 0.61, 0.59),
(3, 0.64, 0.66, 0.66),
(4, 0.88, 0.86, 0.90),
(5, 0.70, 0.71, 0.70),
(6, 0.60, 0.59, 0.59),
(7, 0.56, 0.57, 0.62),
(8, 0.58, 0.66, 0.68),
(9, 0.59, 0.54, 0.56),
(10, 0.60, 0.65, 0.69),
(11, 0.50, 0.47, 0.52),
(12, 0.64, 0.66, 0.68),
(13, 0.68, 0.71, 0.70),
(14, 0.62, 0.63, 0.63),
(15, 0.83, 0.85, 0.82),
(16, 0.70, 0.69, 0.72),
(17, 0.51, 0.53, 0.54);

INSERT INTO regulatory_enforcement (country_id, score_2013, score_2014, score_2015) VALUES
(1, 0.43, 0.43, 0.43),
(2, 0.37, 0.38, 0.40),
(3, 0.56, 0.53, 0.51),
(4, 0.79, 0.79, 0.77),
(5, 0.66, 0.68, 0.65),
(6, 0.45, 0.42, 0.42),
(7, 0.46, 0.48, 0.49),
(8, 0.52, 0.49, 0.48),
(9, 0.43, 0.39, 0.40),
(10, 0.55, 0.56, 0.53),
(11, 0.49, 0.50, 0.50),
(12, 0.45, 0.53, 0.41),
(13, 0.52, 0.48, 0.54),
(14, 0.48, 0.46, 0.50),
(15, 0.70, 0.67, 0.73),
(16, 0.71, 0.73, 0.73),
(17, 0.33, 0.28, 0.26);

INSERT INTO civil_justice (country_id, score_2013, score_2014,score_2015) VALUES
(1, 0.54, 0.54, 0.55),
(2, 0.38, 0.34, 0.37),
(3, 0.55, 0.51, 0.53),
(4, 0.72, 0.72, 0.70),
(5, 0.66, 0.61, 0.61),
(6, 0.51, 0.48, 0.51),
(7, 0.42, 0.41, 0.41),
(8, 0.49, 0.47, 0.51),
(9, 0.41, 0.36, 0.36),
(10, 0.51, 0.47, 0.52),
(11, 0.40, 0.39, 0.44),
(12, 0.42, 0.39, 0.36),
(13, 0.51, 0.37, 0.50),
(14, 0.43, 0.39, 0.43),
(15, 0.65, 0.61, 0.67),
(16, 0.71, 0.70, 0.71),
(17, 0.38, 0.33, 0.35);

INSERT INTO criminal_justice (country_id, score_2013, score_2014,score_2015) VALUES
(1, 0.43, 0.37, 0.39),
(2, 0.28, 0.23, 0.25),
(3, 0.49, 0.37, 0.37),
(4, 0.75, 0.72, 0.72),
(5, 0.60, 0.57, 0.56),
(6, 0.47, 0.37, 0.37),
(7, 0.44, 0.33, 0.35),
(8, 0.25, 0.31, 0.34),
(9, 0.37, 0.30, 0.30),
(10, 0.42, 0.42, 0.46),
(11, 0.35, 0.25, 0.31),
(12, 0.42, 0.35, 0.33),
(13, 0.38, 0.38, 0.32),
(14, 0.45, 0.37, 0.34),
(15, 0.65, 0.65, 0.64),
(16, 0.50, 0.47, 0.54),
(17, 0.24, 0.16, 0.16);

INSERT INTO overall_score (country_id, score_2013, score_2014,score_2015) VALUES
(1, 0.50, 0.50, 0.52),
(2, 0.40, 0.39, 0.41),
(3, 0.57, 0.54, 0.54),
(4, 0.79, 0.78, 0.78),
(5, 0.68, 0.68, 0.68),
(6, 0.51, 0.47, 0.48),
(7, 0.46, 0.45, 0.47),
(8, 0.46, 0.48, 0.47),
(9, 0.45, 0.44, 0.51),
(10, 0.52, 0.53, 0.44),
(11, 0.46, 0.45, 0.47),
(12, 0.45, 0.43, 0.43),
(13, 0.52, 0.50, 0.53),
(14, 0.51, 0.49, 0.50),
(15, 0.73, 0.71, 0.73),
(16, 0.68, 0.69, 0.71),
(17, 0.35, 0.31, 0.32);