
DROP TABLE IF EXISTS `oderItem`;


CREATE TABLE OrderItem (
    orderItemId INT AUTO_INCREMENT PRIMARY KEY,
    orderId INT,
    menuId INT,
    totalPrice INT ,
    quantity INT ,
    FOREIGN KEY (orderId) REFERENCES `Order`(orderId),
    FOREIGN KEY (menuId) REFERENCES Menu(menuId)
);
