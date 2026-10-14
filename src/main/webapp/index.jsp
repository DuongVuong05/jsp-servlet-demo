<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSP Servlet Demo - Trang Chủ</title>
    <style>
        :root {
            --primary-color: #2563eb;
            --primary-hover: #1d4ed8;
            --secondary-color: #0f172a;
            --bg-color: #f8fafc;
            --card-bg: #ffffff;
            --text-main: #1e293b;
            --text-muted: #64748b;
            --border-color: #e2e8f0;
            --accent-green: #10b981;
            --accent-amber: #f59e0b;
        }

        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }

        body {
            font-family: 'Segoe UI', -apple-system, BlinkMacSystemFont, Roboto, Helvetica, Arial, sans-serif;
            background-color: var(--bg-color);
            color: var(--text-main);
            min-height: 100vh;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            padding: 24px 16px;
        }

        .container {
            max-width: 680px;
            width: 100%;
            background: var(--card-bg);
            border-radius: 16px;
            box-shadow: 0 10px 25px -5px rgba(0, 0, 0, 0.08), 0 8px 10px -6px rgba(0, 0, 0, 0.04);
            border: 1px solid var(--border-color);
            padding: 40px;
        }

        .header-tag {
            display: inline-flex;
            align-items: center;
            gap: 6px;
            background: #eff6ff;
            color: var(--primary-color);
            padding: 6px 14px;
            border-radius: 9999px;
            font-size: 0.85rem;
            font-weight: 600;
            margin-bottom: 16px;
        }

        h1 {
            font-size: 2rem;
            color: var(--secondary-color);
            font-weight: 700;
            margin-bottom: 12px;
            letter-spacing: -0.02em;
        }

        p.description {
            font-size: 1.05rem;
            color: var(--text-muted);
            line-height: 1.6;
            margin-bottom: 28px;
        }

        .server-time-card {
            background-color: #f1f5f9;
            border-left: 4px solid var(--accent-green);
            padding: 18px 20px;
            border-radius: 0 10px 10px 0;
            margin-bottom: 28px;
        }

        .server-time-label {
            font-size: 0.85rem;
            text-transform: uppercase;
            letter-spacing: 0.05em;
            color: var(--text-muted);
            font-weight: 600;
            margin-bottom: 4px;
        }

        .server-time-value {
            font-size: 1.25rem;
            font-weight: 700;
            color: var(--secondary-color);
            font-family: 'Consolas', 'Courier New', monospace;
        }

        .tech-specs {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(130px, 1fr));
            gap: 12px;
            margin-bottom: 32px;
        }

        .spec-item {
            background: #fafafa;
            border: 1px solid var(--border-color);
            padding: 12px;
            border-radius: 8px;
            text-align: center;
        }

        .spec-title {
            font-size: 0.75rem;
            color: var(--text-muted);
            text-transform: uppercase;
            font-weight: 600;
        }

        .spec-value {
            font-size: 0.95rem;
            font-weight: 700;
            color: var(--secondary-color);
            margin-top: 4px;
        }

        .btn-group {
            display: flex;
            flex-direction: column;
            gap: 12px;
        }

        .btn {
            display: inline-flex;
            justify-content: center;
            align-items: center;
            gap: 8px;
            text-decoration: none;
            padding: 14px 24px;
            border-radius: 10px;
            font-size: 1rem;
            font-weight: 600;
            transition: all 0.2s ease-in-out;
            cursor: pointer;
        }

        .btn-primary {
            background-color: var(--primary-color);
            color: #ffffff;
            box-shadow: 0 4px 6px -1px rgba(37, 99, 235, 0.2);
        }

        .btn-primary:hover {
            background-color: var(--primary-hover);
            transform: translateY(-1px);
            box-shadow: 0 6px 10px -1px rgba(37, 99, 235, 0.3);
        }

        .footer {
            margin-top: 24px;
            text-align: center;
            font-size: 0.85rem;
            color: var(--text-muted);
        }
    </style>
</head>
<body>

    <div class="container">
        <div class="header-tag">
            <span>✨ CodeGym Java Web Application</span>
        </div>

        <h1>Chào mừng bạn đến với JSP / Servlet Demo!</h1>

        <p class="description">
            Đây là ứng dụng web Java đầu tiên được xây dựng với kiến trúc chuẩn <strong>Jakarta EE 10</strong>, 
            sử dụng công nghệ quản lý phụ thuộc <strong>Maven</strong> và tương thích hoàn toàn với máy chủ <strong>Apache Tomcat 10.1+</strong>.
        </p>

        <!-- Thời gian hiện tại của máy chủ được xử lý bằng mã Java trên JSP -->
        <%
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss - 'Ngày' dd/MM/yyyy");
            String serverTime = now.format(formatter);
        %>
        <div class="server-time-card">
            <div class="server-time-label">🕒 Thời gian máy chủ hiện tại (Server Time):</div>
            <div class="server-time-value"><%= serverTime %></div>
        </div>

        <!-- Thông số công nghệ dự án -->
        <div class="tech-specs">
            <div class="spec-item">
                <div class="spec-title">Nền tảng</div>
                <div class="spec-value">Java 17</div>
            </div>
            <div class="spec-item">
                <div class="spec-title">Servlet API</div>
                <div class="spec-value">Jakarta 6.0</div>
            </div>
            <div class="spec-item">
                <div class="spec-title">Máy chủ Web</div>
                <div class="spec-value">Tomcat 10.1+</div>
            </div>
            <div class="spec-item">
                <div class="spec-title">Build Tool</div>
                <div class="spec-value">Maven 3.9+</div>
            </div>
        </div>

        <!-- Các liên kết điều hướng -->
        <div class="btn-group">
            <a href="${pageContext.request.contextPath}/hello" class="btn btn-primary">
                👉 Truy cập HelloServlet (Đường dẫn: /hello)
            </a>
        </div>

        <div class="footer">
            Thực hiện bởi CodeGym &bull; Học lập trình Java Web hiện đại
        </div>
    </div>

</body>
</html>
