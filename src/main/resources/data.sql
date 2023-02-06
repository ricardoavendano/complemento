 /*-------------------------------------------------------------------------------------------*/
DROP TABLE IF EXISTS brand;
CREATE TABLE brand (
  idbrand INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  PRIMARY KEY (idbrand));

INSERT INTO brand (name) VALUES
('Zara'),
('Other brand');

/*-------------------------------------------------------------------------------------------*/

DROP TABLE IF EXISTS prices;
CREATE TABLE prices (
  idprices INT NOT NULL AUTO_INCREMENT,
  idbrandPK INT NOT NULL,
  brandid INT NOT NULL,
  startdate TIMESTAMP NOT NULL,
  enddate TIMESTAMP NOT NULL,
  pricelist INT NOT NULL,
  productid INT NOT NULL,
  priority INT NOT NULL,
  price REAL NOT NULL,
  curr VARCHAR(100) NOT NULL,
  PRIMARY KEY (idprices));

ALTER TABLE prices 
ADD CONSTRAINT idbrandPK
  FOREIGN KEY (idbrandPK)
  REFERENCES brand (idbrand);

INSERT INTO prices (idbrandPK, brandid, startdate, enddate, pricelist, productid, priority, price, curr) VALUES 
(1, 1, PARSEDATETIME('2020-06-14-00.00.00', 'yyyy-MM-dd-HH.mm.ss'), PARSEDATETIME('2020-12-31-23.59.59', 'yyyy-MM-dd-HH.mm.ss'), 1, 35455, 0, 35.50, 'EUR'),
(1, 1, PARSEDATETIME('2020-06-14-15.00.00', 'yyyy-MM-dd-HH.mm.ss'), PARSEDATETIME('2020-06-14-18.30.00', 'yyyy-MM-dd-HH.mm.ss'), 2, 35455, 1, 25.45, 'EUR'),
(1, 1, PARSEDATETIME('2020-06-15-00.00.00', 'yyyy-MM-dd-HH.mm.ss'), PARSEDATETIME('2020-06-15-11.00.00', 'yyyy-MM-dd-HH.mm.ss'), 3, 35455, 1, 30.50, 'EUR'),
(1, 1, PARSEDATETIME('2020-06-15-16.00.00', 'yyyy-MM-dd-HH.mm.ss'), PARSEDATETIME('2020-12-31-23.59.59', 'yyyy-MM-dd-HH.mm.ss'), 4, 35455, 1, 38.95, 'EUR');
/*-------------------------------------------------------------------------------------------*/