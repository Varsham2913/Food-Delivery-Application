#  🍔 Food-Delivery-Application[Tap Foods]
**Tap Foods** is a full-stack web application designed to streamline the food delivery process. The platform allows users to explore restaurants, order food online, and manage their orders.

##  ✨ Features 

- ✔️ **User Authentication**: Sign-up, sign-in functionality.
- ✔️ **Restaurant Page**: Displays a list of different restaurants.
- ✔️ **Menu Page**: View food items of a selected restaurant.
- ✔️ **Add to Cart**: Users can add items to their cart.
- ✔️ **Cart**: Provides Functionality to user such as add item , delete item , increase or decrease quantity.
- ✔️ **Checkout**: Proceed to checkout.
- ✔️ **Order Confirmation**: Order Confirmation.

##  💻 Technologies Used

- **Frontend**: JSP, HTML, CSS
- **Backend**: Java (Servlets, JDBC)
- **Database**: MySQL
- **Server**: Apache Tomcat

## 📝 Project Structure 
```
FoodDeliveryApplication/
├── src/main/
│        ├──java/
│           ├── com.tap.dao/                  # DAO interfaces      
│           ├── com.tap.daoimplementation/    # DAO implementation classes          
│           ├── com.tap.model/                # Model classes (User, Order, Restaurant, etc.)
│           ├── com.tap.servlet/              # Servlets handling requests
│           ├── com.tap.utility/              # Database connection utility
│          ├── database/                        # All tables are present
│        ├── webapp/
├           ├── images/                       # Images, animation video, sound files
│           ├── jspFiles/                     # All JSP pages
│                   
├──README.md  
  
```

## ⚙️ Installation and Setup 

  ### Prerequisites:
- **Java Development Kit (JDK)** (Version 11+)
- **Apache Tomcat** (Version 9+)
- **MySQL Server**
- **Maven** (For dependency management)

  ### Steps:
  
   **Step 1: Setup MySQL Database:**
   - Create a new database named `tap_foods`.
   - Run the SQL script provided in the `db` folder to set up the tables.
 
  **Step 2: Import the Project in Eclipse:**
   - Open **Eclipse IDE**.
   - Click **File → Import → Existing Projects into Workspace**.
   - Select the **FoodDeliveryApplication** folder.
   - Click **Finish**.
 
  **Step 3: Configure Tomcat Server:**
   - In Eclipse, go to **Window → Show View → Servers**.
   - Right-click and **Add New Server** → Select **Apache Tomcat**.
   - Set the **Tomcat installation directory**.
   - Click **Finish**.
 
    **Step 4: Run the Application:**
     - Right-click the project → **Run As → Run on Server**.
     - Choose **Apache Tomcat** and click **Finish**.
     - Open your browser and visit

   **Access the Application**:
    - Open your browser and go to `http://localhost:8080`.


##  Additional Information
  - Make sure MySQL is **running** before launching the project.
  - Update `DBConnection.java` in `com.tap.utility` with your **MySQL credentials**:
    
```
    String url = "jdbc:mysql://localhost:3306/tap_foods";
    String user = "root";
    String password = "your_password";
   ```
- If you face any errors, check the **Tomcat logs** in Eclipse.

## Contact
  For any queries, reach out at [varsham2k20@gmail.com]

  
