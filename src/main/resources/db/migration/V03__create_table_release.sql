create table releases (
                          id BIGINT  PRIMARY KEY AUTO_INCREMENT,
                          description VARCHAR(50) NOT NULL ,
                          dueDate DATE NOT NULL,
                          paymentDate DATE NOT NULL,
                          value DECIMAL(10,2) NOT NULL,
                          observation VARCHAR(150),
                          type VARCHAR(20) NOT NULL,
                          category_id BIGINT NOT NULL,
                          person_id BIGINT NOT NULL,
                          FOREIGN KEY (category_id) REFERENCES category(id) ,
                          FOREIGN KEY (person_id) REFERENCES person(id)


)ENGINE=InnoDB DEFAULT CHARSET=utf8;

