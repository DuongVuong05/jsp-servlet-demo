# Ứng dụng Java JSP / Servlet Đầu Tiên (Jakarta EE & Tomcat 10.1+)

Dự án mẫu Java Web cơ bản dành cho người mới bắt đầu, sử dụng **Maven**, **Java 17**, **Jakarta Servlet API 6.0** và tương thích hoàn toàn với **Apache Tomcat 10.1 trở lên**.

---

## 1. Thông Tin Dự Án

- **Tên dự án:** `jsp-servlet-demo`
- **Đường dẫn thư mục:** `C:\Users\ADMIN\Documents\FinalExam\jsp-servlet-demo`
- **Group ID:** `com.codegym`
- **Artifact ID:** `jsp-servlet-demo`
- **Phiên bản:** `1.0-SNAPSHOT`
- **Đóng gói (Packaging):** `war`
- **Java Version:** 17
- **Servlet Specification:** Jakarta Servlet 6.0 (`jakarta.servlet-api:6.0.0`)
- **Web Server:** Apache Tomcat 10.1+ (hoặc Tomcat 11.x)
- **Định dạng file xuất ra:** `target/jsp-servlet-demo.war`

---

## 2. Cấu Trúc Dự Án

```text
jsp-servlet-demo/
├── .gitignore                                   # Danh sách bỏ qua target/ và file tạm/IDE
├── pom.xml                                      # File cấu hình Maven (Dependencies, Plugins)
├── README.md                                    # Tài liệu hướng dẫn sử dụng chi tiết
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── codegym/
        │           └── HelloServlet.java       # Servlet xử lý GET /hello (@WebServlet)
        └── webapp/
            ├── index.jsp                        # Trang chủ JSP chào mừng & hiển thị giờ server
            └── WEB-INF/
                └── web.xml                      # Cấu hình Web Descriptor chuẩn Jakarta 6.0
```

---

## 3. Điểm Mới Quan Trọng: Jakarta EE vs Java EE (Tomcat 10.1+)

Kể từ phiên bản **Apache Tomcat 10.0+** (đặc biệt là **Tomcat 10.1**):
1. Không còn sử dụng namespace cũ `javax.servlet.*`.
2. Chuyển hoàn toàn sang namespace mới **`jakarta.servlet.*`** (chuẩn Jakarta EE 10 / Servlet 6.0).
3. Do đó:
   - Trong code Java: `import jakarta.servlet.http.HttpServlet;`
   - Trong `pom.xml`: Phụ thuộc vào `jakarta.servlet:jakarta.servlet-api:6.0.0` với scope `provided`.
   - Trong `web.xml`: Khai báo namespace `https://jakarta.ee/xml/ns/jakartaee` với `version="6.0"`.
4. **Tránh khai báo trùng lặp:** Vì `HelloServlet.java` đã sử dụng annotation `@WebServlet(name = "HelloServlet", urlPatterns = {"/hello"})` nên trong `web.xml` không cần (và không nên) khai báo lại thẻ `<servlet-mapping>`, giúp cấu hình gọn gàng và tránh xung đột.

---

## 4. Hướng Dẫn Biên Dịch & Đóng Gói (Build WAR)

Mở terminal (PowerShell hoặc CMD) tại thư mục dự án:
```powershell
cd C:\Users\ADMIN\Documents\FinalExam\jsp-servlet-demo
```

Chạy lệnh Maven để dọn dẹp và đóng gói:
```powershell
mvn clean package
```

Khi build thành công, file WAR sẽ được tạo tại:
```text
C:\Users\ADMIN\Documents\FinalExam\jsp-servlet-demo\target\jsp-servlet-demo.war
```

---

## 5. Hướng Dẫn Triển Khai (Deploy) Lên Apache Tomcat 10.1+

### Cách 1: Triển khai trực tiếp (Copy file WAR) - Khuyến nghị cho người mới

1. Tải Apache Tomcat phiên bản 10.1.x từ trang chủ: [https://tomcat.apache.org/download-100.cgi](https://tomcat.apache.org/download-100.cgi) (chọn bản *64-bit Windows zip*).
2. Giải nén vào thư mục, ví dụ: `C:\apache-tomcat-10.1.x`.
3. Copy file `jsp-servlet-demo.war` từ thư mục `target/` vào thư mục `webapps/` của Tomcat:
   ```powershell
   Copy-Item "C:\Users\ADMIN\Documents\FinalExam\jsp-servlet-demo\target\jsp-servlet-demo.war" "C:\apache-tomcat-10.1.x\webapps\"
   ```
4. Khởi động Tomcat bằng cách chạy file:
   - `C:\apache-tomcat-10.1.x\bin\startup.bat`
5. Tomcat sẽ tự động giải nén file `.war` thành thư mục `webapps/jsp-servlet-demo/` và triển khai ứng dụng.

### Cách 2: Chạy trực tiếp qua IntelliJ IDEA Ultimate / Eclipse

- **IntelliJ IDEA Ultimate:**
  1. Vào menu **Run** -> **Edit Configurations...**
  2. Nhấn dấu **+** -> Chọn **Tomcat Server** -> **Local**.
  3. Tại mục **Application server**, chọn thư mục Tomcat 10.1 trên máy bạn.
  4. Sang tab **Deployment** -> Nhấn **+** -> Chọn **Artifact...** -> Chọn `jsp-servlet-demo:war`.
  5. Đặt Application context là `/jsp-servlet-demo`.
  6. Nhấn **Apply** và **Run** để khởi chạy.

- **VS Code:** Có thể sử dụng extension **Tomcat for Java** hoặc **Community Server Connectors**.

---

## 6. Danh Sách URL Kiểm Thử (URLs Testing)

Sau khi Tomcat đã khởi động thành công trên cổng mặc định `8080`:

| Mục tiêu | Đường dẫn URL | Mô tả |
| :--- | :--- | :--- |
| **Trang chủ JSP** | `http://localhost:8080/jsp-servlet-demo/` | Hiển thị giao diện chào mừng, giờ hiện tại của hệ thống và thông tin công nghệ. |
| **Servlet mặc định** | `http://localhost:8080/jsp-servlet-demo/hello` | HelloServlet nhận request GET và trả về HTML chào mừng học viên CodeGym. |
| **Servlet có tham số** | `http://localhost:8080/jsp-servlet-demo/hello?name=NguyenVanA` | HelloServlet nhận tham số `name` và hiển thị lời chào cá nhân hóa. |

---

## 7. Các Lỗi Thường Gặp & Cách Khắc Phục

1. **Lỗi `404 Not Found`:**
   - Kiểm tra xem tên file war có đúng là `jsp-servlet-demo.war` không (context path sẽ tương ứng với tên file `.war`).
   - Kiểm tra log trong `logs/catalina.out` hoặc console của Tomcat xem ứng dụng có gặp lỗi khởi động không.
2. **Lỗi `ClassNotFoundException: javax.servlet.http.HttpServlet`:**
   - Xảy ra khi bạn mang code cũ chạy trên Tomcat 10+ hoặc ngược lại. Đảm bảo toàn bộ import là `jakarta.servlet.*`.
3. **Lỗi cổng `8080` bị chiếm dụng:**
   - Mở file `conf/server.xml` trong thư mục Tomcat, tìm `<Connector port="8080"` và đổi thành `8088` hoặc cổng khác.
4. **Lỗi hiển thị tiếng Việt bị lỗi font (ký tự lạ `???` hoặc `Ã¡`):**
   - Đã được xử lý triệt để trong dự án bằng cách thiết lập:
     - `pageEncoding="UTF-8"` và `contentType="text/html; charset=UTF-8"` trên JSP.
     - `request.setCharacterEncoding("UTF-8")` và `response.setCharacterEncoding("UTF-8")` trong Servlet.
