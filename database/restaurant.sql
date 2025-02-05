
DROP TABLE IF EXISTS `restaurant`;

CREATE TABLE restaurant (
    restaurantId INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(35) DEFAULT NULL,
    address VARCHAR(35) DEFAULT NULL,
    phone VARCHAR(15) DEFAULT NULL,
    rating DOUBLE DEFAULT NULL,
    cusineType VARCHAR(25) DEFAULT NULL,
    isActive TINYINT(1) DEFAULT 0,
    deliveryTime INT DEFAULT NULL,
    adminUserId INT DEFAULT NULL,
    imagePath VARCHAR(100) DEFAULT NULL,
    FOREIGN KEY (adminUserId) REFERENCES User(adminUserId) 
);
