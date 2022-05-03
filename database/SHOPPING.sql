DROP DATABASE IF EXISTS SHOPPING;

CREATE DATABASE IF NOT EXISTS SHOPPING;
USE SHOPPING;
# -----------------------------------------------------------------------------
#       TABLE : VAITRO
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS VAITRO
 (
   IDVAITRO INTEGER(2) NOT NULL auto_increment ,
   TENVAITRO VARCHAR(64) NULL  
   , PRIMARY KEY (IDVAITRO) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : TAIKHOAN
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS TAIKHOAN
 (
   ID_TAIKHOAN INTEGER(2) NOT NULL auto_increment ,
   IDVAITRO INTEGER(2) NOT NULL  ,
   USERNAME CHAR(32) NULL  ,
   PASSWORD VARCHAR(256) NULL  
   , PRIMARY KEY (ID_TAIKHOAN) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE TAIKHOAN
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_TAIKHOAN_VAITRO
     ON TAIKHOAN (IDVAITRO ASC);

# -----------------------------------------------------------------------------
#       TABLE : SANPHAM
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS SANPHAM
 (
   ID_SP INTEGER(11) NOT NULL auto_increment ,
   TENSP VARCHAR(64) NULL  ,
   SO_LUONG_TON_KHO INTEGER(8) NULL  ,
   DON_GIA INTEGER(11) NULL  ,
   DAXOA BOOL NULL  
   , PRIMARY KEY (ID_SP) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : NGUOIDUNG
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS NGUOIDUNG
 (
   ID_NGUOIDUNG INTEGER(11) NOT NULL auto_increment ,
   ID_TAIKHOAN INTEGER(2) NOT NULL  ,
   HO_TEN_NV VARCHAR(64) NULL  ,
   GIOI_TINH CHAR(1) NULL  ,
   DIA_CHI VARCHAR(128) NULL  ,
   SDT CHAR(16) NULL  ,
   DA_XOA BOOL NULL  
   , PRIMARY KEY (ID_NGUOIDUNG) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE NGUOIDUNG
# -----------------------------------------------------------------------------


CREATE UNIQUE INDEX I_FK_NGUOIDUNG_TAIKHOAN
     ON NGUOIDUNG (ID_TAIKHOAN ASC);

# -----------------------------------------------------------------------------
#       TABLE : GIOHANNG
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS GIOHANNG
 (
   ID_GIOHANG INTEGER(11) NOT NULL auto_increment ,
   ID_NGUOIDUNG INTEGER(11) NOT NULL  ,
   NGAY_LAP DATETIME NULL  ,
   TONGTIENHOADON INTEGER(16) NULL  
   , PRIMARY KEY (ID_GIOHANG) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE GIOHANNG
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_GIOHANNG_NGUOIDUNG
     ON GIOHANNG (ID_NGUOIDUNG ASC);

# -----------------------------------------------------------------------------
#       TABLE : CHITIETHOADON
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS CHITIETHOADON
 (
   ID_SP INTEGER(11) NOT NULL auto_increment ,
   ID_GIOHANG INTEGER(11) NOT NULL  ,
   SO_LUONG INTEGER(2) NULL  ,
   TONGTIENCHITIET INTEGER(16) NULL  
   , PRIMARY KEY (ID_SP,ID_GIOHANG) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE CHITIETHOADON
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_CHITIETHOADON_SANPHAM
     ON CHITIETHOADON (ID_SP ASC);

CREATE  INDEX I_FK_CHITIETHOADON_GIOHANNG
     ON CHITIETHOADON (ID_GIOHANG ASC);


# -----------------------------------------------------------------------------
#       CREATION DES REFERENCES DE TABLE
# -----------------------------------------------------------------------------


ALTER TABLE TAIKHOAN 
  ADD FOREIGN KEY FK_TAIKHOAN_VAITRO (IDVAITRO)
      REFERENCES VAITRO (IDVAITRO) ;


ALTER TABLE NGUOIDUNG 
  ADD FOREIGN KEY FK_NGUOIDUNG_TAIKHOAN (ID_TAIKHOAN)
      REFERENCES TAIKHOAN (ID_TAIKHOAN) ;


ALTER TABLE GIOHANNG 
  ADD FOREIGN KEY FK_GIOHANNG_NGUOIDUNG (ID_NGUOIDUNG)
      REFERENCES NGUOIDUNG (ID_NGUOIDUNG) ;


ALTER TABLE CHITIETHOADON 
  ADD FOREIGN KEY FK_CHITIETHOADON_SANPHAM (ID_SP)
      REFERENCES SANPHAM (ID_SP) ;


ALTER TABLE CHITIETHOADON 
  ADD FOREIGN KEY FK_CHITIETHOADON_GIOHANNG (ID_GIOHANG)
      REFERENCES GIOHANNG (ID_GIOHANG) ;

