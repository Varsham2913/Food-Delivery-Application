

DROP TABLE IF EXISTS `menu`;

CREATE TABLE Menu (
    menuId INT AUTO_INCREMENT PRIMARY KEY,
    restaurantId INT DEFAULT NULL,
    itemName VARCHAR(30) DEFAULT NULL,
    description VARCHAR(100) DEFAULT NULL,
    price INT DEFAULT NULL,
    ratings FLOAT DEFAULT NULL,
    isAvailable TINYINT(1) DEFAULT 0,
    imagePath VARCHAR(200) DEFAULT NULL,
    FOREIGN KEY (restaurantId) REFERENCES Restaurant(restaurantId) 
);
