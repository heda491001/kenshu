/*
* MySQL dump 10.13  Distrib 5.6.26, for osx10.8 (x86_64)
* Host: localhost    Database: ProductMaster
*/ 


/*  Autocommit mode false*/
SET AUTOCOMMIT = 0;

/*  Create user */
DROP USER 'tmuser';
CREATE USER tmuser IDENTIFIED BY 'tmuser';

/*  Create Database & Grant */
DROP DATABASE IF EXISTS `product_master`;
CREATE DATABASE `product_master`;

USE 'product_master';

GRANT ALL PRIVILEGES ON product_master.* TO tmuser IDENTIFIED BY 'tmuser';


/*  Table structure for table `tm_product_info`*/
DROP TABLE IF EXISTS `tm_product_info`;

CREATE TABLE `tm_product_info` (
  `prd_id` char(8) NOT NULL,
  `prd_type` varchar(10) NOT NULL,
  `prd_name` varchar(50) NOT NULL,
  `price` int(7) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `insert_date` date NOT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`prd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/*  Dumping data for table `tm_product_info` */
 
/* INSERT INTO `tm_product_info` VALUES ('tmb00001','���N�M','���N�MA',45000,'�y����E�C���N�ʔ���','2015-10-25',NULL),('tmb00002','���N�M','���N�MB',65000,'�y����E�C���N�ʔ���','2015-10-25',NULL),('tmb00003','���N�M','���N�MC',85000,'�y����E�C���N�ʔ���','2015-10-25',NULL),('tmb00004','���N�M','���N�MD',105000,'�y����E�C���N�ʔ���','2015-10-25',NULL),('tmb00005','���M','���MA(HB)',20,'�ˏ��C�`�I�V���i','2015-10-25',NULL),('tmb00006','���M','���MA(B)',20,'�ˏ��C�`�I�V���i','2015-10-25',NULL),('tmb00007','���M','���MA(2B)',20,'�ˏ��C�`�I�V���i','2015-10-25',NULL),('tmb00008','���M','���MA(3B)',20,'�ˏ��C�`�I�V���i','2015-10-25',NULL),('tmb00009','���M','���MA(4B)',20,'�ˏ��C�`�I�V���i','2015-10-25',NULL),('tmb00010','���M','���MB(HB)',25,NULL,'2015-10-25',NULL),('tmb00011','���M','���MB(B)',25,NULL,'2015-10-25',NULL),('tmb00012','���M','���MB(2B)',25,NULL,'2015-10-25',NULL),('tmb00013','���M','���MB(3B)',25,NULL,'2015-10-25',NULL),('tmb00014','���M','���MB(4B)',25,NULL,'2015-10-25',NULL),('tmb00015','���M','���MC(HB)',30,'�Z�[�����i','2015-10-25',NULL),('tmb00016','���M','���MC(B)',30,'�Z�[�����i','2015-10-25',NULL),('tmb00017','���M','���MC(2B)',30,'�Z�[�����i','2015-10-25',NULL),('tmb00018','���M','���MC(3B)',30,'�Z�[�����i','2015-10-25',NULL),('tmb00019','���M','���MC(4B)',30,'�Z�[�����i','2015-10-25',NULL),('tmb00020','���M','���MD(HB)',35,NULL,'2015-10-25',NULL),('tmb00021','���M','���MD(B)',35,NULL,'2015-10-25',NULL),('tmb00022','���M','���MD(2B)',35,NULL,'2015-10-25',NULL),('tmb00023','���M','���MD(3B)',35,NULL,'2015-10-25',NULL),('tmb00024','���M','���MD(4B)',35,NULL,'2015-10-25',NULL),('tmb00025','���M','���ME(HB)',40,NULL,'2015-10-25',NULL),('tmb00026','���M','���ME(B)',40,NULL,'2015-10-25',NULL),('tmb00027','���M','���ME(2B)',40,NULL,'2015-10-25',NULL),('tmb00028','���M','���ME(3B)',40,NULL,'2015-10-25',NULL),('tmb00029','���M','���ME(4B)',40,NULL,'2015-10-25',NULL),('tmb00030','���M','���MF(HB)',1500,'�ō������M�u�O�@�v�V���[�Y','2015-10-25',NULL),('tmb00031','���M','���MF(B)',1500,'�ō������M�u�O�@�v�V���[�Y','2015-10-25',NULL),('tmb00032','���M','���MF(2B)',1500,'�ō������M�u�O�@�v�V���[�Y','2015-10-25',NULL),('tmb00033','���M','���MF(3B)',1500,'�ō������M�u�O�@�v�V���[�Y','2015-10-25',NULL),('tmb00034','���M','���MF(4B)',1500,'�ō������M�u�O�@�v�V���[�Y','2015-10-25',NULL),('tmb00035','���M','�F���M�Z�b�gA(12�F)',500,'�ˏ��C�`�I�V���i','2015-10-25',NULL),('tmb00036','���M','�F���M�Z�b�gA(24�F)',1000,'�ˏ��C�`�I�V���i','2015-10-25',NULL),('tmb00037','���M','�F���M�Z�b�gA(36�F)',1500,'�ˏ��C�`�I�V���i','2015-10-25',NULL),('tmb00038','���M','�F���M�Z�b�gA(48�F)',2000,'�ˏ��C�`�I�V���i','2015-10-25',NULL),('tmb00039','���M','�F���M�Z�b�gB(12�F)',600,NULL,'2015-10-25',NULL),('tmb00040','���M','�F���M�Z�b�gB(24�F)',1200,NULL,'2015-10-25',NULL),('tmb00041','���M','�F���M�Z�b�gB(36�F)',1800,NULL,'2015-10-25',NULL),('tmb00042','���M','�F���M�Z�b�gB(48�F)',2400,NULL,'2015-10-25',NULL),('tmb00043','���M','�F���M�Z�b�gC(12�F)',700,'�Z�[�����i','2015-10-25',NULL),('tmb00044','���M','�F���M�Z�b�gC(24�F)',1400,'�Z�[�����i','2015-10-25',NULL),('tmb00045','���M','�F���M�Z�b�gC(36�F)',2100,'�Z�[�����i','2015-10-25',NULL),('tmb00046','���M','�F���M�Z�b�gC(48�F)',2800,'�Z�[�����i','2015-10-25',NULL),('tmb00047','���M','�F���M�Z�b�gD(12�F)',800,NULL,'2015-10-25',NULL),('tmb00048','���M','�F���M�Z�b�gD(24�F)',1600,NULL,'2015-10-25',NULL),('tmb00049','���M','�F���M�Z�b�gD(36�F)',2400,NULL,'2015-10-25',NULL),('tmb00050','���M','�F���M�Z�b�gD(48�F)',3200,NULL,'2015-10-25',NULL),('tmb00051','���M','�F���M�Z�b�gE(12�F)',900,NULL,'2015-10-25',NULL),('tmb00052','���M','�F���M�Z�b�gE(24�F)',1800,NULL,'2015-10-25',NULL),('tmb00053','���M','�F���M�Z�b�gE(36�F)',2700,NULL,'2015-10-25',NULL),('tmb00054','���M','�F���M�Z�b�gE(48�F)',3600,NULL,'2015-10-25',NULL),('tmb00055','���M','�F���M�Z�b�gF(12�F)',5000,'�ō����F���M�u�F�E�l�v�V���[�Y','2015-10-25',NULL),('tmb00056','���M','�F���M�Z�b�gF(24�F)',10000,'�ō����F���M�u�F�E�l�v�V���[�Y','2015-10-25',NULL),('tmb00057','���M','�F���M�Z�b�gF(36�F)',15000,'�ō����F���M�u�F�E�l�v�V���[�Y','2015-10-25',NULL),('tmb00058','���M','�F���M�Z�b�gF(48�F)',20000,'�ō����F���M�u�F�E�l�v�V���[�Y','2015-10-25',NULL),('tmb00059','�V���[�y��','�V���[�y��A',80,NULL,'2015-10-25',NULL),('tmb00060','�V���[�y��','�V���[�y��B',90,'�ˏ��E����MVP���i','2015-10-25',NULL),('tmb00061','�V���[�y��','�V���[�y��C',100,NULL,'2015-10-25',NULL),('tmb00062','�V���[�y��','�V���[�y��D',110,NULL,'2015-10-25',NULL),('tmb00063','�V���[�y��','�V���[�y��E',120,NULL,'2015-10-25',NULL),('tmb00064','�V���[�y��','�V���[�y��F',150,NULL,'2015-10-25',NULL),('tmb00065','�V���[�y��','�V���[�y��G',180,NULL,'2015-10-25',NULL),('tmb00066','�V���[�y��','�V���[�y��H',200,NULL,'2015-10-25',NULL),('tmb00067','�V���[�y��','�V���[�y��I',300,NULL,'2015-10-25',NULL),('tmb00068','�V���[�y��','�V���[�y��J',8000,'�ō����V���[�v�y���V���uSherlock�v�V���[�Y','2015-10-25',NULL),('tmb00069','�{�[���y��','�{�[���y��A',90,NULL,'2015-10-25',NULL),('tmb00070','�{�[���y��','�{�[���y��B',100,'�ˏ��E����MVP���i','2015-10-25',NULL),('tmb00071','�{�[���y��','�{�[���y��C',110,NULL,'2015-10-25',NULL),('tmb00072','�{�[���y��','�{�[���y��D',120,NULL,'2015-10-25',NULL),('tmb00073','�{�[���y��','�{�[���y��E',150,'�i�؂ꒆ�B������׎�������B','2015-10-25',NULL),('tmb00074','�{�[���y��','�{�[���y��E',180,'�i�؂ꒆ�B������׎�������B','2015-10-25',NULL),('tmb00075','�{�[���y��','�{�[���y��E',200,'�i�؂ꒆ�B������׎�������B','2015-10-25',NULL),('tmb00076','�{�[���y��','�{�[���y��E',250,NULL,'2015-10-25',NULL),('tmb00077','�{�[���y��','�{�[���y��E',300,NULL,'2015-10-25',NULL),('tmb00078','�{�[���y��','�{�[���y��E',500,NULL,'2015-10-25',NULL),('tmb00079','�{�[���y��','�{�[���y��E',1000,NULL,'2015-10-25',NULL),('tmb00080','�{�[���y��','�{�[���y��E',10000,'�ō����{�[���y���uElizabeth�v�V���[�Y','2015-10-25',NULL),('tmb00081','�����S��','�����S��A�i���j',50,'�ˏ��C�`�I�V���i','2015-10-25',NULL),('tmb00082','�����S��','�����S��A�i���j',100,'�ˏ��C�`�I�V���i','2015-10-25',NULL),('tmb00083','�����S��','�����S��A�i��j',150,'�ˏ��C�`�I�V���i','2015-10-25',NULL),('tmb00084','�����S��','�����S��A�i����j',200,'�ˏ��C�`�I�V���i','2015-10-25',NULL),('tmb00085','�����S��','�����S��B�i���j',70,NULL,'2015-10-25',NULL),('tmb00086','�����S��','�����S��B�i���j',140,NULL,'2015-10-25',NULL),('tmb00087','�����S��','�����S��C�i��j',210,NULL,'2015-10-25',NULL),('tmb00088','�����S��','�����S��D�i����j',280,NULL,'2015-10-25',NULL),('tmb00089','�����S��','�����S��A�i���j',100,'�ˏ��E�I�u�E�U�E�C���[�Q�N�A�����','2015-10-25',NULL),('tmb00090','�����S��','�����S��B�i���j',200,'�ˏ��E�I�u�E�U�E�C���[�Q�N�A�����','2015-10-25',NULL),('tmb00091','�����S��','�����S��C�i��j',300,'�ˏ��E�I�u�E�U�E�C���[�Q�N�A�����','2015-10-25',NULL),('tmb00092','�����S��','�����S��D�i����j',400,'�ˏ��E�I�u�E�U�E�C���[�Q�N�A�����','2015-10-25',NULL),('tmb00093','�����S��','�����S��A�i���j',1000,'�ō��������S���u���P�v�V���[�Y','2015-10-25',NULL),('tmb00094','�����S��','�����S��B�i���j',2000,'�ō��������S���u���P�v�V���[�Y','2015-10-25',NULL),('tmb00095','�����S��','�����S��C�i��j',3000,'�ō��������S���u���P�v�V���[�Y','2015-10-25',NULL),('tmb00096','�����S��','�����S��D�i����j',4000,'�ō��������S���u���P�v�V���[�Y','2015-10-25',NULL),('tmb00097','�����S��','����t�������S��A',100,'2014�N�x �ˏ��E�I�u�E�U�E�C���[��܏��i','2015-10-25',NULL),('tmb00098','�����S��','����t�������S��B',200,'2014�N�x �ˏ��E�I�u�E�U�E�C���[��܏��i','2015-10-25',NULL),('tmb00099','�����S��','����t�������S��C',300,'2014�N�x �ˏ��E�I�u�E�U�E�C���[��܏��i','2015-10-25',NULL),('tmb00100','�����S��','����t�������S��D',400,'2014�N�x �ˏ��E�I�u�E�U�E�C���[��܏��i','2015-10-25',NULL);
*/
LOAD DATA INFILE "C:/dbddl/product_list.csv"
INTO TABLE tm_product_info FIELDS TERMINATED BY ","
LINES TERMINATED BY "\r\n";

UPDATE tm_product_info SET update_date = NULL;
COMMIT;

/*  Table structure for table `tm_user` */

DROP TABLE IF EXISTS `tm_user`;

CREATE TABLE `tm_user` (
  `user_id` char(5) NOT NULL,
   user_name varchar(20) NOT NULL,
  `password` varchar(8) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 
/*  Dumping data for table `tm_user` */

INSERT INTO `tm_user` VALUES ('tm001','�ˏ����Y','tm001'),('tm002','�Q�X�g','tm002');
COMMIT;
