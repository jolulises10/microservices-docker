CREATE TABLE IF NOT EXISTS marketplace_db.supplier (
  id_supplier INT NOT NULL AUTO_INCREMENT,
  supplier_identifier VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_supplier))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS marketplace_db.product (
  id_product INT NOT NULL AUTO_INCREMENT,
  product_name VARCHAR(45) NOT NULL,
  product_description VARCHAR(250) NULL,
  PRIMARY KEY (id_product))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS marketplace_db.customer (
  id_customer INT NOT NULL AUTO_INCREMENT,
  customer_identifier VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_customer))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS marketplace_db.customer_product (
  id_customer_product INT NOT NULL AUTO_INCREMENT,
  id_product INT NOT NULL,
  id_customer INT NOT NULL,
  date DATETIME NOT NULL,
  quantity DECIMAL(5,2) NOT NULL,
  id_supplier INT NOT NULL,
  PRIMARY KEY (id_customer_product),
  INDEX id_supplier_fk_idx (id_supplier ASC) VISIBLE,
  INDEX id_product_fk_idx (id_product ASC) VISIBLE,
  INDEX id_customer_fk_idx (id_customer ASC) VISIBLE,
  CONSTRAINT id_supplier_fk
    FOREIGN KEY (id_supplier)
    REFERENCES marketplace_db.supplier (id_supplier)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT id_product_fk
    FOREIGN KEY (id_product)
    REFERENCES marketplace_db.product (id_product)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT id_customer_fk
    FOREIGN KEY (id_customer)
    REFERENCES marketplace_db.customer (id_customer)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB