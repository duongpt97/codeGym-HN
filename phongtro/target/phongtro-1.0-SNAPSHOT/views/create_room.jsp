<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
            integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <form class="form form-control" method="post" action="/room/create">
        <div class="col-12 text-center">
            <h1>Tạo thông tin thuê trọ</h1>
        </div>
        <div class="row col-12 align-items-center mb-3">
            <div class="col-3 mb-3">
                <label for="inp-product-name">Mã phòng trọ</label>
            </div>
            <div class="col-9 mb-3">
                <input id="inp-product-name" type="text" class="form-control" name="name"/>
                <div id="product-name-error" class="error"></div>
            </div>
            <div class="col-3 mb-3">
                <label for="customerName">Tên người thuê</label>
            </div>
            <div class="col-9 mb-3">
                <input id="customerName" type="text" class="form-control" name="customerName"/>
            </div>
            <div class="col-3 mb-3">
                <label for="inp-quantity">Số điện thoại</label>
            </div>
            <div class="col-9 mb-3">
                <input id="inp-quantity" type="number" oninput="limitLength(this)" class="form-control"
                       name="phoneNumber"/>
                <div id="quantity-error" class="error"></div>
            </div>
            <div class="col-3 mb-3">
                <label for="inp-start-date">Ngày bắt đầu thuê</label>
            </div>
            <div class="col-9 mb-3">
                <input type="date" id="inp-start-date" name="startDate" required>
                <div id="price-error" class="error"></div>
            </div>
            <div class="col-3 mb-3">
                <label for="categoryId">Hình thức thanh toán</label>
            </div>
            <div class="col-9 mb-3">
                <select class="form-control" id="categoryId" name="categoryId">
                    <option value="0">--Chọn hình thức--</option>
                    <c:forEach var="category" items="${lstCategory}">
                        <option value="${category.id}">${category.tenHinhThuc}</option>
                    </c:forEach>
                </select>
                <div id="categoryId-error" class="error"></div>
            </div>
            <div class="col-3 mb-3">
                <label for="inp-description">Ghi chú</label>
            </div>
            <div class="col-9 mb-3">
                            <textarea id="inp-description" maxlength="500" class="form-control" name="description"
                                      style="width: 100%; height: 200px;"></textarea>
                <div id="description-error" class="error"></div>
            </div>
        </div>
        <div class="row col-12">
            <div class="col-3"></div>
            <div class="col-3  d-grid gap-2">
                <a class="btn btn-secondary" href="${pageContext.request.contextPath}/room/search">Hủy</a>
            </div>
            <div class="col-6  d-grid gap-2">
                <input type="submit" class="btn btn-primary" value="Lưu"/>
            </div>
        </div>
    </form>
</div>
</body>
</html>
