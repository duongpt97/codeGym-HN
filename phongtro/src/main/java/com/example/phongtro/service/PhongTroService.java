package com.example.phongtro.service;


import com.example.phongtro.dto.PagingDto;
import com.example.phongtro.dto.PhongTroDto;
import com.example.phongtro.entity.HinhThucThanhToan;
import com.example.phongtro.entity.PhongTro;
import com.example.phongtro.model.HinhThucThanhToanModel;
import com.example.phongtro.model.PhongTroModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PhongTroService {
    private PhongTroModel phongTroModel;
    private HinhThucThanhToanModel hinhThucThanhToanModel;

    public PhongTroService() {
        this.phongTroModel = new PhongTroModel();
        this.hinhThucThanhToanModel = new HinhThucThanhToanModel();
    }

    public void createRoom(HttpServletRequest req, HttpServletResponse resp) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            simpleDateFormat.parse(req.getParameter("startDate"));
            String homeCode = req.getParameter("name");
            String customerName = req.getParameter("customerName");
            String phoneNumber = req.getParameter("name");
            Date startDate = simpleDateFormat.parse(req.getParameter("startDate"));
            Long paymentMethodId = Long.parseLong(req.getParameter("category"));
            String note = req.getParameter("description");
            phongTroModel.create(homeCode, customerName, phoneNumber, startDate, paymentMethodId, note);
            resp.sendRedirect("/room");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
//
//    public void updateBook(HttpServletRequest req, HttpServletResponse resp) {
//        try {
//            Integer id = Integer.parseInt(req.getParameter("id"));
//            String name = req.getParameter("name");
//            String description = req.getParameter("description");
//            int price = Integer.parseInt(req.getParameter("price"));
//            int categoryId = Integer.parseInt(req.getParameter("categoryId"));
//            Book book = new Book();
//            book.setId(id);
//            book.setName(name);
//            book.setDescription(description);
//            book.setPrice(price);
//            book.setCategoryId(categoryId);
//            bookModel.updateBook(book);
//            resp.sendRedirect("/book");
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//    }

    public void renderRoomManager(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        this.searchRoom(req, resp);
        req.getRequestDispatcher("/views/room-list.jsp").forward(req, resp);
    }

    public void renderCreateRoom(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        List<HinhThucThanhToan> categoryDtoList = hinhThucThanhToanModel.getAllHinhThuc();
        req.setAttribute("lstCategory", categoryDtoList);
        req.getRequestDispatcher("/views/create_room.jsp").forward(req, resp);
    }

    public void searchRoom(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        String input = req.getParameter("input");
        int size = 10;
        Integer page = 1;
        if (req.getParameter("size") != null) {
            size = Integer.parseInt(req.getParameter("size"));
        }
        if (req.getParameter("page") != null) {
            page = Integer.parseInt(req.getParameter("page"));
        }
        PhongTroDto searchRoomDto = new PhongTroDto();
        searchRoomDto.setInput(input);
        searchRoomDto.setSize(size);
        searchRoomDto.setPage(page);
        List<PhongTro> roomList = phongTroModel.search(searchRoomDto);
        if (roomList != null && !roomList.isEmpty()) {
            int index = 1;
            DecimalFormat df = new DecimalFormat("#,###");
            for (PhongTro room : roomList) {
                room.setIndex(index++);
            }
            req.setAttribute("lstData", roomList);
        }
        int count = phongTroModel.count(searchRoomDto);
        getPaging(req, resp, count, size, page);
    }

//    public void renderListBooks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
//        List<Book> bookList = bookModel.getBooks();
//        Integer totalPage = 5;
//        Integer currentPage = 1;
//        req.setAttribute("listBooks", bookList);
//        req.setAttribute("totalPage", totalPage);
//        req.setAttribute("currentPage", currentPage);
//        req.getRequestDispatcher("views/room-list.jsp").forward(req, resp);
//    }

//    public void deleteBook(HttpServletRequest req, HttpServletResponse resp) {
//        try {
//            Integer id = Integer.parseInt(req.getParameter("id"));
//            bookModel.deleteBook(id);
//            resp.sendRedirect("/book");
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//    }


    protected PagingDto getPaging(HttpServletRequest req, HttpServletResponse resp, int count, int size, int page) {
        PagingDto pagingDto = new PagingDto();
        req.setAttribute("totalRow", count);
        pagingDto.setTotalRow(count);
        req.setAttribute("currentPage", page);
        pagingDto.setCurrentPage(page);
        BigDecimal bCount = new BigDecimal(count);
        BigDecimal bSize = new BigDecimal(size);
        // Thực hiện phép chia và làm tròn lên
        BigDecimal totalPage = bCount.divide(bSize, 0, RoundingMode.CEILING);
        req.setAttribute("totalPage", totalPage);
        pagingDto.setTotalPage(totalPage.intValue());

        int tabSize = 10;
        BigDecimal bTabSize = new BigDecimal(tabSize);
        BigDecimal countTab = totalPage.divide(bTabSize, 0, RoundingMode.CEILING);
        for (int tabIndex = 0; tabIndex < countTab.intValue(); tabIndex++) {
            int startValue = tabIndex * tabSize + 1;
            int endValue = (tabIndex + 1) * tabSize;
            if (page >= startValue && page <= endValue) {
                if (tabIndex == 0) {
                    req.setAttribute("firstTab", true);
                    pagingDto.setFirstTab(true);
                }
                if (tabIndex == countTab.intValue() - 1) {
                    req.setAttribute("lastTab", true);
                    pagingDto.setLastTab(true);
                }

                if (tabIndex == 0) {
                    startValue = 1;
                }
                if (tabIndex == countTab.intValue() - 1) {
                    endValue = startValue + totalPage.intValue() % tabSize - 1;
                }
                req.setAttribute("beginPage", startValue);
                pagingDto.setBeginPage(startValue);
                req.setAttribute("endPage", endValue);
                pagingDto.setEndPage(endValue);
                break;
            }
        }
        return pagingDto;
    }
}

