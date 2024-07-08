USE QuanLySinhVien;
-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
SELECT * FROM Student where studentName like 'h%';

-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.
SELECT *
FROM class
WHERE MONTH(startDate) = 12;

-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
SELECT * FROM Subject where credit >=3 and credit <= 5;

-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
update Student
set ClassId = 2
where studentName = 'Hung';

-- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.
SELECT S.StudentName, Sub.SubName, M.Mark
FROM Student S, Mark M, Subject Sub
WHERE S.StudentId = M.StudentId and M.SubId = Sub.SubId
order by M.Mark DESC,S.StudentName;