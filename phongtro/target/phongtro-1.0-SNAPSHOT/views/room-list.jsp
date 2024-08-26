<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container" style="height: 500px">
    <h2>Danh sách phòng trọ</h2>
    <div class="row mb-3">
        <div class="col-12">
            <form class="form row justify-content-center" method="get"
                  action="/room/search">
                <input type="text" class="form-control" name="size" value="10" hidden/>
                <input type="text" class="form-control" name="page" value="1" hidden/>
                <div class="col-7">
                    <input type="text" class="form-control" name="keyword"
                           value="${keyword}" placeholder="Tìm kiếm theo mã phòng, tên hoặc số điện thoại">
                </div>
                <div class="col-2">
                    <input type="submit" class="btn btn-success col-12" value="Tìm"/>
                </div>

            </form>
        </div>
        <div class="col-2">
        </div>
        <div class="col-12 mb-3">
            <a href="${pageContext.request.contextPath}/room/create"
               class="btn btn-primary">Thêm mới</a>
        </div>
        <div class="col-12">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>STT</th>
                    <th>Mã phòng trọ</th>
                    <th>Tên người thuê</th>
                    <th>Số điện thoại</th>
                    <th>Ngày bắt đầu</th>
                    <th>Hình thức thanh toán</th>
                    <th>Ghi chú</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="phongTro" items="${lstData}">
                    <tr>
                        <td>${phongTro.id}</td>
                        <td>${phongTro.maPhong}</td>
                        <td>${phongTro.tenNguoiThue}</td>
                        <td>${phongTro.soDienThoai}</td>
                        <td>${phongTro.ngayBatDau}</td>
                        <td>${phongTro.tenHinhThuc}</td>
                        <td>${phongTro.ghiChu}</td>
                        <td><a href="/room/delete?id=${phongTro.id}" class="btn btn-danger">Xóa</a></td>
                    </tr>

                </c:forEach>
                </tbody>
            </table>

        </div>
        <div class="text-center col-12">
            <nav aria-label="Page navigation example">
                <ul class="pagination" style="justify-content: center">
                    <c:if test="${!firstTab}">
                        <li class="page-item"><a class="page-link"
                                                 href="/room/search?page=${currentPage-1}&size=10&keyword=${keyword}">
                            Previous</a></li>
                    </c:if>

                    <c:forEach begin="${beginPage}" end="${endPage}" var="page">
                        <li class="page-item ${currentPage == page ? 'active' : ''}">
                            <a class="page-link"
                               href="/room/search?page=${page}&size=10&keyword=${keyword}">${page}</a>
                        </li>
                    </c:forEach>
                    <c:if test="${!lastTab}">
                        <li class="page-item">
                            <a class="page-link"
                               href="/room/search?page=${currentPage+1}&size=10&keyword=${keyword}">
                                Next</a></li>
                    </c:if>
                </ul>
            </nav>
        </div>
    </div>
</div>
</body>
</html>
