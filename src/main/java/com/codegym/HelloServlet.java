package com.codegym;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * HelloServlet - Servlet xử lý yêu cầu GET tại đường dẫn /hello.
 * 
 * Lưu ý quan trọng với Tomcat 10.1+:
 * - Chúng ta kế thừa từ jakarta.servlet.http.HttpServlet (thay vì javax.servlet.http.HttpServlet cũ).
 * - Có thể dùng annotation @WebServlet kết hợp hoặc cấu hình qua web.xml.
 */
@WebServlet(name = "HelloServlet", urlPatterns = {"/hello"})
public class HelloServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Thiết lập bảng mã UTF-8 để hỗ trợ hiển thị tiếng Việt có dấu chuẩn xác
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        // 2. Đọc tham số tùy chọn từ Query String (ví dụ: /hello?name=CodeGym)
        String name = request.getParameter("name");
        if (name == null || name.trim().isEmpty()) {
            name = "bạn học viên CodeGym";
        } else {
            name = name.trim();
        }

        // 3. Lấy thời gian hiện tại trên máy chủ
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss - 'Ngày' dd/MM/yyyy");
        String formattedDateTime = now.format(formatter);

        // 4. Lấy contextPath để tạo liên kết động linh hoạt
        String contextPath = request.getContextPath();

        // 5. Kết xuất nội dung HTML trả về trình duyệt
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"vi\">");
            out.println("<head>");
            out.println("    <meta charset=\"UTF-8\">");
            out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("    <title>Xin chào từ HelloServlet</title>");
            out.println("    <style>");
            out.println("        :root {");
            out.println("            --primary-color: #2563eb;");
            out.println("            --primary-hover: #1d4ed8;");
            out.println("            --bg-color: #f1f5f9;");
            out.println("            --card-bg: #ffffff;");
            out.println("            --text-main: #0f172a;");
            out.println("            --text-muted: #64748b;");
            out.println("            --border-color: #e2e8f0;");
            out.println("            --accent-green: #10b981;");
            out.println("        }");
            out.println("        * {");
            out.println("            box-sizing: border-box;");
            out.println("            margin: 0;");
            out.println("            padding: 0;");
            out.println("        }");
            out.println("        body {");
            out.println("            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;");
            out.println("            background-color: var(--bg-color);");
            out.println("            color: var(--text-main);");
            out.println("            display: flex;");
            out.println("            justify-content: center;");
            out.println("            align-items: center;");
            out.println("            min-height: 100vh;");
            out.println("            padding: 20px;");
            out.println("        }");
            out.println("        .card {");
            out.println("            background: var(--card-bg);");
            out.println("            padding: 36px 40px;");
            out.println("            border-radius: 16px;");
            out.println("            box-shadow: 0 10px 25px -5px rgba(0, 0, 0, 0.08), 0 8px 10px -6px rgba(0, 0, 0, 0.04);");
            out.println("            max-width: 640px;");
            out.println("            width: 100%;");
            out.println("            border: 1px solid var(--border-color);");
            out.println("        }");
            out.println("        .badge {");
            out.println("            display: inline-block;");
            out.println("            background-color: #e0f2fe;");
            out.println("            color: #0369a1;");
            out.println("            padding: 6px 14px;");
            out.println("            font-size: 0.85rem;");
            out.println("            font-weight: 600;");
            out.println("            border-radius: 9999px;");
            out.println("            margin-bottom: 16px;");
            out.println("        }");
            out.println("        h1 {");
            out.println("            color: var(--text-main);");
            out.println("            font-size: 1.85rem;");
            out.println("            line-height: 1.3;");
            out.println("            margin-bottom: 12px;");
            out.println("        }");
            out.println("        p.lead {");
            out.println("            color: var(--text-muted);");
            out.println("            font-size: 1.05rem;");
            out.println("            line-height: 1.6;");
            out.println("            margin-bottom: 24px;");
            out.println("        }");
            out.println("        .info-box {");
            out.println("            background-color: #f8fafc;");
            out.println("            border-left: 4px solid var(--accent-green);");
            out.println("            padding: 16px 20px;");
            out.println("            border-radius: 0 8px 8px 0;");
            out.println("            margin-bottom: 24px;");
            out.println("            font-size: 0.95rem;");
            out.println("            color: #334155;");
            out.println("        }");
            out.println("        .info-box ul {");
            out.println("            list-style: none;");
            out.println("            margin-top: 8px;");
            out.println("        }");
            out.println("        .info-box li {");
            out.println("            margin-bottom: 6px;");
            out.println("        }");
            out.println("        .info-box strong {");
            out.println("            color: var(--text-main);");
            out.println("        }");
            out.println("        .form-section {");
            out.println("            margin-bottom: 28px;");
            out.println("            padding: 16px;");
            out.println("            background-color: #f8fafc;");
            out.println("            border-radius: 8px;");
            out.println("            border: 1px dashed var(--border-color);");
            out.println("        }");
            out.println("        .form-section label {");
            out.println("            display: block;");
            out.println("            font-size: 0.9rem;");
            out.println("            font-weight: 600;");
            out.println("            margin-bottom: 8px;");
            out.println("            color: var(--text-main);");
            out.println("        }");
            out.println("        .form-group {");
            out.println("            display: flex;");
            out.println("            gap: 10px;");
            out.println("        }");
            out.println("        input[type=\"text\"] {");
            out.println("            flex: 1;");
            out.println("            padding: 10px 14px;");
            out.println("            border: 1px solid var(--border-color);");
            out.println("            border-radius: 8px;");
            out.println("            font-size: 0.95rem;");
            out.println("            outline: none;");
            out.println("            transition: border-color 0.2s;");
            out.println("        }");
            out.println("        input[type=\"text\"]:focus {");
            out.println("            border-color: var(--primary-color);");
            out.println("        }");
            out.println("        button.btn-submit {");
            out.println("            padding: 10px 18px;");
            out.println("            background-color: var(--primary-color);");
            out.println("            color: #ffffff;");
            out.println("            border: none;");
            out.println("            border-radius: 8px;");
            out.println("            font-weight: 600;");
            out.println("            cursor: pointer;");
            out.println("            transition: background-color 0.2s;");
            out.println("        }");
            out.println("        button.btn-submit:hover {");
            out.println("            background-color: var(--primary-hover);");
            out.println("        }");
            out.println("        .actions {");
            out.println("            display: flex;");
            out.println("            justify-content: space-between;");
            out.println("            align-items: center;");
            out.println("            padding-top: 16px;");
            out.println("            border-top: 1px solid var(--border-color);");
            out.println("        }");
            out.println("        a.btn-back {");
            out.println("            display: inline-flex;");
            out.println("            align-items: center;");
            out.println("            gap: 8px;");
            out.println("            color: var(--primary-color);");
            out.println("            text-decoration: none;");
            out.println("            font-weight: 600;");
            out.println("            font-size: 0.95rem;");
            out.println("            padding: 8px 14px;");
            out.println("            border-radius: 8px;");
            out.println("            transition: background-color 0.2s, color 0.2s;");
            out.println("        }");
            out.println("        a.btn-back:hover {");
            out.println("            background-color: #eff6ff;");
            out.println("            color: var(--primary-hover);");
            out.println("        }");
            out.println("    </style>");
            out.println("</head>");
            out.println("<body>");
            out.println("    <div class=\"card\">");
            out.println("        <span class=\"badge\">🚀 Jakarta Servlet 6.0 | Apache Tomcat 10.1+</span>");
            out.println("        <h1>Chào mừng " + escapeHtml(name) + "!</h1>");
            out.println("        <p class=\"lead\">Yêu cầu GET của bạn đã được <strong>HelloServlet</strong> tiếp nhận và xử lý thành công với bộ mã tiếng Việt UTF-8.</p>");
            out.println("        ");
            out.println("        <div class=\"info-box\">");
            out.println("            <strong>📌 Thông tin chi tiết từ Servlet:</strong>");
            out.println("            <ul>");
            out.println("                <li>🕒 <strong>Thời gian máy chủ:</strong> " + formattedDateTime + "</li>");
            out.println("                <li>🌐 <strong>Đường dẫn (URL Pattern):</strong> <code>/hello</code></li>");
            out.println("                <li>📦 <strong>Servlet Class:</strong> <code>com.codegym.HelloServlet</code></li>");
            out.println("                <li>⚙️ <strong>Giao thức:</strong> " + request.getProtocol() + " (" + request.getMethod() + ")</li>");
            out.println("            </ul>");
            out.println("        </div>");
            out.println("        ");
            out.println("        <div class=\"form-section\">");
            out.println("            <form action=\"" + contextPath + "/hello\" method=\"GET\">");
            out.println("                <label for=\"nameInput\">Thử gửi tham số tên của bạn:</label>");
            out.println("                <div class=\"form-group\">");
            out.println("                    <input type=\"text\" id=\"nameInput\" name=\"name\" placeholder=\"Nhập tên của bạn...\" required>");
            out.println("                    <button type=\"submit\" class=\"btn-submit\">Gửi lời chào</button>");
            out.println("                </div>");
            out.println("            </form>");
            out.println("        </div>");
            out.println("        ");
            out.println("        <div class=\"actions\">");
            out.println("            <a href=\"" + contextPath + "/\" class=\"btn-back\">← Quay lại Trang Chủ (index.jsp)</a>");
            out.println("            <span style=\"font-size: 0.85rem; color: #94a3b8;\">CodeGym Java Web</span>");
            out.println("        </div>");
            out.println("    </div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Phương thức tiện ích để escape mã HTML cơ bản nhằm tránh lỗi hiển thị ký tự đặc biệt
     */
    private String escapeHtml(String input) {
        if (input == null) return "";
        return input.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&#x27;");
    }
}
