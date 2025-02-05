
DROP TABLE IF EXISTS `order`;

CREATE TABLE `Order` (
    orderId INT AUTO_INCREMENT PRIMARY KEY,
    userId INT ,
    restaurantId INT ,
    orderDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status ENUM('pending', 'out_of_delivery', 'delivered', 'cancelled', 'preparing') NOT NULL DEFAULT 'pending',
    paymentMode ENUM('cash', 'upi', 'card') NOT NULL DEFAULT 'cash',
    totalAmount DOUBLE DEFAULT NULL,
    address VARCHAR(200) DEFAULT NULL,
    phone VARCHAR(15) DEFAULT NULL,
    FOREIGN KEY (userId) REFERENCES User(userId),
    FOREIGN KEY (restaurantId) REFERENCES Restaurant(restaurantId)
);
