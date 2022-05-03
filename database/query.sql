use shopping;
insert vaitro (TENVAITRO) value ('admin');
select * from vaitro;
insert vaitro (TENVAITRO) value ('user');


insert taikhoan (IDVAITRO,USERNAME,PASSWORD) value ('1','TUI',sha(1));
select * from taikhoan;
insert taikhoan (IDVAITRO,USERNAME,PASSWORD) value ('2','aido',sha(1));
select * from taikhoan;

insert nguoidung (id_taikhoan, ho_ten_nv,Gioi_tinh,dia_chi,SDT) value ('1','an','m',' cantho','1234567890');
select * from nguoidung;
insert nguoidung (id_taikhoan, ho_ten_nv,Gioi_tinh,dia_chi,SDT) value ('2','cham','f',' cantho','1234567890');
select * from nguoidung;
insert sanpham (tensp, so_luong_ton_kho, don_gia) value ('giay','5','250000');
insert sanpham (tensp, so_luong_ton_kho, don_gia) value ('dep','5','100000');
insert sanpham (tensp, so_luong_ton_kho, don_gia) value ('ao','30','200000');
insert sanpham (tensp, so_luong_ton_kho, don_gia) value ('non','15','100000');
insert sanpham (tensp, so_luong_ton_kho, don_gia) value ('nhan','20','500000');
insert sanpham (tensp, so_luong_ton_kho, don_gia) value ('ao khoac','40','300000');

select * from sanpham;
SELECT * FROM sanpham where DAXOA is null;

INSERT INTO `giohanng` (`ID_NGUOIDUNG`, `NGAY_LAP`, `TONGTIENHOADON`) VALUES ( '2', '2022-04-26 17:12:43', '999999999');

select * from giohanng;

INSERT INTO `chitiethoadon` (`ID_SP`, `ID_GIOHANG`, `SO_LUONG`, `TONGTIENCHITIET`) VALUES ('3', '1', '3', '178000');
INSERT INTO `chitiethoadon` (`ID_SP`, `ID_GIOHANG`, `SO_LUONG`, `TONGTIENCHITIET`) VALUES ('2', '1', '3', '178000');
INSERT INTO `chitiethoadon` (`ID_SP`, `ID_GIOHANG`, `SO_LUONG`, `TONGTIENCHITIET`) VALUES ('1', '1', '3', '178000');
UPDATE SanPham SET TENSP='vay', SO_LUONG_TON_KHO='2', DON_GIA='100000' where ID_SP=1;
select * from sanpham where tensp like "%a%";